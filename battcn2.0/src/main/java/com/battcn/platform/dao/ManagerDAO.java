package com.battcn.platform.dao;

import com.battcn.platform.entity.pub.ManagerEntity;

/**
 * @ClassName: ManagerDAO
 * @Description: 
 * @author 唐亚峰
 * @date 2016年9月25日
 */
public interface ManagerDAO
{
	public ManagerEntity selectByPrimaryKey(Long key);
	boolean insertSelective(ManagerEntity dto);
	boolean updateByPrimaryKey(ManagerEntity dto);
	void deleteByPrimaryKey(Long id);
}
