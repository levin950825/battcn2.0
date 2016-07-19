package com.battcn.platform.controller.pub;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.battcn.platform.controller.BaseController;
import com.battcn.platform.entity.pub.MenuEntity;
import com.battcn.platform.service.pub.MenuService;
import com.battcn.util.SessionUtil;

@Controller
public class IndexController extends BaseController
{
	@Autowired
	MenuService menuService;

	@RequestMapping("/op_{oper}_{id}")
	public String op(@PathVariable String oper, @PathVariable Integer id,
			HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		MenuEntity menu = this.menuService.findMenuByPrimaryKey(id);// 获取对应的菜单对象
		if(menu != null)
		{
			SessionUtil.pub(id);
			//假设我在这里 设置一个值 但是 重定向到下个Controller中 返回到页面 拿不到
			System.out.println(menu.getChannel() + "/" + oper + ".shtml?OP_MENU="+id);//redirect  - forward
			return "redirect:" + menu.getChannel() + "/" + oper + ".shtml";
		}
		return noright(request, response);
	}
}
