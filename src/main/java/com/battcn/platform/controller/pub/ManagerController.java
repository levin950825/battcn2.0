package com.battcn.platform.controller.pub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;
import com.battcn.platform.controller.BaseController;
import com.battcn.platform.entity.AjaxJson;
import com.battcn.platform.entity.DataGrid;
import com.battcn.platform.entity.pub.ManagerEntity;
import com.battcn.platform.service.pub.ManagerService;
import com.github.pagehelper.PageInfo;

import springfox.documentation.annotations.ApiIgnore;

@Controller
@RequestMapping("/pub/manager")
@ApiIgnore
public class ManagerController extends BaseController
{
	@Autowired
	private ManagerService managerService;

	@RequestMapping(value = "/list")
	public String list(Model model)
	{
		return "pub/manager/list";
	}

	@RequestMapping(value = "/edit")
	public String edit(Long id, Model model)
	{
		if (id != null)
		{
			model.addAttribute("dto", this.managerService.selectByPrimaryKey(id));
		}
		return "pub/manager/edit";
	}

	@RequestMapping(value = "/query")
	@ResponseBody
	public PageInfo<JSONObject> query(DataGrid grid,String name)
	{
		return this.managerService.queryManagerForList(grid,name);
	}

	@RequestMapping(value = "/save")
	@ResponseBody
	public AjaxJson save(@ModelAttribute(value = "dto") ManagerEntity dto) throws Exception
	{
		return this.managerService.save(dto);
	}

	@RequestMapping(value = "/remove")
	@ResponseBody
	public AjaxJson del(Long[] ids)
	{
		return this.managerService.batchDelete(ids);
	}


}
