package com.battcn.platform.service.pub;

import java.util.List;

import com.battcn.platform.entity.pub.MenuEntity;

import net.sf.json.JSONObject;

public interface MenuService
{
	public List<MenuEntity> queryMenuForList();
	public List<MenuEntity> queryMenuByUserId(Long userId);
	public List<JSONObject> getChildMenuInPermission(Integer menuid, Integer accountid) throws Exception;
	public List<JSONObject> getAll() throws Exception;
	public MenuEntity findMenuByPrimaryKey(Integer key) throws Exception;
	boolean saveOrUpdate(MenuEntity entity) throws Exception;
	void batchDeleteMenu(Integer[] ids) throws Exception;
}
