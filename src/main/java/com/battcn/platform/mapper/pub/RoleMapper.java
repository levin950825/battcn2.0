package com.battcn.platform.mapper.pub;

import tk.mybatis.mapper.common.Mapper;
import java.util.List;
import com.alibaba.fastjson.JSONObject;
import com.battcn.platform.entity.pub.RoleEntity;

public interface RoleMapper extends Mapper<RoleEntity>
{
	List<JSONObject> getRoleOperate(Integer id);
	int deleteOperateByRole(Integer role);
}
