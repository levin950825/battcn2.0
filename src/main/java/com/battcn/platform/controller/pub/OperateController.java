package com.battcn.platform.controller.pub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.battcn.platform.controller.BaseController;
import com.battcn.platform.entity.AjaxJson;
import com.battcn.platform.entity.DataGrid;
import com.battcn.platform.entity.pub.OperateEntity;
import com.battcn.platform.service.pub.OperateService;
import com.github.pagehelper.PageInfo;

import springfox.documentation.annotations.ApiIgnore;

@Controller
@RequestMapping("/pub/operate")
@ApiIgnore
public class OperateController extends BaseController
{

	@Autowired OperateService operateService;
	
	@RequestMapping(value = "/list")
	public String list(Model model)
	{
		return "pub/operate/list";
	}
	
	@RequestMapping(value = "/query")
	@ResponseBody
	public PageInfo<JSONObject> query(DataGrid grid)
	{
		return this.operateService.queryOperateForList(grid);
	}

	@RequestMapping(value = "/edit")
	public String edit(OperateEntity dto, Model model)
	{
		if (dto != null)
		{
			model.addAttribute("dto", this.operateService.findByOperate(dto));
		}
		return "pub/operate/edit";
	}
	
	@RequestMapping(value = "/save")
	@ResponseBody
	public AjaxJson save(OperateEntity dto) 
	{
		return this.operateService.save(dto);
	}

	@RequestMapping(value = "/remove")
	@ResponseBody
	public AjaxJson del(String[] ids)
	{
		return this.operateService.deleteByOperate(ids);
	}

}
