package com.battcn.platform.service.pub;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.battcn.platform.entity.pub.ManagerEntity;
import com.battcn.platform.entity.pub.MenuEntity;
import com.battcn.util.TreeNode;

public interface MenuService
{
	public List<TreeNode> listTree(ManagerEntity manager);
	public List<MenuEntity> queryMenuForList();
	public List<MenuEntity> queryMenuByUserId(Long userId);
	public List<JSONObject> getAll();
	public MenuEntity findMenuByPrimaryKey(Integer key);
	boolean saveOrUpdate(MenuEntity entity);
	void batchDeleteMenu(Integer[] ids);
}
