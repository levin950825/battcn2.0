package com.battcn.platform.entity.pub;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelTarget;

@Table(name = "t_sys_logs")
@ExcelTarget("courseEntity")
public class LogsEntity implements java.io.Serializable
{

	private static final long serialVersionUID = -1285002170637971804L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	@Excel(name = "账号")
	private String account;
	@Excel(name = "模块",width=15)
	private String title;
	@Excel(name = "详情")
	private String message;
	private Date optime;
	@Excel(name = "操作者IP",width=20)
	private String ip;
	private String params;
	@Excel(name = "请求地址",width=35)
	private String url;
	@Excel(name = "方法耗时",width=10)
	private Long duration;
	@Excel(name = "执行方法")
	private String methods;

	public LogsEntity()
	{
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getAccount()
	{
		return this.account;
	}

	public void setAccount(String account)
	{
		this.account = account;
	}

	public String getTitle()
	{
		return this.title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getMessage()
	{
		return this.message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public Date getOptime()
	{
		return this.optime;
	}

	public void setOptime(Date optime)
	{
		this.optime = optime;
	}

	public String getIp()
	{
		return this.ip;
	}

	public void setIp(String ip)
	{
		this.ip = ip;
	}

	public String getParams()
	{
		return params;
	}

	public void setParams(String params)
	{
		this.params = params;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public Long getDuration()
	{
		return duration;
	}

	public void setDuration(Long duration)
	{
		this.duration = duration;
	}

	public String getMethods()
	{
		return methods;
	}

	public void setMethods(String methods)
	{
		this.methods = methods;
	}
	

}