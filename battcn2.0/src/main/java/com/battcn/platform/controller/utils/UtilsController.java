package com.battcn.platform.controller.utils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.battcn.platform.controller.BaseController;

import springfox.documentation.annotations.ApiIgnore;

/**
 * @ClassName: CreateCodeController
 * @Description: 代码生成器
 * @author 唐亚峰
 * @date 2016年10月9日
 */
@Controller
@ApiIgnore
public class UtilsController extends BaseController
{
	@RequestMapping(value = "/utils/json/list")
	public String serialize()
	{
		return "utils/json/list";
	}
	
	@RequestMapping(value = "/utils/docs/list")
	public String docs()
	{
		//return "redirect:/springfox/index.html";
		return "utils/docs/list";
	}
	
}
