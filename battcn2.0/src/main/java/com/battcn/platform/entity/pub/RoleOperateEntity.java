package com.battcn.platform.entity.pub;

import javax.persistence.Table;

@Table(name = "t_sys_role_operate")
public class RoleOperateEntity implements java.io.Serializable
{

	private static final long serialVersionUID = 7164734171717016145L;

	private Integer role;
	private Integer op_id;

	public Integer getRole()
	{
		return role;
	}

	public void setRole(Integer role)
	{
		this.role = role;
	}

	public Integer getOp_id()
	{
		return op_id;
	}

	public void setOp_id(Integer op_id)
	{
		this.op_id = op_id;
	}

}