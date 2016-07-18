package com.battcn.platform.shiro;

import java.util.List;

import org.apache.shiro.config.Ini;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.battcn.platform.service.pub.MenuService;

/**
 * 产生责任链，确定每个url的访问权限
 * 
 */
public class ChainDefinitionSectionMetaSource implements FactoryBean<Ini.Section>
{

	@Autowired
	private MenuService menuService;

	// 静态资源访问权限
	private String filterChainDefinitions = null;

	public Ini.Section getObject() throws Exception
	{
		Ini ini = new Ini();
		// 加载默认的url
		ini.load(filterChainDefinitions);
		Ini.Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
		// 循环Resource的url,逐个添加到section中。section就是filterChainDefinitionMap,
		// 里面的键就是链接URL,值就是存在什么条件才能访问该链接
		List<JSONObject> list = menuService.queryAllUrlForList();
		for (JSONObject menu : list)
		{
			// 构成permission字符串
			String param = menu.getString("param");
			String key = menu.getString("key");
			String permission = "perms[" + param + "]";
			// 如需要则 permission = "roles[" + resources.getResKey() + "]";
			section.put(key, permission);
			System.out.println(key+"\t"+permission);
		}
		// 所有资源的访问权限，必须放在最后
		/** 如果不需要 单个用户登录 ： section.put("/**", "authc"); */
		section.put("/**", "sysUser,kickout,authc");
		return section;
	}

	public static void main(String[] args)
	{

	}

	/**
	 * 通过filterChainDefinitions对默认的url过滤定义
	 * 
	 * @param filterChainDefinitions
	 *            默认的url过滤定义
	 */
	public void setFilterChainDefinitions(String filterChainDefinitions)
	{
		this.filterChainDefinitions = filterChainDefinitions;
	}

	public Class<?> getObjectType()
	{
		return this.getClass();
	}

	public boolean isSingleton()
	{
		return false;
	}
}
