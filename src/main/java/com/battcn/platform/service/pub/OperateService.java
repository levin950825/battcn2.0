package com.battcn.platform.service.pub;

import java.util.List;

import com.battcn.platform.entity.pub.OperateEntity;

public interface OperateService
{
	OperateEntity findByOperate(OperateEntity entity) throws Exception;
	List<OperateEntity> queryOperateForList(OperateEntity opt) throws Exception;
	Boolean checkPermission(Integer menu,String op, Integer accountid) throws Exception;
	List<OperateEntity> getOperatesInPermissionByMenu(Integer menuid,Integer accountid) throws Exception;
	void insertByOperate(OperateEntity opt);
	void updateByOperate(OperateEntity opt);
	void deleteByOperate(OperateEntity opt);
}
