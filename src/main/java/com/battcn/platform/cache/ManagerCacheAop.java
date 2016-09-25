package com.battcn.platform.cache;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.battcn.framework.redis.RedisOperator;
import com.battcn.framework.redis.impl.RedisOperatorImpl;
import com.battcn.platform.entity.pub.ManagerEntity;

/**
 * @ClassName: ManagerAop
 * @author 唐亚峰
 * @date 2016年9月25日
 */


public class ManagerCacheAop
{
	@Resource(name = "redisOperator")
	private RedisOperator redisOperator;
	
	
	private Logger logger = LoggerFactory.getLogger(RedisOperatorImpl.class);

	public void save(ManagerEntity dto) throws Throwable
	{
		String managerId = dto.getManagerid().toString();
		redisOperator.hset(SecondLevelCached.SYS_MANAGER_KEY, managerId, JSON.toJSONString(dto),SecondLevelCached.CACHED_DB_INDEX);
		logger.info("redis>>>save>>>manager>>>操作成功!!!");
	}

	public ManagerEntity selectByKey(ProceedingJoinPoint pjp) throws Throwable
	{
		String id = (pjp.getArgs())[0].toString();
		if (id != null)
		{
			String key = SecondLevelCached.SYS_MANAGER_KEY;
			String str = redisOperator.hget(key, id, SecondLevelCached.CACHED_DB_INDEX);
			if (str != null)
			{
				return JSON.parseObject(str, ManagerEntity.class);
			} else
			{
				ManagerEntity dto = (ManagerEntity) pjp.proceed();
				if (dto != null)
				{
					String managerId = dto.getManagerid().toString();
					logger.info("redis>>>save>>>manager>>>操作成功!!!");
					redisOperator.hset(SecondLevelCached.SYS_MANAGER_KEY, managerId,
							JSON.toJSONString(dto), SecondLevelCached.CACHED_DB_INDEX);
				}
				return dto;
			}
		} else
		{
			return null;
		}
	}

	public void deleteByKey(Long id) throws Throwable
	{
		redisOperator.hdel(SecondLevelCached.SYS_MANAGER_KEY, id.toString(),SecondLevelCached.CACHED_DB_INDEX);
		logger.info("redis>>>del>>>manager>>>操作成功!!!");
	}
}
