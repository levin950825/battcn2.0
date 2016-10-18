package com.battcn.platform.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.battcn.platform.service.pub.MenuService;
import com.battcn.platform.service.pub.RoleOperateService;

public class BaseController
{
	static final String SUCCESS = "success";
	static final String ERROR = "error";
	static final String EXCEPTION = "exception";

	Logger logger = Logger.getLogger(BaseController.class);

	@Autowired RoleOperateService roleOperateService;
	@Autowired MenuService menuService;

	/**
	 * 获取页面传递的某一个参数值,
	 */
	public String getParameter(String key)
	{
		return this.getRequest().getParameter(key);
	}
	/**
	 * 得到request对象
	 */
	public HttpServletRequest getRequest() 
	{
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		return request;
	}
}
