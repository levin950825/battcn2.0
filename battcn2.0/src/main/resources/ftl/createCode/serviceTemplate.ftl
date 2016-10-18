package com.battcn.platform.service.${upPack};

import java.util.List;
import com.battcn.platform.entity.DataGrid;
import com.github.pagehelper.PageInfo;
import com.battcn.platform.entity.AjaxJson;
import com.battcn.platform.entity.${proClass}Entity;


/**
 * 
 * @ClassName: ${proClass}Service 
 * @Description: 代码生成器生成的接口文件
 * @author 唐亚峰
 * @date ${nowDate?string("yyyy-MM-dd")}
 */
public interface ${proClass}Service 
{
	PageInfo<${proClass}Entity> query${proClass}ForList(DataGrid grid,${proClass}Entity dto);
	${proClass}Entity selectByPrimaryKey(Object key);
	AjaxJson batchDelete(Object[] ids);
	AjaxJson saveOrUpdate(${proClass}Entity dto);
}

