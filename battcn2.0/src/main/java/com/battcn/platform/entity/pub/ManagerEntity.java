package com.battcn.platform.entity.pub;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * TManager entity. @author MyEclipse Persistence Tools
 */
@Table(name = "t_sys_manager")
public class ManagerEntity implements java.io.Serializable
{

	private static final long serialVersionUID = 8828442426459020690L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "managerid", unique = true, nullable = false)
	private Integer managerid;
	private Integer role;
	private String account;
	private String password;
	private String name;
	private Boolean state;
	private Integer logintimes;
	private String lastloginip;
	private Timestamp lastlogintime;
	private String photo;

	// Constructors

	/** default constructor */
	public ManagerEntity()
	{
	}

	/** minimal constructor */
	public ManagerEntity(String account, String password, Boolean state)
	{
		this.account = account;
		this.password = password;
		this.state = state;
	}

	public Integer getManagerid()
	{
		return this.managerid;
	}

	public void setManagerid(Integer managerid)
	{
		this.managerid = managerid;
	}

	public Integer getRole()
	{
		return role;
	}

	public void setRole(Integer role)
	{
		this.role = role;
	}

	public String getAccount()
	{
		return this.account;
	}

	public void setAccount(String account)
	{
		this.account = account;
	}

	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Boolean getState()
	{
		return this.state;
	}

	public void setState(Boolean state)
	{
		this.state = state;
	}

	public Integer getLogintimes()
	{
		return logintimes;
	}

	public void setLogintimes(Integer logintimes)
	{
		this.logintimes = logintimes;
	}

	public String getLastloginip()
	{
		return this.lastloginip;
	}

	public void setLastloginip(String lastloginip)
	{
		this.lastloginip = lastloginip;
	}

	public Timestamp getLastlogintime()
	{
		return this.lastlogintime;
	}

	public void setLastlogintime(Timestamp lastlogintime)
	{
		this.lastlogintime = lastlogintime;
	}

	public String getPhoto()
	{
		return photo;
	}

	public void setPhoto(String photo)
	{
		this.photo = photo;
	}

	@Transient
	public boolean getIssuper()
	{
		return this.managerid == 1;
	}

}