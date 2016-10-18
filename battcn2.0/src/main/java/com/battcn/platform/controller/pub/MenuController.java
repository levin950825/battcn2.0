package com.battcn.platform.controller.pub;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.battcn.platform.controller.BaseController;
import com.battcn.platform.entity.AjaxJson;
import com.battcn.platform.entity.DataGrid;
import com.battcn.platform.entity.pub.MenuEntity;
import com.battcn.platform.service.pub.MenuService;

import springfox.documentation.annotations.ApiIgnore;


@Controller
@RequestMapping("/pub/menu")
@ApiIgnore
public class MenuController extends BaseController
{
	@Resource MenuService menuService;

	@RequestMapping(value = "/list")
	public String list(Model model,DataGrid grid) throws Exception
	{
		model.addAttribute("page", this.menuService.queryForDataGrid(grid));
		return "pub/menu/list";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(Integer id, ModelMap model) throws Exception
	{
		if (id != null)
		{
			model.addAttribute("dto", this.menuService.findMenuByPrimaryKey(id));
		}
		return "pub/menu/edit";
	}

	@RequestMapping(value = "/save")
	@ResponseBody
	public AjaxJson save(@ModelAttribute("dto") MenuEntity entity)
	{
		return this.menuService.saveOrUpdate(entity);
	}

	@RequestMapping(value = "/remove")
	@ResponseBody
	public AjaxJson del(Integer[] ids)
	{
		return this.menuService.batchDeleteMenu(ids);
	}
}
