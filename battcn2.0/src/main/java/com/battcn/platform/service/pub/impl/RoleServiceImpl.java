package com.battcn.platform.service.pub.impl;

import org.springframework.stereotype.Service;

import com.battcn.platform.entity.AjaxJson;
import com.battcn.platform.entity.DataGrid;
import com.battcn.platform.entity.pub.RoleEntity;
import com.battcn.platform.service.BaseService;
import com.battcn.platform.service.pub.RoleService;
import com.github.pagehelper.PageInfo;

@Service
public class RoleServiceImpl extends BaseService<RoleEntity> implements
		RoleService
{

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
	public AjaxJson save(RoleEntity dto)
	{
		AjaxJson json = new AjaxJson();
		return json;
	}

}
