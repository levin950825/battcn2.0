package com.battcn.platform.service.pub;

import com.battcn.platform.entity.DataGrid;
import com.battcn.platform.entity.pub.LogsEntity;
import com.github.pagehelper.PageInfo;

public interface LogsService
{
	PageInfo<LogsEntity> queryLogsForList(DataGrid grid);
}
