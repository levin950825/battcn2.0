package com.battcn.platform.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.battcn.util.CommonUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;

import tk.mybatis.mapper.common.Mapper;

@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
@Service
public abstract class BaseService<T>
{

	@Autowired
	protected Mapper<T> mapper;

	public boolean insertSelective(T entity)
	{
		return this.mapper.insertSelective(entity) > 0 ? true : false;
	}

	public boolean deleteByPrimaryKey(Object key)
	{
		return this.mapper.deleteByPrimaryKey(key) > 0 ? true : false;
	}

	public boolean updateByPrimaryKey(T entity)
	{
		return this.mapper.updateByPrimaryKeySelective(entity) > 0 ? true : false;
	}

	public void batchDeleteByPrimaryKey(Object ids[])
	{
		for (int i = 0; i < ids.length; i++)
		{
			deleteByPrimaryKey(ids[i]);
		}
	}

	public T selectByPrimaryKey(Object key)
	{
		return this.mapper.selectByPrimaryKey(key);
	}

	/**
	 * 查询单个对象：如果多条记录则会抛出异常
	 * 
	 * @param entity
	 * @return
	 */
	public T findByObject(T entity)
	{
		return this.mapper.selectOne(entity);
	}

	public List<T> queryExampleForList(Object example)
	{
		return this.mapper.selectByExample(example);
	}

	public List<T> queryObjectForList(String order)
	{
		PageHelper.orderBy(order);
		return this.mapper.selectAll();
	}

	public List<T> queryObjectForList()
	{
		return this.mapper.selectAll();
	}

	/**
	 * 带条件查询所有
	 * 
	 * @param entity
	 * @return
	 */
	public List<T> queryObjectForList(T entity)
	{
		return this.mapper.select(entity);
	}

	public PageInfo<T> queryPageForList()
	{
		return queryPageForList(null);
	}

	public PageInfo<T> queryPageForList(T entity)
	{
		HttpServletRequest request = CommonUtil.getHttpRequest();
		Integer pageNum = CommonUtil.valueOf(request.getParameter("pageNum"), 1);
		Integer pageSize = CommonUtil.valueOf(request.getParameter("pageSize"), 10);
		PageHelper.startPage(pageNum, pageSize);
		String orderField = request.getParameter("sort");
		String orderDirection = request.getParameter("order");
		if (StringUtil.isNotEmpty(orderField))
		{
			PageHelper.orderBy(orderField);
			if (StringUtil.isNotEmpty(orderDirection))
			{
				PageHelper.orderBy(orderField + " " + orderDirection);
			}
		}
		return new PageInfo<T>(mapper.select(entity));
	}

}
