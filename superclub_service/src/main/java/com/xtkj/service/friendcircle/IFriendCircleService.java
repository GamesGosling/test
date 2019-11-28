package com.xtkj.service.friendcircle;

import java.util.List;

import com.xtkj.pojo.Activity;

public interface IFriendCircleService {

	/**
	 * -查询朋友圈所用的活动
	 * @return
	 * @throws Exception 
	 */
	List<Activity> findFriendCircle() throws Exception;
	
}
