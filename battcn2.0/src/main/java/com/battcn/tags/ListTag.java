package com.battcn.tags;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.DynamicAttributes;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.battcn.framework.mybatis.dao.MybatisSqlDao;
import com.battcn.util.spring.AppContextUtil;

public class ListTag extends BodyTagSupport implements DynamicAttributes
{

	private static final long serialVersionUID = -3007463448279167711L;
	private String var;
	private String namespace;
	private String param;
	private Iterator<?> iter;
	private final Map<String, Object> map = new HashMap<String, Object>();

	public int doStartTag() throws JspException
	{
		try
		{
			List<?> list = new ArrayList<>();
			//ApplicationContext appCtx = ContextLoader.getCurrentWebApplicationContext();
			//MybatisSqlDao mybatisSqlDao = (MybatisSqlDao) appCtx.getBean(MybatisSqlDao.class);
			MybatisSqlDao mybatisSqlDao = (MybatisSqlDao) AppContextUtil.getBean("mybatisSqlDaoImpl");
			// 获取对应的service 调用查询方法 返回结果给LIST
			list =  (List<?>) mybatisSqlDao.queryForList(namespace, StringUtils.isBlank(param) ? null : JSONObject.parseObject(param));
			if (list.isEmpty())
				return SKIP_BODY;
			// 表示如果未找到指定集合，则不用处理标签体，直接调用doEndTag()方法。
			iter = list.iterator();
			if (iter.hasNext())
			{
				pageContext.setAttribute(var, iter.next());
			}
			// 表示在现有的输出流对象中处理标签体，但绕过setBodyContent()和doInitBody()方法
			// 这里一定要返回EVAL_BODY_INCLUDE，否则标签体的内容不会在网页上输出显示
			return EVAL_BODY_INCLUDE;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	// 此方法被绕过不会被执行
	public void doInitBody() throws JspException
	{
		super.doInitBody();
	}

	public int doAfterBody() throws JspException
	{
		if (iter.hasNext())
		{
			pageContext.setAttribute(var, iter.next());
			return EVAL_BODY_AGAIN;// 如果集合中还有对像，则循环执行标签体
		}
		return SKIP_BODY;// 迭代完集合后，跳过标签体，调用doEndTag()方法。
	}

	public int doEndTag() throws JspException
	{
		return EVAL_PAGE;
	}

	public String getVar()
	{
		return var;
	}

	public void setVar(String var)
	{
		this.var = var;
	}

	public String getNamespace()
	{
		return namespace;
	}

	public void setNamespace(String namespace)
	{
		this.namespace = namespace;
	}

	public String getParam()
	{
		return param;
	}

	public void setParam(String param)
	{
		this.param = param;
	}

	public void setDynamicAttribute(String uri, String localName, Object value)
			throws JspException
	{
		map.put(localName, value);
	}
}
