package com.xtkj.service.friendcircle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtkj.dao.ActivityMapper;
import com.xtkj.pojo.Activity;

@Service
public class FriendCircleServiceImp implements IFriendCircleService {

	@Autowired
	private ActivityMapper activityMapper;
	/**
	 * -查询用户发布的活动信息
	 * @throws Exception 
	 */
	@Override
	public List<Activity> findFriendCircle() throws Exception {
		return activityMapper.selectActivitys();	
	}

}
