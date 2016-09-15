package com.battcn.platform.mapper.pub;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import tk.mybatis.mapper.common.Mapper;
import com.alibaba.fastjson.JSONObject;
import com.battcn.platform.entity.pub.ManagerEntity;

public interface ManagerMapper extends Mapper<ManagerEntity>
{
	List<JSONObject> queryManagerForList(@Param("name")String name);
	void update(ManagerEntity dto);
}
