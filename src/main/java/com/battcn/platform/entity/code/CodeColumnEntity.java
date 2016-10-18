package com.battcn.platform.entity.code;

import java.util.Date;

/**
 * @ClassName: CodeColumnEntity
 * @Description:
 * @author 唐亚峰
 * @date 2016年10月9日
 */
public class CodeColumnEntity
{

	private String uuid;
	private String attributeName;
	private String attributeType;
	private String remake;
	private String defaultVal;
	private Date createDate;

	public String getUuid()
	{
		return uuid;
	}

	public void setUuid(String uuid)
	{
		this.uuid = uuid;
	}

	public String getAttributeName()
	{
		return attributeName;
	}

	public void setAttributeName(String attributeName)
	{
		this.attributeName = attributeName;
	}

	public String getAttributeType()
	{
		return attributeType;
	}

	public void setAttributeType(String attributeType)
	{
		this.attributeType = attributeType;
	}

	public String getRemake()
	{
		return remake;
	}

	public void setRemake(String remake)
	{
		this.remake = remake;
	}

	public String getDefaultVal()
	{
		return defaultVal;
	}

	public void setDefaultVal(String defaultVal)
	{
		this.defaultVal = defaultVal;
	}
	public Date getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}
}
