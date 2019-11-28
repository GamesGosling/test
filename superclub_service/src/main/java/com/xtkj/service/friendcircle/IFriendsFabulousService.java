package com.xtkj.service.friendcircle;

import java.util.Map;

import com.xtkj.pojo.User;

public interface IFriendsFabulousService {

	/**
	 * -根据用户所选择的的活动，获取活动的点赞数，
	 * @param ActivityId
	 * @return
	 */
	Map<String, String> getActivityFabulous(String activityId,User user);
	
	/**
	 * -点赞或者取消点赞
	 * @param ActivityId
	 * @return
	 */
	Map<String, Object> addAnddelActivityFabulous(String activityId, User user);
	
	
}
