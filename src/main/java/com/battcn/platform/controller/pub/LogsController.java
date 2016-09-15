package com.battcn.platform.controller.pub;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
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
	@SystemLog(description = "进入日志查询的页面", module = "日志模块", methods = "日志list")
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

	/**
	 * @Description: 采用网上大神的POI操作,速度杠杠的：http://git.oschina.net/jueyue/easypoi
	 *               <br>
	 * @param 参数
	 * @return void 返回类型
	 * @throws FileNotFoundException
	 */
	@RequestMapping(value = "/export")
	@ResponseBody
	public void export(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		Workbook workBook = ExcelExportUtil.exportExcel(new ExportParams("系统日志", "日志详情"), LogsEntity.class,this.logsService.exportLogExcel());
		String fileName = "F:/系统日志.xlsx";
		response.setContentType("application/ms-excel");
		response.setHeader("Content-Disposition","attachment;filename=" + new String(fileName.getBytes(), "UTF-8"));
		FileOutputStream fos = new FileOutputStream(fileName);
		// 把相应的Excel 工作簿存盘
		workBook.write(fos);
		fos.flush();
		fos.close();
	}

}
