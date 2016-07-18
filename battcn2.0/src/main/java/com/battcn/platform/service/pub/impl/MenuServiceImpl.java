package com.battcn.platform.service.pub.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.battcn.platform.entity.DataGrid;
import com.battcn.platform.entity.pub.ManagerEntity;
import com.battcn.platform.entity.pub.MenuEntity;
import com.battcn.platform.entity.pub.OperateEntity;
import com.battcn.platform.mapper.pub.AuthMapper;
import com.battcn.platform.mapper.pub.MenuMapper;
import com.battcn.platform.mapper.pub.OperateMapper;
import com.battcn.platform.service.BaseService;
import com.battcn.platform.service.pub.MenuService;
import com.battcn.util.TreeNode;
import com.github.pagehelper.PageInfo;

/**
 * 
 * 菜单权限
 *
 */
@Service
public class MenuServiceImpl extends BaseService<MenuEntity> implements
		MenuService
{

	@Autowired
	AuthMapper authMapper;
	@Autowired
	OperateMapper operateMapper;
	@Autowired
	MenuMapper menuMapper;

	@Override
	public List<TreeNode> listTree(ManagerEntity manager)
	{
		JSONObject map = new JSONObject();
		Long accountid = manager.getManagerid();
		map.put("accountid", accountid);
		List<JSONObject> list = this.authMapper.getChildMenuInPermission(map);
		return createTree(list, accountid);
	}

	private List<TreeNode> createTree(List<JSONObject> l, Long accountid)
	{
		List<TreeNode> tree = new ArrayList<TreeNode>();
		List<JSONObject> list = null;
		for (JSONObject a : l)
		{
			TreeNode t = new TreeNode();
			t.setId(a.getString("id"));
			t.setText(a.getString("name"));
			JSONObject map = new JSONObject();
			map.put("img", a.getString("img"));
			t.setAttributes(map);
			if (accountid == null)
			{
				try
				{
					list = this.authMapper.getParentMenu(a.getString("id"));
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			} else
			{
				JSONObject m2 = new JSONObject();
				m2.put("menuid", a.get("id"));
				m2.put("accountid", accountid);
				list = this.authMapper.getChildMenuInPermission(m2);
			}
			if (!list.isEmpty())
			{
				t.setChildren(createTree(list, accountid));
			}
			tree.add(t);
		}
		return tree;
	}

	@Override
	public List<JSONObject> getAll()
	{
		List<JSONObject> result = new ArrayList<JSONObject>();
		MenuEntity m = new MenuEntity();
		m.setState(true);
		List<MenuEntity> list = this.queryObjectForList(m);
		for (MenuEntity menu : list)
		{
			JSONObject map = new JSONObject();
			map.put("id", menu.getId());
			map.put("pId", menu.getPid());
			map.put("name", menu.getName());
			map.put("open", true);
			OperateEntity operate = new OperateEntity();
			operate.setMenu(menu.getId());
			List<OperateEntity> oplist = this.operateMapper.select(operate);
			map.put("operates", oplist);
			result.add(map);
		}
		return result;
	}

	@Override
	public MenuEntity findMenuByPrimaryKey(Integer key)
	{
		return this.menuMapper.findMenuByPrimaryKey(key);
	}

	@Override
	public boolean saveOrUpdate(MenuEntity entity)
	{
		if (entity.getId() != null)
		{
			return this.updateByPrimaryKey(entity);
		}
		return this.insertSelective(entity);
	}

	@Override
	public void batchDeleteMenu(Integer[] ids)
	{
		for (int i = 0; i < ids.length; i++)
		{
			this.menuMapper.deleteMenu(ids[i]);
		}
	}

	@Override
	public PageInfo<MenuEntity> queryForDataGrid(DataGrid grid)
	{
		grid.setSort("scort");
		return super.queryForDataGrid(grid);
	}
	
	

	@Override
	public List<MenuEntity> queryMenuByUserId(Long userId)
	{
		
		return null;
	}

	@Override
	public List<MenuEntity> queryMenuForList()
	{
		return this.menuMapper.selectAll();
	}

	@Override
	public List<JSONObject> queryAllUrlForList()
	{
		return this.authMapper.queryAllUrlForList();
	}
	
	@Override
	public List<String> queryPermissionForList(Long userId)
	{
		return this.authMapper.queryPermissionForList(userId);
	}

}
