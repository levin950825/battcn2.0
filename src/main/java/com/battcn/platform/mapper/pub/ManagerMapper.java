package com.battcn.platform.mapper.pub;

import java.util.List;
import tk.mybatis.mapper.common.Mapper;
import com.alibaba.fastjson.JSONObject;
import com.battcn.platform.entity.pub.ManagerEntity;

public interface ManagerMapper extends Mapper<ManagerEntity>
{
	List<JSONObject> queryManagerForList();
	void update(ManagerEntity dto);
}
