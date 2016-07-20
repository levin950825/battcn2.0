package com.battcn.util.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class AppContextUtil implements ApplicationContextAware
{

	private static ApplicationContext ctx = null;

	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException
	{
		AppContextUtil.ctx = ctx;
	}

	public static Object getBean(String beanName)
	{
		return ctx.getBean(beanName);
	}

}
