package com.battcn.platform.controller.${upPack};

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.battcn.platform.controller.BaseController;
import com.battcn.platform.entity.AjaxJson;
import com.battcn.platform.entity.DataGrid;
import com.github.pagehelper.PageInfo;
import com.battcn.platform.entity.${upPack}.${proClass}Entity;
import com.battcn.platform.service.${upPack}.${proClass}Service;

/** 
 * 类名称：${proClass}Controller
 * 创建人：唐亚峰 
 * 创建时间：${nowDate?string("yyyy-MM-dd")}
 */
@Controller
@RequestMapping(value="/${proClassLower}")
public class ${proClass}Controller extends BaseController {
	
	@Resource ${proClass}Service ${proClassLower}Service;
	
	
	@RequestMapping(value = "/list")
	public String list(Model model)
	{
		return "${upPack}/list";
	}

	@RequestMapping(value = "/edit")
	public String edit(Object id, Model model)
	{
		if (id != null)
		{
			model.addAttribute("dto", this.${proClassLower}Service.selectByPrimaryKey(id));
		}
		return "${upPack}/edit";
	}

	@RequestMapping(value = "/query")
	@ResponseBody
	public PageInfo<JSONObject> query(DataGrid grid,${proClass}Entity dto)
	{
		return this.${proClassLower}Service.query${proClass}ForList(grid,dto);
	}

	@RequestMapping(value = "/save")
	@ResponseBody
	public AjaxJson save(${proClass}Entity dto) throws Exception
	{
		return this.${proClassLower}Service.save(dto);
	}

	@RequestMapping(value = "/remove")
	@ResponseBody
	public AjaxJson del(Object[] ids)
	{
		return this.${proClassLower}Service.batchDelete(ids);
	}
}
