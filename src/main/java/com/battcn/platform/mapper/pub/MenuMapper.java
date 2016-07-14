package com.battcn.platform.mapper.pub;

import com.battcn.platform.entity.pub.MenuEntity;

import tk.mybatis.mapper.common.Mapper;

public interface MenuMapper extends Mapper<MenuEntity>
{
	MenuEntity findMenuByPrimaryKey(Integer id);

	void deleteMenu(Integer id);
}
