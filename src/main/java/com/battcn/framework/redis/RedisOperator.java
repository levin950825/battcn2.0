package com.battcn.framework.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Tuple;

/**
 * @ClassName: RedisOperator
 * @author 唐亚峰
 * @date 2016年9月25日
 */
public interface RedisOperator
{

	public void set(String key, String value, int db);

	public String get(String key, int db);

	public Long incr(String key, int db);

	public Long incr(String key, long integer, int db);

	public boolean exists(String key, int db);

	public Long del(String key, int db);

	public String setex(String key, int seconds, String value, int db);

	public String getset(String key, String value, int db);

	public Long expire(String key, int seconds, int db);

	public void lpush(String key, String value, int db);

	public String rpop(String key, int db);

	public Long llen(String key, int db);

	public List<String> rrange(String key, long start, long end, int db);

	public void ltrim(String key, long start, long end, int db);

	public String lindex(String key, long index, int db);

	public Long rpush(String key, int db, String... strings);

	public Long hset(String key, String field, String value, int db);

	public Long hlen(String key, int db);

	public Long hdel(String key, String field, int db);

	public String hget(String key, String field, int db);

	public Long hincrBy(String key, String field, long value, int db);

	public List<String> hmget(String key, int db, String... fields);

	public String hmset(String key, int db, Map<String, String> kvals);

	public Map<String, String> hgetAll(String key, int db);

	public Set<String> hkeys(String key, int db);

	public boolean sismember(String key, String member, int db);

	public Long sadd(int db, String key, final String... members);

	public Set<String> smembers(int db, String key);

	public void zadd(String key, double score, String member, int db);

	public Set<String> zrangeByScore(String key, double min, double max, int db);

	public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max, int db);

	public Set<Tuple> zrevrangeByScoreWithScores(final String key, final double max, final double min, final int offset,
			final int count, int db);

	public Set<String> zrangeByScore(String key, double min, double max, int offset, int count, int db);

	public Double zscore(String key, String member, int db);

	public Long zrem(String key, String member, int db);

	public Set<String> zrevrange(String key, long start, long end, int db);

	public Set<String> zrevrangeByScore(String key, double min, double max, int db);

	public Set<String> zrevrangeByScore(String key, double max, double min, int offset, int count, int db);

	public Long zcount(String key, double min, double max, int db);

	public Long zcard(String key, int db);

	public Long zremrangeByScore(String key, double start, double end, int db);

	public Double zincrby(String key, double score, String member, int db);

	public Long zrank(String key, String member, int db);

	public Long zrevrank(String key, String member, int db);

	public Long zremrangeByRank(String key, long start, long end, int db);

	public Set<String> zrange(String key, long start, long end, int db);

	public Set<Tuple> zrangeWithScores(String key, long start, long end, int db);

	public Set<Tuple> zrevrangeWithScores(String key, long start, long end, int db);

	public Long ttl(String key, int db);

	public String type(String key, int db);

	public String lpop(String key, int db);

	public List<String> blpop(int db, int timeout, String... keys);

	public Long srem(int db, String key, String... members);

	public String srandmember(int db, String key);

	public Long scard(int db, String key);

	public String spop(int db, String key);

	public Boolean hexists(String key, String member, int db);
}
