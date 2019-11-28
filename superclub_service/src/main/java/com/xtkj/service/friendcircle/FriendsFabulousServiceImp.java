package com.xtkj.service.friendcircle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.xtkj.pojo.User;
import com.xtkj.service.redis.JedisClient;

@Service
public class FriendsFabulousServiceImp implements IFriendsFabulousService {

	@Autowired
	private JedisClient jedis;

	/**
	 * -查询点击数
	 */
	@Override
	public Map<String, String> getActivityFabulous(String activityId,User user) {
		long num =0;
		Map<String, String> maps = null;
		//默认表示没点
		String index = "false";
		try {
			//查询出点赞的数量			
			num = jedis.hlen("activity_"+activityId+"");
			//查询出所用的人员
			maps =jedis.hgetall("activity_"+activityId+"");
			String key =jedis.hget("activity_"+activityId+"",user.getUserId());
			
			if(key!=null) {
				index="true";
			}else {
				index="false";
			}	
			maps.put("index", index);
			maps.put("nums", num+"");

		} catch (Exception e) {
			//System.out.println("getActivityFabulous");
			e.printStackTrace();
		}
		return maps;
	}

	/**
	 * -点赞和取消点赞
	 * @throws Excepthrowstion 
	 */
	@Override
	public Map<String, Object> addAnddelActivityFabulous(String activityId, User user) {
		//默认表示没点
		String index = "false";		
		try {
			String json=JSONObject.toJSONString(user);
			String key =jedis.hget("activity_"+activityId+"",user.getUserId());
			if(key!=null) {
				//说明该人点击了该活动,并删除User信息
				jedis.hdel("activity_"+activityId+"", user.getUserId());
				index="true";
			}else {
				//如果没有点赞，添加User信息数据
				jedis.hset("activity_"+activityId+"",user.getUserId(),json);
				index="false";
				System.out.println("增加用户");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		Map<String,Object> maps=new HashMap<>();
		maps.put("index", index);
		maps.put("user", user);
		return maps;
	}

}
