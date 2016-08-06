package com.battcn.platform.service.pub.impl;

import org.springframework.stereotype.Service;

import com.battcn.platform.entity.DataGrid;
import com.battcn.platform.entity.pub.LogsEntity;
import com.battcn.platform.service.BaseService;
import com.battcn.platform.service.pub.LogsService;
import com.github.pagehelper.PageInfo;

@Service
public class LogsServiceImpl extends BaseService<LogsEntity> implements LogsService
{

	@Override
	public PageInfo<LogsEntity> queryLogsForList(DataGrid grid)
	{
		return super.queryForDataGrid(grid);
	}

}
