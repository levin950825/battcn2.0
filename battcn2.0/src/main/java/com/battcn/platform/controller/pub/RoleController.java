package com.battcn.platform.controller.pub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "/pub/role")
@Api(value = "role", description = "角色控制")
public class RoleController extends BaseController
{
	@Autowired
	private RoleService roleService;
	@Autowired
	private MenuService menuService;
	

	@RequestMapping(value = "/list")
	@ApiOperation( value = "",hidden=true)
	public String list()
	{
		return "pub/role/list";
	}

	@RequestMapping(value = "/edit")
	@ApiOperation( value = "",hidden=true)
	public String edit(Integer id,Model model)
	{
		if (id != null)
		{
			this.roleService.getRoleOperate(model, id);
		}
		model.addAttribute("menus", menuService.getAll());
		return "pub/role/edit";
	}

	@RequestMapping(value = "/query")
	@ResponseBody
	@ApiOperation( value = "",hidden=true)
	public PageInfo<RoleEntity> list(DataGrid grid)
	{
		return this.roleService.queryRoleForList(grid);
	}

	@RequestMapping(value = "/save")
	@ResponseBody
	@ApiOperation( value = "",hidden=true)
	public AjaxJson save(Integer[] operates,
			@ModelAttribute("dto") RoleEntity dto)
	{
		return this.roleService.save(dto,operates);
	}

	@RequestMapping(value = "/remove")
	@ResponseBody
	@ApiOperation( value = "",hidden=true)
	public AjaxJson del(Integer[] ids)
	{
		return this.roleService.batchDelete(ids);
	}



}
