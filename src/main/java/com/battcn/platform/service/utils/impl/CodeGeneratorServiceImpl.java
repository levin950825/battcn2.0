package com.battcn.platform.service.utils.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.battcn.framework.redis.RedisOperator;
import com.battcn.platform.cache.SecondLevelCached;
import com.battcn.platform.entity.AjaxJson;
import com.battcn.platform.entity.code.CodeColumnEntity;
import com.battcn.platform.entity.code.CodeTableEntity;
import com.battcn.platform.service.utils.CodeGeneratorService;
import com.battcn.util.generator.FileUtil;
import com.battcn.util.generator.Freemarker;
import com.battcn.util.generator.PathUtil;

/**
 * @ClassName: CreateCodeServiceImpl
 * @Description:
 * @author 唐亚峰
 * @date 2016年10月9日
 */
@Service
public class CodeGeneratorServiceImpl implements CodeGeneratorService
{
	@Resource(name = "redisOperator")
	private RedisOperator redisOperator;
	private static final int CACHE_DB_INDEX = SecondLevelCached.CACHED_DB_INDEX_CODE_GENERATOR;
	private static final String CACHE_DB_KEY = SecondLevelCached.SYS_MANAGER_KEY_GENERATOR;

	@Override
	public List<?> queryCodeForList(String tid)
	{
		if (StringUtils.isNotBlank(tid))
		{
			if("false".equals(tid))
				return null;
			List<CodeColumnEntity> codeList = new ArrayList<CodeColumnEntity>();
			Map<String, String> list = redisOperator.hgetAll(tid, CACHE_DB_INDEX);
			for (String str : list.values())
			{
				codeList.add(JSON.parseObject(str, CodeColumnEntity.class));
			}
			return codeList;
		} else
		{
			List<CodeTableEntity> codeList = new ArrayList<CodeTableEntity>();
			Map<String, String> list = redisOperator.hgetAll(CACHE_DB_KEY, CACHE_DB_INDEX);
			for (String str : list.values())
			{
				codeList.add(JSON.parseObject(str, CodeTableEntity.class));
			}
			return codeList;
		}
	}

	@Override
	public CodeTableEntity getCodeTableByUUID(String uuid)
	{
		String json = redisOperator.hget(CACHE_DB_KEY, uuid, CACHE_DB_INDEX);
		return JSON.parseObject(json, CodeTableEntity.class);
	}
	@Override
	public CodeColumnEntity getCodeColumnByUUID(String tid,String cid)
	{
		String json = redisOperator.hget(tid, cid, CACHE_DB_INDEX);
		return JSON.parseObject(json, CodeColumnEntity.class);
	}

	@Override
	public AjaxJson delete(String[] ids, String tid, String cid)
	{
		if (ids != null && ids.length > 0)
		{
			for (String str : ids)
			{
				redisOperator.hdel(CACHE_DB_KEY, str, CACHE_DB_INDEX);
			}
		} else
		{
			if (StringUtils.isNotEmpty(tid) && StringUtils.isNotEmpty(cid))
			{
				CodeTableEntity code = getCodeTableByUUID(tid);
				if (code != null)
				{
					List<CodeColumnEntity> list = code.getColumnList();
					Iterator<CodeColumnEntity> iter = list.iterator();
					while (iter.hasNext())
					{
						CodeColumnEntity column = iter.next();
						if (cid.equals(column.getUuid()))
							list.remove(column);
					}
					return saveOrUpdate(code);
				}
			}
		}
		return null;
	}
	
	@Override
	public AjaxJson saveOrUpdateColumn(String tid,CodeColumnEntity column)
	{
		AjaxJson ajaxJson = new AjaxJson();
		if (column != null)
		{
			JSONObject json = (JSONObject) JSON.toJSON(column);
			Long row = redisOperator.hset(tid, column.getUuid(), json.toJSONString(), CACHE_DB_INDEX);
			ajaxJson.setMsg("添加成功");
			ajaxJson.setSuccess(row > 0 ? true : false);
		}
		return ajaxJson;
	}

	@Override
	public AjaxJson saveOrUpdate(CodeTableEntity table)
	{
		AjaxJson ajaxJson = new AjaxJson();
		if (table != null)
		{
			JSONObject json = (JSONObject) JSON.toJSON(table);
			Long row = redisOperator.hset(CACHE_DB_KEY, table.getUuid(), json.toJSONString(), CACHE_DB_INDEX);
			ajaxJson.setMsg("添加成功");
			ajaxJson.setSuccess(row > 0 ? true : false);
		}
		return ajaxJson;
	}

	public static void main(String[] args)
	{
		String json = "{\"processorClass\":\"C\",\"uuid\":\"FEA307942D2D2B0CF3AA20FDDC8050B3\",\"tablePrefix\":\"TB_B\",\"upPackage\":\"A\"}";
		CodeTableEntity c = JSON.parseObject(json, CodeTableEntity.class);

		List<CodeColumnEntity> columnList = new ArrayList<CodeColumnEntity>();
		CodeColumnEntity c1 = new CodeColumnEntity();
		c1.setAttributeName("name");
		c1.setAttributeType("varchar");
		c1.setCreateDate(new Date());
		c1.setDefaultVal("memmsc");
		c1.setRemake("备注");
		c1.setUuid("FEA407942D2D2B0CF3AA20FDDC8050B4");
		columnList.add(c1);
		c.setColumnList(columnList);
		// String

		System.out.println(((JSONObject) JSON.toJSON(c)).toJSONString());
	}

	@Override
	public void generateCode(HttpServletResponse response, String uuid) throws Exception
	{
		CodeTableEntity code = getCodeTableByUUID(uuid);
		String upPack = code.getUpPackage();
		String proClass = code.getProcessorClass();
		String tablePre = code.getTablePrefix();

		Map<String, Object> root = new HashMap<String, Object>(); // 创建数据模型
		root.put("fieldList", code.getColumnList());
		root.put("upPack", upPack); // 包名
		root.put("proClass", proClass); // 类名
		String lower = proClass.toLowerCase();
		String upper = proClass.toUpperCase();
		root.put("proClassLower", lower); // 类名(全小写)
		root.put("proClassUpper", upper); // 类名(全大写)
		root.put("tablePre", tablePre); // 表前缀
		root.put("nowDate", new Date()); // 当前日期
		//root.put("OP.menu", "OP.menu"); // 当前日期

		/**
		 * =====================================================================
		 */
		String filePath = "generator/code/"; // 存放路径
		String ftlPath = "createCode"; // ftl路径

		FileUtil.delFolder(PathUtil.getClasspath() + filePath); // 生成代码前,先清空之前生成的代码

		/* 生成controller */
		Freemarker.printFile("controllerTemplate.ftl", root,
				"controller/" + upPack + "/" + proClass + "Controller.java", filePath, ftlPath);

		/* 生成service */
		Freemarker.printFile("serviceTemplate.ftl", root, "service/" + upPack + "/" + proClass + "Service.java",
				filePath, ftlPath);

		/* 生成serviceImpl */
		Freemarker.printFile("serviceTemplateImpl.ftl", root,
				"service/" + upPack + "/impl/" + proClass + "ServiceImpl.java", filePath, ftlPath);

		/* 生成SQL脚本 */
		Freemarker.printFile("mysql_SQL_Template.ftl", root, "mysql脚本/" + tablePre + upper + ".sql", filePath, ftlPath);
		Freemarker.printFile("oracle_SQL_Template.ftl", root, "oracle脚本/" + tablePre + upper + ".sql", filePath,
				ftlPath);

		/* 生成jsp页面 */
		Freemarker.printFile("list_Template.ftl", root, "views/" + upPack + "/" + "list.jsp", filePath, ftlPath);
		Freemarker.printFile("edit_Template.ftl", root, "views/" + upPack + "/" + "edit.jsp", filePath, ftlPath);

		/* 生成的全部代码压缩成zip文件 */
		FileUtil.zip(PathUtil.getClasspath() + filePath, PathUtil.getClasspath() + filePath + proClass + "Code.zip");

		/* 下载代码 */
		FileUtil.fileDownload(response, PathUtil.getClasspath() + filePath + proClass + "Code.zip",
				proClass + "Code.zip");
	}



}
