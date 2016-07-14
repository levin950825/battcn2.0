package com.battcn.platform.service.pub.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.battcn.platform.entity.pub.MenuEntity;
import com.battcn.platform.service.BaseService;
import com.battcn.platform.service.pub.MenuService;

import net.sf.json.JSONObject;

/**
 * 
 * 菜单权限
 *
 */
@Service
public class MenuServiceImpl extends BaseService<MenuEntity> implements MenuService
{

	
	
	@Override
	public List<JSONObject> getChildMenuInPermission(Integer menuid, Integer accountid) throws Exception
	{
		return null;
	}

	@Override
	public List<JSONObject> getAll() throws Exception
	{
		return null;
	}

	@Override
	public MenuEntity findMenuByPrimaryKey(Integer key) throws Exception
	{
		return null;
	}

	@Override
	public boolean saveOrUpdate(MenuEntity entity) throws Exception
	{
		return false;
	}

	@Override
	public void batchDeleteMenu(Integer[] ids) throws Exception
	{

	}

	@Override
	public List<MenuEntity> queryMenuForList()
	{
		return this.queryObjectForList();
	}

	@Override
	public List<MenuEntity> queryMenuByUserId(Long userId)
	{
		return null;
	}

}
