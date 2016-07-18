package com.battcn.platform.mapper.pub;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.alibaba.fastjson.JSONObject;
import com.battcn.platform.entity.pub.OperateEntity;

public interface AuthMapper
{
	List<JSONObject> queryAllUrlForList();
	List<String> queryPermissionForList(@Param("userId")Long userId);
	List<JSONObject> getParentMenu(String menuid);
	List<JSONObject> getChildMenuInPermission(JSONObject map);
	List<OperateEntity> checkPermission(JSONObject map);
}
