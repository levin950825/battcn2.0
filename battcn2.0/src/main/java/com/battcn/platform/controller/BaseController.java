package com.battcn.platform.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.battcn.platform.constant.Constant;
import com.battcn.platform.entity.pub.OperateEntity;
import com.battcn.platform.entity.pub.RoleOperateEntity;
import com.battcn.platform.service.pub.MenuService;
import com.battcn.platform.service.pub.RoleOperateService;
import com.battcn.util.SessionUtil;

public class BaseController
{
	static final String SUCCESS = "success";
	static final String ERROR = "error";
	static final String EXCEPTION = "exception";

	Logger logger = Logger.getLogger(BaseController.class);

	@Autowired RoleOperateService roleOperateService;
	@Autowired MenuService menuService;

	/**
	 * 获取返回某一页面的按扭组,
	 * 
	 * @throws Exception
	 */
	public void toolbar(Model model)
	{
		Integer menu = (Integer) SessionUtil.get();
		RoleOperateEntity dto = new RoleOperateEntity();
		dto.setRole(SessionUtil.getSession().getRole());
		dto.setMenu(menu);
		List<OperateEntity> op = this.roleOperateService.queryOperateForList(dto);
		model.addAttribute("operates", op);
		model.addAttribute("OP",op.get(0));
		model.addAttribute("MENU",this.menuService.findMenuByPrimaryKey(menu));// 获取对应的菜单对象
	}

	protected String noright(HttpServletRequest request, HttpServletResponse response)
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
