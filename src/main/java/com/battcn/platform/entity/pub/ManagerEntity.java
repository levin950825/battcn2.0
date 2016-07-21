package com.battcn.platform.entity.pub;

import java.util.Date;

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
	private Long managerid;
	private Integer role;
	private String account;
	private String password;
	private String name;
	private String lastloginip;
	private Date lastlogintime;
	@Column(name = "credentialsSalt")
	private String credentialsSalt;
	private String locked;
	private String photo;

	public Long getManagerid()
	{
		return this.managerid;
	}

	public void setManagerid(Long managerid)
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

	public String getLastloginip()
	{
		return this.lastloginip;
	}

	public void setLastloginip(String lastloginip)
	{
		this.lastloginip = lastloginip;
	}

	public Date getLastlogintime()
	{
		return this.lastlogintime;
	}

	public void setLastlogintime(Date lastlogintime)
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

	public String getCredentialsSalt()
	{
		return credentialsSalt;
	}

	public void setCredentialsSalt(String credentialsSalt)
	{
		this.credentialsSalt = credentialsSalt;
	}

	public String getLocked()
	{
		return locked;
	}

	public void setLocked(String locked)
	{
		this.locked = locked;
	}

	@Transient
	public boolean getIssuper()
	{
		return this.managerid == 1;
	}

}