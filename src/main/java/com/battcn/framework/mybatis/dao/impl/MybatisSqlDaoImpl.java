package com.battcn.framework.mybatis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.battcn.framework.mybatis.dao.MybatisSqlDao;

/**
 * 缺省全局通用数据访问对象，缺省数据访问对象连接到dataSource Bean配置的数据源
 */
@Repository
public class MybatisSqlDaoImpl implements MybatisSqlDao
{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 保存对象
	 * 
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Object save(String str, Object obj)
	{
		if (obj == null)
		{
			return sqlSessionTemplate.insert(str);
		} else
		{
			return sqlSessionTemplate.insert(str, obj);
		}
	}

	/**
	 * 批量插入
	 * 
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Object batchSave(String str, List<?> objs) throws Exception
	{
		return sqlSessionTemplate.insert(str, objs);
	}

	/**
	 * 修改对象
	 * 
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Object update(String str, Object obj)
	{
		if (obj == null)
		{
			return sqlSessionTemplate.update(str);
		} else
		{
			return sqlSessionTemplate.update(str, obj);
		}
	}

	/**
	 * 批量更新
	 * 
	 * @param str
	 * @param obj
	 * @return @
	 */
	public void batchUpdate(String str, List<?> objs)
	{
		SqlSessionFactory sqlSessionFactory = sqlSessionTemplate.getSqlSessionFactory();
		// 批量执行器
		SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
		try
		{
			if (objs != null)
			{
				for (int i = 0, size = objs.size(); i < size; i++)
				{
					sqlSession.update(str, objs.get(i));
				}
				sqlSession.flushStatements();
				sqlSession.commit();
				sqlSession.clearCache();
			}
		} finally
		{
			sqlSession.close();
		}
	}

	/**
	 * 批量删除
	 * 
	 * @param str
	 * @param obj
	 * @return @
	 */
	public Object batchDelete(String str, List<?> objs)
	{
		return sqlSessionTemplate.delete(str, objs);
	}

	/**
	 * 删除对象
	 * 
	 * @param str
	 * @param obj
	 * @return @
	 */
	public Object delete(String str, Object obj)
	{
		if (obj == null)
		{
			return sqlSessionTemplate.delete(str);
		} else
		{
			return sqlSessionTemplate.delete(str, obj);
		}
	}

	public Object findForObject(String str, Object obj)
	{
		if (obj == null)
		{
			return sqlSessionTemplate.selectOne(str);
		} else
		{
			return sqlSessionTemplate.selectOne(str, obj);
		}
	}

	public Object queryForList(String str, Object obj)
	{
		if (obj == null)
		{
			return sqlSessionTemplate.selectList(str);
		} else
		{
			return sqlSessionTemplate.selectList(str, obj);
		}

	}

	public Object queryForMap(String str, Object obj, String key, String value)
	{
		return sqlSessionTemplate.selectMap(str, obj, key);
	}

}
