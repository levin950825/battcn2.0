package com.battcn.platform.controller.pub;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.battcn.annotation.SystemLog;
import com.battcn.platform.controller.BaseController;
import com.battcn.platform.entity.DataGrid;
import com.battcn.platform.entity.pub.LogsEntity;
import com.battcn.platform.service.pub.LogsService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/pub/logs")
public class LogsController extends BaseController
{
	@Resource
	LogsService logsService;

	@RequestMapping(value = "/list")
	@SystemLog(description="进入日志查询的页面",module="日志模块",methods="日志list")
	public String list(Model model, DataGrid grid) throws Exception
	{
		return "pub/logs/list";
	}

	@RequestMapping(value = "/query")
	@ResponseBody
	public PageInfo<LogsEntity> query(DataGrid grid)
	{
		return this.logsService.queryLogsForList(grid);
	}
}
