package com.battcn.platform.service.pub.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import com.battcn.platform.entity.AjaxJson;
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
public class MenuServiceImpl extends BaseService<MenuEntity> implements MenuService
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
		List<TreeNode> trees = new ArrayList<TreeNode>();
		List<JSONObject> list = this.authMapper.getChildMenuInPermission(manager.getRole());
		for (JSONObject obj : list)
		{
			if (StringUtils.isBlank(obj.getString("pid")))
			{
				TreeNode tree = new TreeNode();
				List<TreeNode> listTree = createTree(list, obj.getString("id"));
				if (listTree != null && listTree.size() > 0)
				{
					tree.setId(obj.getString("id"));
					tree.setText(obj.getString("name"));
					JSONObject map = new JSONObject();
					map.put("img", obj.getString("img"));
					tree.setAttributes(map);
					tree.setChildren(listTree);
					trees.add(tree);
				}
			}
		}
		return trees;
	}

	private List<TreeNode> createTree(List<JSONObject> l, String pid)
	{
		List<TreeNode> trees = new ArrayList<TreeNode>();
		for (JSONObject a : l)
		{
			if (pid.equals(a.getString("pid")))
			{
				TreeNode tree = new TreeNode();
				tree.setId(a.getString("id"));
				tree.setText(a.getString("name"));
				JSONObject map = new JSONObject();
				map.put("img", a.getString("img"));
				tree.setAttributes(map);
				trees.add(tree);
			}
		}
		return trees;
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
	public AjaxJson saveOrUpdate(MenuEntity dto)
	{
		AjaxJson json = new AjaxJson();
		Date date = new Date();
		if (dto.getId() == null)
		{
			dto.setAddtime(date);
			dto.setUpdatetime(date);
			this.insertSelective(dto);
		} else
		{
			dto.setUpdatetime(date);
			this.updateByPrimaryKey(dto);
		}
		this.menuMapper.treeNode();
		json.setSuccess(true);
		json.setMsg("保存成功！");
		return json;
	}

	@Override
	public AjaxJson batchDeleteMenu(Integer[] ids)
	{
		AjaxJson json = new AjaxJson();
		super.batchDeleteByPrimaryKey(ids);
		json.setSuccess(true);
		json.setMsg("删除成功！");
		return json;
	}

	@Override
	public PageInfo<MenuEntity> queryForDataGrid(DataGrid grid)
	{
		grid.setSort("scort");
		grid.setPageSize(100);
		return super.queryForDataGrid(grid);
	}

	@Override
	public List<MenuEntity> queryMenuByUserId(Long userId)
	{

		return null;
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
