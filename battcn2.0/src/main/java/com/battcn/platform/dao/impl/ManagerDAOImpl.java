package com.battcn.platform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.battcn.platform.dao.ManagerDAO;
import com.battcn.platform.entity.pub.ManagerEntity;
import com.battcn.platform.mapper.pub.ManagerMapper;

/**
 * @ClassName: ManagerDAOImpl
 * @Description:
 * @author 唐亚峰
 * @date 2016年9月25日
 */
@Repository
public class ManagerDAOImpl implements ManagerDAO
{

	@Autowired
	ManagerMapper managerMapper;

	@Override
	public ManagerEntity selectByPrimaryKey(Long key)
	{
		return this.managerMapper.selectByPrimaryKey(key);
	}

	@Override
	public boolean insertSelective(ManagerEntity dto)
	{
		return this.managerMapper.insertSelective(dto) > 0 ? true : false;
	}

	@Override
	public boolean updateByPrimaryKey(ManagerEntity dto)
	{
		return this.managerMapper.updateByPrimaryKeySelective(dto) > 0 ? true : false;
	}

	@Override
	public void deleteByPrimaryKey(Long id)
	{
		this.managerMapper.deleteByPrimaryKey(id);
	}

}
