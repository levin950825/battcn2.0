package com.battcn.platform.cache;

import com.battcn.framework.redis.RedisOperator;
import com.battcn.util.spring.AppContextUtil;

/**
 * @ClassName: SecondLevelCached
 * @Description: 
 * @author 唐亚峰
 * @date 2016年9月25日
 */
public class SecondLevelCached
{
	public static final int CACHED_DB_INDEX = 1;
	public static final String SYS_MANAGER_KEY = "sys:manager:";
	
	public static final int CACHED_DB_INDEX_CODE_GENERATOR = 2;
	public static final String SYS_MANAGER_KEY_GENERATOR = "code:generator";
	public static final String SYS_MANAGER_LONG_ID = "code:generator:id";
	
	public static RedisOperator getRedisClient(){
		return (RedisOperator)AppContextUtil.getBean("battcnRedisClient");
	}
	
}
