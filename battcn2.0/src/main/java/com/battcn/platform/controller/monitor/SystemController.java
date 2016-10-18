package com.battcn.platform.controller.monitor;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import springfox.documentation.annotations.ApiIgnore;

/**
 * @ClassName: SystemController
 * @Description: 系统监控
 * @author 唐亚峰
 * @date 2016年9月25日
 */
@Controller
@RequestMapping("/system")
@ApiIgnore
public class SystemController
{
	@Autowired
	private ServletContext servletContext;

	@RequestMapping(value = "/jvm")
	public String jvm()
	{
		return "monitor/system/jvm";
	}

	@RequestMapping(value = "/getAll")
	@ResponseBody
	public List<JSONObject> getAll()
	{
		List<JSONObject> list = new ArrayList<JSONObject>();
		Date date = new Date();
		for (int i = -19; i <= 0; i++)
		{
			JSONObject map = new JSONObject();
			map.put("x", date.getTime() + (i * 1000));
			map.put("y", (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 / 2024);
			list.add(map);
		}
		return list;
	}

	@RequestMapping(value = "/getJVM")
	@ResponseBody
	public JSONObject geta()
	{
		Date date = new Date();
		JSONObject map = new JSONObject();
		map.put("x", date.getTime());
		map.put("y", (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 / 1024);
		return map;
	}

	@RequestMapping(value = "/druid/list")
	public String druid()
	{
		return "/monitor/druid/list";
	}

	@RequestMapping(value = "/monitor/list")
	public String monitor(HttpServletRequest request) throws UnknownHostException
	{
		JSONObject outDto = new JSONObject();
		InetAddress localhost = InetAddress.getLocalHost();
		outDto.put("a.操作系统", System.getProperty("os.name") + "_" + System.getProperty("os.arch"));
		outDto.put("b.主机IP", "" + localhost.getHostAddress());
		outDto.put("c.应用服务器", servletContext.getServerInfo());
		outDto.put("d.监听端口", request.getServerPort());
		outDto.put("e.Web根路径", servletContext.getRealPath("/"));
		outDto.put("f.Servlet版本", servletContext.getMajorVersion() + "." + servletContext.getMinorVersion());
		outDto.put("g.JVM版本", System.getProperty("java.version"));
		outDto.put("h.JVM提供商", System.getProperty("java.vendor"));
		outDto.put("i.JVM安装路径", System.getProperty("java.home"));
		outDto.put("k.JVM可用最大内存", Runtime.getRuntime().maxMemory() / 1024 / 1024 + "M");
		request.setAttribute("d", outDto);
		return "monitor/system/list";
	}
}
