package com.battcn.platform.entity.pub;

import javax.persistence.Table;

@Table(name = "t_sys_role_operate")
public class RoleOperateEntity implements java.io.Serializable
{

	private static final long serialVersionUID = 7164734171717016145L;
	
	private Integer role;
	private Integer menu;
	private String op;

	public Integer getRole()
	{
		return role;
	}

	public void setRole(Integer role)
	{
		this.role = role;
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

}