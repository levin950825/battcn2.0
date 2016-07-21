package com.battcn.platform.controller.pub;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.battcn.platform.controller.BaseController;
import com.battcn.platform.entity.AjaxJson;
import com.battcn.platform.entity.DataGrid;
import com.battcn.platform.entity.pub.RoleEntity;
import com.battcn.platform.service.pub.MenuService;
import com.battcn.platform.service.pub.RoleService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping(value = "/pub/role")
public class RoleController extends BaseController
{
	@Autowired
	private RoleService roleService;
	@Autowired
	private MenuService menuService;
	

	@RequestMapping(value = "/list")
	public String list()
	{
		return "pub/role/list";
	}

	@RequestMapping(value = "/edit")
	public String edit(Integer id, HttpServletRequest request,
			HttpServletResponse response, ModelMap model)
	{
		if (id != null)
		{
			// RoleEntity dto = roleService.findByPrimaryKey(id);
			// model.addAttribute("dto", dto);
			// Map map = new HashMap();
			// map.put("role", dto.getId());
			// List<Map> list =
			// this.roleService.queryForListByMybatis("RoleMapper.getRoleOperate",
			// map);
			// model.addAttribute("operates", list);
		}
		// List<Map> menus = new ArrayList<Map>();
		// model.addAttribute("menus", menuService.getAll());
		return "pub/role/edit";
	}

	@RequestMapping(value = "/query")
	@ResponseBody
	public PageInfo<RoleEntity> list(DataGrid grid)
	{
		return this.roleService.queryRoleForList(grid);
	}

	@RequestMapping(value = "/save")
	@ResponseBody
	public AjaxJson save(String[] operates,
			@ModelAttribute("dto") RoleEntity dto)
	{
		return this.roleService.save(dto);
	}

	@RequestMapping(value = "/remove")
	@ResponseBody
	public AjaxJson del(Integer[] ids)
	{
		return this.roleService.batchDelete(ids);
	}



}
