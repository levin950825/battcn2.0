package com.battcn.platform.entity.code;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: CodeEntity
 * @Description:
 * @author 唐亚峰
 * @date 2016年10月9日
 */
public class CodeTableEntity
{

	private String uuid;
	private String upPackage;// com.battcn.platform.controller.utils
	private String processorClass;// 类名首字母必须为大写字母或下划线 TestController
	private String tablePrefix;// t_mp_test
	private Date createDate;
	private List<CodeColumnEntity> columnList;

	

	public String getUuid()
	{
		return uuid;
	}

	public void setUuid(String uuid)
	{
		this.uuid = uuid;
	}

	public String getUpPackage()
	{
		return upPackage;
	}

	public void setUpPackage(String upPackage)
	{
		this.upPackage = upPackage;
	}

	public String getProcessorClass()
	{
		return processorClass;
	}

	public void setProcessorClass(String processorClass)
	{
		this.processorClass = processorClass;
	}

	public String getTablePrefix()
	{
		return tablePrefix;
	}

	public void setTablePrefix(String tablePrefix)
	{
		this.tablePrefix = tablePrefix;
	}

	public Date getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}

	public List<CodeColumnEntity> getColumnList()
	{
		return columnList;
	}

	public void setColumnList(List<CodeColumnEntity> columnList)
	{
		this.columnList = columnList;
	}

}
