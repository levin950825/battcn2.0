package com.battcn.platform.service.pub.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import com.battcn.platform.entity.pub.OperateEntity;
import com.battcn.platform.entity.pub.RoleOperateEntity;
import com.battcn.platform.mapper.pub.AuthMapper;
import com.battcn.platform.service.BaseService;
import com.battcn.platform.service.pub.RoleOperateService;

@Service
public class RoleOperateServiceImpl extends BaseService<RoleOperateEntity> implements RoleOperateService
{
	@Autowired AuthMapper authMapper;
	@Override
	public List<OperateEntity> queryOperateForList(JSONObject dto)
	{
		return this.authMapper.queryOperateForList(dto);
	}
}
