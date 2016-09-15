package com.battcn.platform.service.pub;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.battcn.platform.entity.AjaxJson;
import com.battcn.platform.entity.DataGrid;
import com.battcn.platform.entity.pub.ManagerEntity;
import com.battcn.platform.entity.pub.MenuEntity;
import com.battcn.util.TreeNode;
import com.github.pagehelper.PageInfo;

public interface MenuService
{
	public List<JSONObject> queryAllUrlForList();
	List<String> queryPermissionForList(Long userId);
	public List<TreeNode> listTree(ManagerEntity manager);
	public PageInfo<MenuEntity> queryForDataGrid(DataGrid grid);
	public List<MenuEntity> queryMenuByUserId(Long userId);
	public List<JSONObject> getAll();
	public MenuEntity findMenuByPrimaryKey(Integer key);
	AjaxJson saveOrUpdate(MenuEntity entity);
	AjaxJson batchDeleteMenu(Integer[] ids);
}
