package com.battcn.platform.service.${upPack}.impl;

import java.util.List;
import com.battcn.platform.entity.DataGrid;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import com.battcn.platform.entity.${proClass}Entity;
import com.battcn.platform.entity.AjaxJson;
import com.battcn.platform.service.${upPack}.${proClassLower}.${proClass}Service;
import com.battcn.platform.service.BaseService;

@Service
public class ${proClass}ServiceImpl extends BaseService<${proClass}Entity> implements ${proClass}Service  
{
	@Override
	public PageInfo<${proClass}Entity> query${proClass}ForList(DataGrid grid,${proClass}Entity dto)
	{
		return super.queryForDataGrid(grid,dto);
	}
	
	@Override
	public ${proClass}Entity selectByPrimaryKey(Object key)
	{
		return super.selectByPrimaryKey(key);
	}
	
	@Override
	public AjaxJson batchDelete(Object[] ids)
	{
		AjaxJson ajaxJson = new AjaxJson();
		if (ids != null && ids.length > 0)
			super.batchDeleteByPrimaryKey(ids);
		ajaxJson.setSuccess(true);
		ajaxJson.setMsg("删除成功！");
		return ajaxJson;
	}
	
	@Override
	public AjaxJson saveOrUpdate(${proClass}Entity dto)
	{
		AjaxJson json = new AjaxJson();
		if (dto.getId() != null)
		{
			super.updateByPrimaryKey(dto);
		} else
		{
			super.insertSelective(dto);
		}
		json.setSuccess(true);
		json.setMsg("保存成功！");
		return json;
	}
	
}

