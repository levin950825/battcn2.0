package com.battcn.platform.service.pub;

import java.util.List;

import com.battcn.platform.entity.pub.OperateEntity;
import com.battcn.platform.entity.pub.RoleOperateEntity;

public interface RoleOperateService
{
	public List<OperateEntity> queryOperateForList(RoleOperateEntity dto);
}
