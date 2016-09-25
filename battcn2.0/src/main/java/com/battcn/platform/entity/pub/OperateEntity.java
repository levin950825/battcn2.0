package com.battcn.platform.entity.pub;

import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "t_sys_operate")
public class OperateEntity implements java.io.Serializable
{
	@Transient
	private static final long serialVersionUID = 1564785593898723239L;
	private Integer id;
	private Integer menu;
	private String op;
	private String name;
	private String icon;
	private String remark;
	private Integer ordno;
	private Integer isshow;

	
	public OperateEntity()
	{
	}

	public OperateEntity(Integer menu, String op)
	{
		this.menu = menu;
		this.op = op;
	}

	
	
	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getMenu()
	{
		return menu;
	}

	public void setMenu(Integer menu)
	{
		this.menu = menu;
	}

	public String getOp()
	{
		return op;
	}

	public void setOp(String op)
	{
		this.op = op;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getIcon()
	{
		return icon;
	}

	public void setIcon(String icon)
	{
		this.icon = icon;
	}

	public String getRemark()
	{
		return this.remark;
	}

	public void setRemark(String remark)
	{
		this.remark = remark;
	}

	public Integer getOrdno()
	{
		return this.ordno;
	}

	public void setOrdno(Integer ordno)
	{
		this.ordno = ordno;
	}

	public Integer getIsshow()
	{
		return this.isshow;
	}

	public void setIsshow(Integer isshow)
	{
		this.isshow = isshow;
	}

}