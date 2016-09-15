package com.battcn.platform.mapper.pub;

import org.apache.ibatis.annotations.Param;

import com.battcn.platform.entity.pub.MenuEntity;

import tk.mybatis.mapper.common.Mapper;

public interface MenuMapper extends Mapper<MenuEntity>
{
	MenuEntity findMenuByPrimaryKey(@Param("id")Integer id);
	void deleteMenu(Integer id);
	void treeNode();
}
