package com.battcn.platform.service.pub.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import com.battcn.platform.entity.pub.ManagerEntity;
import com.battcn.platform.mapper.pub.ManagerMapper;
import com.battcn.platform.service.BaseService;
import com.battcn.platform.service.pub.ManagerService;

@Service
public class ManagerServiceImpl extends BaseService<ManagerEntity> implements
		ManagerService
{

	@Autowired ManagerMapper managerMapper;

	@Override
	public ManagerEntity selectByAccount(String account)
	{
		Example example = new Example(ManagerEntity.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("account", account);
		List<ManagerEntity> list = this.managerMapper.selectByExample(example);
		if (list != null && list.size() > 0)
		{
			return list.get(0);
		}
		return null;
	}

}
