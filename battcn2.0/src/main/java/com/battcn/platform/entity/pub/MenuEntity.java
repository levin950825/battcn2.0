package com.battcn.platform.entity.pub;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "t_sys_menu")
public class MenuEntity implements java.io.Serializable
{
	@Transient
	private static final long serialVersionUID = 3487796343353286350L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	private Integer pid;
	private String name;
	private String remark;
	private String img;
	private String channel;
	private String param;
	private Date addtime;
	private Date updatetime;
	private Boolean state;
	private Integer ordno;
	private Integer nlevel;
	private String scort;


	/** default constructor */
	public MenuEntity()
	{
	}

	/** minimal constructor */
	public MenuEntity(String name, Timestamp addtime, Timestamp updatetime, Boolean state)
	{
		this.name = name;
		this.addtime = addtime;
		this.updatetime = updatetime;
		this.state = state;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getPid()
	{
		return pid;
	}

	public void setPid(Integer pid)
	{
		this.pid = pid;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getRemark()
	{
		return this.remark;
	}

	public void setRemark(String remark)
	{
		this.remark = remark;
	}

	public String getImg()
	{
		return this.img;
	}

	public void setImg(String img)
	{
		this.img = img;
	}

	public String getChannel()
	{
		return this.channel;
	}

	public void setChannel(String channel)
	{
		this.channel = channel;
	}

	public String getParam()
	{
		return param;
	}

	public void setParam(String param)
	{
		this.param = param;
	}

	public Date getAddtime()
	{
		return this.addtime;
	}

	public void setAddtime(Date addtime)
	{
		this.addtime = addtime;
	}

	public Date getUpdatetime()
	{
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime)
	{
		this.updatetime = updatetime;
	}

	public Boolean getState()
	{
		return this.state;
	}

	public void setState(Boolean state)
	{
		this.state = state;
	}

	public Integer getOrdno()
	{
		return this.ordno;
	}

	public void setOrdno(Integer ordno)
	{
		this.ordno = ordno;
	}

	public Integer getNlevel()
	{
		return this.nlevel;
	}

	public void setNlevel(Integer nlevel)
	{
		this.nlevel = nlevel;
	}

	public String getScort()
	{
		return this.scort;
	}

	public void setScort(String scort)
	{
		this.scort = scort;
	}

}