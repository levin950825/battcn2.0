package com.battcn.util.http;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

/**
 * Cookie 辅助类
 * 
 * @author ht
 * 
 * 
 */
public class CookieUtils
{

	/**
	 * 
	 * @param request
	 * @param name
	 * @return
	 */
	public static String getValue(HttpServletRequest request, String name)
	{
		Assert.notNull(request);
		Cookie cookie = getCookie(request, name);
		if (cookie == null)
			return null;
		return cookie.getValue();
	}

	/**
	 * 获得cookie
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param name
	 *            cookie name
	 * @return if exist return cookie, else return null.
	 */
	public static Cookie getCookie(HttpServletRequest request, String name)
	{
		Assert.notNull(request);
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0)
		{
			for (Cookie c : cookies)
			{
				if (c.getName().equals(name))
				{
					return c;
				}
			}
		}
		return null;
	}

	/**
	 * 根据部署路径，将cookie保存在根目录。
	 * 
	 * @param request
	 * @param response
	 * @param name
	 * @param value
	 * @param expiry
	 * @return
	 */
	public static Cookie addCookie(HttpServletRequest request, HttpServletResponse response, String name, String value,
			Integer expiry)
	{
		Cookie cookie = new Cookie(name, value);
		if (expiry != null)
		{
			cookie.setMaxAge(expiry);
		}
		String ctx = request.getContextPath();
		cookie.setPath(StringUtils.isBlank(ctx) ? "/" : ctx);
		response.addCookie(cookie);
		return cookie;
	}

	/**
	 * 取消cookie
	 * 
	 * @param response
	 * @param name
	 * @param domain
	 */
	public static void cancelCookie(HttpServletRequest request, HttpServletResponse response, String name)
	{
		Cookie cookie = new Cookie(name, null);
		cookie.setMaxAge(0);
		String ctx = request.getContextPath();
		cookie.setPath(StringUtils.isBlank(ctx) ? "/" : ctx);
		response.addCookie(cookie);
	}
}
