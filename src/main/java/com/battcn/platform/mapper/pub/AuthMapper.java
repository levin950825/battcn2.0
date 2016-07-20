package com.battcn.platform.mapper.pub;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.alibaba.fastjson.JSONObject;
import com.battcn.platform.entity.pub.OperateEntity;

public interface AuthMapper
{
	List<JSONObject> queryAllUrlForList();
	List<OperateEntity> queryOperateForList(JSONObject dto);
	List<String> queryPermissionForList(@Param("userId")Long userId);
	List<JSONObject> getChildMenuInPermission(@Param("role")Integer map);
}
