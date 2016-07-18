package com.battcn.platform.mapper.pub;

import java.util.List;
import com.alibaba.fastjson.JSONObject;
import com.battcn.platform.entity.pub.OperateEntity;

public interface AuthMapper
{
	List<JSONObject> getParentMenu(String menuid);
	List<JSONObject> getChildMenuInPermission(JSONObject map);
	List<OperateEntity> checkPermission(JSONObject map);
}
