package com.battcn.platform.service.pub.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.alibaba.fastjson.JSONObject;
import com.battcn.platform.entity.AjaxJson;
import com.battcn.platform.entity.DataGrid;
import com.battcn.platform.entity.pub.RoleEntity;
import com.battcn.platform.entity.pub.RoleOperateEntity;
import com.battcn.platform.mapper.pub.RoleMapper;
import com.battcn.platform.mapper.pub.RoleOperateMapper;
import com.battcn.platform.service.BaseService;
import com.battcn.platform.service.pub.RoleService;
import com.github.pagehelper.PageInfo;

@Service
public class RoleServiceImpl extends BaseService<RoleEntity> implements
		RoleService
{
	
	
	@Autowired RoleMapper roleMapper;
	@Autowired RoleOperateMapper roleOperateMapper;

	@Override
	public PageInfo<RoleEntity> queryRoleForList(DataGrid grid)
	{
		return this.queryForDataGrid(grid);
	}

	@Override
	public AjaxJson batchDelete(Integer[] ids)
	{
		AjaxJson json = new AjaxJson();
		super.batchDeleteByPrimaryKey(ids);
		json.setSuccess(true);
		json.setMsg("删除成功！");
		return json;
	}

	@Override
	public AjaxJson save(RoleEntity dto,Integer operates[])
	{
		AjaxJson json = new AjaxJson();
		boolean flag = false;
		if(dto.getId() != null)
		{
			flag = super.updateByPrimaryKey(dto);
			if(flag)
				this.roleMapper.deleteOperateByRole(dto.getId());
		}else
		{
			flag = insertSelective(dto);
		}
		if(flag && operates != null && operates.length > 0) {
			for(Integer opid : operates) {
				RoleOperateEntity roleOperate = new RoleOperateEntity();
				roleOperate.setRole(dto.getId());
				roleOperate.setOpId(opid);
				this.roleOperateMapper.insertSelective(roleOperate);
			}
		}
		json.setSuccess(true);
		json.setMsg("保存成功！");
		return json;
	}

	@Override
	public void getRoleOperate(Model model,Integer id)
	{
		 RoleEntity dto = super.selectByPrimaryKey(id);
		 if(dto != null)
		 {
			 model.addAttribute("dto", dto);
			 JSONObject map = new JSONObject();
			 map.put("role", dto.getId());
			 List<JSONObject> list = this.roleMapper.getRoleOperate(dto.getId());
			 model.addAttribute("ops", list);
		 }
	}

	
	
	
	
	
}
