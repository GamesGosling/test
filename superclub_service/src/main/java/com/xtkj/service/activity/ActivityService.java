package com.xtkj.service.activity;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.xtkj.pojo.Activity;
import com.xtkj.pojo.ActivityType;
import com.xtkj.pojo.User;

public interface ActivityService {
	//发布活动
	public int publishActivity(Activity activity,User user);
	//活动详情
	public Activity findActivityById(String id);
	//修改活动信息
	public int modifyActivity(Activity activity);
	//删除活动
	public int deleteActivity(String id);
	//获得活动列表
	public List<Activity> getActivityList();
	//分页
	public PageInfo<Activity> getActivitiesByMap(Map<String, Object> params);
	//获得活动类型列表
	public List<ActivityType> getActivityTypes();
	//获得热门活动列表
	public List<Activity> getHotActivitys();
	public List<Activity> getMoreHotActivitys();
	//获得最新活动列表
	public List<Activity> getLatestActivitys();
	public List<Activity> getMoreLatestActivitys();
	//获得同城活动列表
	public List<Activity> getSameCityActivitys(String location);
	public List<Activity> getMoreSameCityActivitys(String cityName);
	//参加活动
	public int enrollActivity();
	//根据用户id查询活动列表
	public List<Activity> getActListByUserId(String userId);
}
