package com.battcn.platform.controller.pub;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.battcn.platform.controller.BaseController;
import com.battcn.platform.entity.pub.MenuEntity;
import com.battcn.platform.entity.pub.OperateEntity;
import com.battcn.platform.service.pub.MenuService;
import com.battcn.platform.service.pub.OperateService;

@Controller
public class IndexController extends BaseController
{

	@Autowired
	MenuService menuService;
	@Autowired
	OperateService operateService;

	@RequestMapping("/op_{oper}_{id}")
	public String op(@PathVariable String oper, @PathVariable Integer id, HttpServletRequest request,
			HttpServletResponse response, Model model) throws Exception
	{
		OperateEntity operate = new OperateEntity();
		operate.setMenu(id);
		operate.setOp(oper);
		operate = this.operateService.findByOperate(operate);
		// 当前方法对应的菜单下面的操作对象
		if (operate == null)
		{
			return noright(request, response, model);
		} else
		{
			MenuEntity menu = this.menuService.findMenuByPrimaryKey(operate.getMenu());// 获取对应的菜单对象
			System.out.println(menu.getChannel() + "/" + operate.getOp() + ".shtml");
			return "redirect:" + menu.getChannel() + "/" + operate.getOp() + ".shtml";
			/*if ("list".equals(oper))
			{
				return "pub/"+menu.getChannel() + "/list";
			} else
			{
				return "forward:" + menu.getChannel() + "/" + operate.getOp() + ".shtml";
			}*/
		}
	}
}
