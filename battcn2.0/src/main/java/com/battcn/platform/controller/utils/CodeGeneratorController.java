package com.battcn.platform.controller.utils;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.battcn.platform.controller.BaseController;
import com.battcn.platform.entity.AjaxJson;
import com.battcn.platform.entity.code.CodeColumnEntity;
import com.battcn.platform.entity.code.CodeTableEntity;
import com.battcn.platform.service.utils.CodeGeneratorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @ClassName: CreateCodeController
 * @Description: 代码生成器
 * @author 唐亚峰
 * @date 2016年10月9日
 */
@Controller
@RequestMapping(value = "/utils/code")
@Api(value = "generator", description = "代码生成器")
public class CodeGeneratorController extends BaseController
{
	@Resource
	CodeGeneratorService codeGeneratorService;

	@RequestMapping(value = "/list")
	@ApiOperation( value = "",hidden=true)
	public String list()
	{
		return "utils/code/list";
	}

	@RequestMapping(value = "/edit")
	@ApiOperation( value = "",hidden=true)
	public String edit(String tid, Model model)
	{
		if (StringUtils.isNotEmpty(tid))
		{
			model.addAttribute("dto", codeGeneratorService.getCodeTableByUUID(tid));
		}
		return "utils/code/edit";
	}
	
	@RequestMapping(value = "/cedit")
	@ResponseBody
	@ApiOperation( value = "",hidden=true)
	public CodeColumnEntity edit(String tid, String cid)
	{
		return codeGeneratorService.getCodeColumnByUUID(tid,cid);
	}

	
	@RequestMapping(value = "/generate")
	@ResponseBody
	@ApiOperation(value = "代码生成器,根据配置的参数选项生成代码", httpMethod = "GET")
	@ApiResponses(value={
			@ApiResponse(code = 200, message = "请求成功"),
			@ApiResponse(code = 404, message = "地址错误"),
			@ApiResponse(code = 500, message = "系统错误,请联系管理人员")
	})
	public void generate(HttpServletResponse response,String uuid) throws Exception
	{
		this.codeGeneratorService.generateCode(response, uuid);
	}
	
	@RequestMapping(value = "/query")
	@ResponseBody
	@ApiOperation( value = "",hidden=true)
	public List<?> query(String tid)
	{
		return this.codeGeneratorService.queryCodeForList(tid);
	}

	@RequestMapping(value = "/save")
	@ResponseBody
	@ApiOperation( value = "",hidden=true)
	public AjaxJson save(CodeTableEntity table)
	{
		return this.codeGeneratorService.saveOrUpdate(table);
	}
	@RequestMapping(value = "/csave")
	@ResponseBody
	@ApiOperation( value = "",hidden=true)
	public AjaxJson save(String tid,CodeColumnEntity column)
	{
		return this.codeGeneratorService.saveOrUpdateColumn(tid,column);
	}

	@RequestMapping(value = "/remove")
	@ResponseBody
	@ApiOperation( value = "",hidden=true)
	public AjaxJson del(String tid,String cid)
	{
		return null;
	}

}
