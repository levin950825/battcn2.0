package com.battcn.platform.service.pub.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.battcn.platform.entity.pub.OperateEntity;
import com.battcn.platform.mapper.pub.OperateMapper;
import com.battcn.platform.service.BaseService;
import com.battcn.platform.service.pub.OperateService;

@Service
public class OperateServiceImpl extends BaseService<OperateEntity> implements OperateService
{ 
	
	@Autowired OperateMapper operateMapper;

	@Override
	public OperateEntity findByOperate(OperateEntity entity) throws Exception
	{
		return this.operateMapper.findOperateByOpAndMenu(entity);
	}

	@Override
	public List<OperateEntity> queryOperateForList(OperateEntity opt) throws Exception
	{
		return null;
	}

	@Override
	public Boolean checkPermission(Integer menu, String op, Integer accountid) throws Exception
	{
		return null;
	}

	@Override
	public List<OperateEntity> getOperatesInPermissionByMenu(Integer menuid, Integer accountid) throws Exception
	{
		return null;
	}

	@Override
	public void insertByOperate(OperateEntity opt)
	{

	}

	@Override
	public void updateByOperate(OperateEntity opt)
	{

	}

	@Override
	public void deleteByOperate(OperateEntity opt)
	{

	}

}
