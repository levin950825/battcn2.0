package com.battcn.platform.controller.pub;

import java.io.FileNotFoundException;
import java.io.OutputStream;

import javax.annotation.Resource;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/pub/logs")
@Controller
@Api(value = "logs", description = "日志管理")
public class LogsController extends BaseController
{
	@Resource
	LogsService logsService;

	@RequestMapping(value = "/list")
	@SystemLog(description = "进入日志查询的页面", module = "日志模块", methods = "日志list")
	@ApiOperation( value = "跳转日志页面",hidden=true)
	public String list(Model model, DataGrid grid) throws Exception
	{
		return "pub/logs/list";
	}

	@RequestMapping(value = "/query")
	@ResponseBody
	@ApiOperation(value = "根据分页条件查询分页的结果集", httpMethod = "GET", produces = "application/json")
	@ApiResponses(value={
			@ApiResponse(code = 200, message = "请求成功"),
			@ApiResponse(code = 404, message = "地址错误"),
			@ApiResponse(code = 500, message = "系统错误,请联系管理人员")
	})
	public PageInfo<LogsEntity> query(DataGrid grid)
	{
		return this.logsService.queryLogsForList(grid);	
	}

	/**
	 * @Description: 采用网上大神的POI操作,速度杠杠的：http://git.oschina.net/jueyue/easypoi<br>
	 * @param 参数
	 * @return void 返回类型
	 * @throws FileNotFoundException
	 */
	@RequestMapping(value = "/export")
	@ResponseBody
	@ApiOperation( value = "日志导出",hidden=true)
	public void export(HttpServletResponse response) throws Exception
	{
		Workbook workBook = ExcelExportUtil.exportExcel(new ExportParams("系统日志", "日志详情"), LogsEntity.class,this.logsService.exportLogExcel());
		String fileName = "系统日志.xlsx";
		response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1" ));  
        response.setContentType("application/vnd.ms-excel");  
        OutputStream os = response.getOutputStream();  
        workBook.write(os);  
        os.flush();  
        os.close();  
	}

}
