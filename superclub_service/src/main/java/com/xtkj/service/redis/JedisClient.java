package com.xtkj.service.redis;

import java.util.Map;

public interface JedisClient {
	
	public void set(String key,String value);
	
	public String get(String key);
	
	public void del(String key);
	
	long hset(String key,String field,String value);
	
	long hdel(String key,String field);
	
	String hget(String key,String field);
	
	long hlen(String key);
	
	Map<String, String> hgetall(String key);
	
	/**
	 * -点赞的方法接口
	 * @param key
	 * @return
	 */
	public long incr(String key);
	
	/**
	 * -减赞的方法接口
	 * @param key
	 * @return
	 */
	long decr(String key);

}
