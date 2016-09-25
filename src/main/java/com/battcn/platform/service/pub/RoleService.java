package com.battcn.platform.service.pub;

import org.springframework.ui.Model;

import com.battcn.platform.entity.AjaxJson;
import com.battcn.platform.entity.DataGrid;
import com.battcn.platform.entity.pub.RoleEntity;
import com.github.pagehelper.PageInfo;

public interface RoleService
{
	PageInfo<RoleEntity> queryRoleForList(DataGrid grid);

	AjaxJson batchDelete(Integer[] ids);

	AjaxJson save(RoleEntity dto,Integer operates[]);
	
	void getRoleOperate(Model model,Integer id);
	
}
