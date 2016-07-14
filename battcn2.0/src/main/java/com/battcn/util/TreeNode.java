package com.battcn.util;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

public class TreeNode implements java.io.Serializable
{

	private static final long serialVersionUID = 7167292131071749703L;

	private String id;
	private String pid;
	private String text;
	private Boolean checked = Boolean.FALSE;
	private JSONObject attributes;
	private List<TreeNode> children = new ArrayList<TreeNode>();
	private String state = "open";// open,closed

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getPid()
	{
		return pid;
	}

	public void setPid(String pid)
	{
		this.pid = pid;
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public Boolean getChecked()
	{
		return checked;
	}

	public void setChecked(Boolean checked)
	{
		this.checked = checked;
	}

	public JSONObject getAttributes()
	{
		return attributes;
	}

	public void setAttributes(JSONObject attributes)
	{
		this.attributes = attributes;
	}

	public List<TreeNode> getChildren()
	{
		return children;
	}

	public void setChildren(List<TreeNode> children)
	{
		this.children = children;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

}
