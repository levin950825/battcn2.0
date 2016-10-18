package com.battcn.platform.service.utils;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.battcn.platform.entity.AjaxJson;
import com.battcn.platform.entity.code.CodeColumnEntity;
import com.battcn.platform.entity.code.CodeTableEntity;

/**
 * @ClassName: CreateCodeService
 * @Description:
 * @author 唐亚峰
 * @date 2016年10月9日
 */
public interface CodeGeneratorService
{
	List<?> queryCodeForList(String tid);
	CodeColumnEntity getCodeColumnByUUID(String tid,String cid);
	CodeTableEntity getCodeTableByUUID(String uuid);
	AjaxJson delete(String[] ids,String tid,String cid);
	AjaxJson saveOrUpdate(CodeTableEntity dto);
	AjaxJson saveOrUpdateColumn(String tid,CodeColumnEntity column);
	void generateCode(HttpServletResponse response,String uuid) throws Exception;
}
