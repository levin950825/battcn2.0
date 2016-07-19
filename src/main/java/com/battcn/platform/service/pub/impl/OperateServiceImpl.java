package com.battcn.platform.service.pub.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.battcn.platform.entity.AjaxJson;
import com.battcn.platform.entity.DataGrid;
import com.battcn.platform.entity.pub.OperateEntity;
import com.battcn.platform.mapper.pub.OperateMapper;
import com.battcn.platform.service.BaseService;
import com.battcn.platform.service.pub.OperateService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class OperateServiceImpl extends BaseService<OperateEntity> implements
		OperateService
{

	@Autowired
	OperateMapper operateMapper;

	@Override
	public OperateEntity findByOperate(OperateEntity entity)
	{
		return this.operateMapper.findOperateByOpAndMenu(entity);
	}

	@Override
	public PageInfo<JSONObject> queryOperateForList(DataGrid grid)
	{
		if (StringUtils.isNotEmpty(grid.getOrder())) {
			PageHelper.orderBy(grid.getSort() + "   " + grid.getOrder());
		} else {
			PageHelper.orderBy(" menu desc ");
		}
		PageHelper.startPage(grid.getPageNum(), grid.getPageSize());
		return new PageInfo<JSONObject>(this.operateMapper.queryOperateForList());
	}

	@Override
	public Boolean checkPermission(Integer menu, String op, Integer accountid)
	{
		return null;
	}

	@Override
	public List<OperateEntity> getOperatesInPermissionByMenu(Integer menuid,
			Integer accountid)
	{
		return null;
	}

	@Override
	public AjaxJson save(OperateEntity opt)
	{
		AjaxJson json = new AjaxJson();
		if (this.operateMapper.findOperateByOpAndMenu(opt) == null)
		{
			this.operateMapper.insertByOperate(opt);
		} else
		{
			this.operateMapper.updateByOperate(opt);
		}
		json.setSuccess(true);
		json.setMsg("保存成功！");
		return json;
	}

	@Override
	public AjaxJson deleteByOperate(String[] ids)
	{
		AjaxJson json = new AjaxJson();
		for (String tid : ids)
		{
			String[] tids = tid.split("-");
			OperateEntity dto = new OperateEntity(Integer.valueOf(tids[0]),
					tids[1]);
			this.operateMapper.deleteByOperate(dto);
		}
		json.setSuccess(true);
		json.setMsg("删除成功！");
		return json;
	}

}
