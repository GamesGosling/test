package com.xtkj.service.friendcircle;

import java.util.List;

import com.xtkj.pojo.ActivityCommentVo;
import com.xtkj.pojo.ActivityCommont;
import com.xtkj.pojo.ActivityCommontReply;

public interface IFriendsCircleCommentService {

	
	List<ActivityCommentVo> listComments(ActivityCommentVo activityCommentVo);
	
	/**
	 * -给活动写评论
	 * @param activity
	 * @param user
	 * @return
	 */
	int friendsCircleComment(ActivityCommont activityCommont);
	
	/**
	 * -通过评论id删除评论
	 * @return
	 */
	int delComment(String commentId);
	
	/**
	 * -回复评论
	 * @param activityCommontReply
	 * @return
	 */
	int replycomment(ActivityCommontReply activityCommontReply);
	
	/**
	 * -删除回复评论
	 * @param activityCommontReply
	 * @return
	 */
	int delreplycomment(ActivityCommontReply activityCommontReply);
}
