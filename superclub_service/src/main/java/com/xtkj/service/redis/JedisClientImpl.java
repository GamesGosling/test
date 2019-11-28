package com.xtkj.service.redis;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import redis.clients.jedis.ShardedJedisPool;


@Repository
public class JedisClientImpl implements JedisClient {
	
	@Autowired
	private ShardedJedisPool jedisPool;
	

	public void set(String key,String value) {
		jedisPool.getResource().getSet(key, value);
	}
	
	public String get(String key) {
		return jedisPool.getResource().get(key);
	}
	
	public void del(String key) {
		jedisPool.getResource().del(key);	
	}
	
	public long incr(String key) {
		return jedisPool.getResource().incr(key);	
	}
	
	public long decr(String key) {
		return jedisPool.getResource().decr(key);	
	}
	
	public long hlen(String key) {
		return jedisPool.getResource().hlen(key);	
	}
	
	public long hset(String key,String field,String value) {
		return jedisPool.getResource().hset(key, field, value);
	}
	
	public long hdel(String key,String field) {
		return jedisPool.getResource().hdel(key, field);
	}
	
	public String hget(String key,String field) {
		return jedisPool.getResource().hget(key, field);
	}
	
	public Map<String, String> hgetall(String key) {
		return jedisPool.getResource().hgetAll(key);
	}
}


