package com.battcn.platform.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.battcn.platform.constant.Constant;

public class BaseController
{
	static final String SUCCESS = "success";
	static final String ERROR = "error";
	static final String EXCEPTION = "exception";

	Logger logger = Logger.getLogger(BaseController.class);

	// @Autowired public ResourcesService resourcesService;

	/**
	 * 获取返回某一页面的按扭组,
	 * 
	 * @throws Exception
	 */
	/*public List<ResourcesEntity> findResByUser()
	{
		try
		{
			ManagerEntity infoForm = SessionUtil.getSession();
			Map<String, String> queryMap = new HashMap<String, String>();
			queryMap.put("userId", String.valueOf(infoForm.getManagerid()));
			queryMap.put("parentId", getParameter("id"));
			return null;
		} catch (Exception e)
		{
			logger.error("--basecontroller --error---", e);
		}
		return null;
	}*/

	protected String noright(HttpServletRequest request, HttpServletResponse response, Model model)
	{
		String requestType = request.getHeader("X-Requested-With");
		if ("XMLHttpRequest".equals(requestType))
		{
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/json");
			response.setDateHeader("Expires", 0);
			try
			{
				response.setContentType("json");
				response.getWriter().write("{\"noRight\": true}");
			} catch (IOException e)
			{
				e.printStackTrace();
			}
			request.setAttribute(Constant.MESSAGE, "没有权限,请联想管理员哦");
			return null;
		} else
		{
			request.setAttribute(Constant.MESSAGE, "没有权限,请联想管理员哦");
			return Constant.ERROR;
		}
	}

	/**
	 * 获取页面传递的某一个参数值,
	 */
	public String getParameter(String key)
	{
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		return request.getParameter(key);
	}

	/**
	 * 获取HttpServletRequest;
	 * 
	 * @return [参数说明]
	 * 
	 * @return HttpServletRequest [返回类型说明]
	 * @exception throws
	 *                [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	public static HttpServletRequest getHttpRequest()
	{
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}
}
