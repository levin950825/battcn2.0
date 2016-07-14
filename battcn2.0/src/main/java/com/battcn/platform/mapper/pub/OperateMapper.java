package com.battcn.platform.mapper.pub;


import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.battcn.platform.entity.pub.OperateEntity;

import tk.mybatis.mapper.common.Mapper;

public interface OperateMapper extends Mapper<OperateEntity>
{
	List<JSONObject> queryOperateForList(JSONObject queryMap);
	OperateEntity findOperateByOpAndMenu(OperateEntity dto);
	void insertByOperate(OperateEntity dto);
	void updateByOperate(OperateEntity dto);
	void deleteByOperate(OperateEntity dto);
}
