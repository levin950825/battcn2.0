package com.battcn.platform.service.pub;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.battcn.platform.entity.pub.OperateEntity;

public interface RoleOperateService
{
	public List<OperateEntity> queryOperateForList(JSONObject dto);
}
