package com.xtkj.service.friendcircle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtkj.dao.ActivityCommontMapper;
import com.xtkj.dao.ActivityCommontReplyMapper;
import com.xtkj.pojo.ActivityCommentVo;
import com.xtkj.pojo.ActivityCommont;
import com.xtkj.pojo.ActivityCommontReply;

@Service("friendsCircleComment")
public class FriendsCircleCommentServiveImp implements IFriendsCircleCommentService{

	@Autowired
	private ActivityCommontMapper activityCommontMapper;
	@Autowired 
	private ActivityCommontReplyMapper activityCommontReplyMapper;
	
	/**
	 * -给活动写评论
	 */
	@Override
	public int friendsCircleComment(ActivityCommont activityCommont) {
		
		return activityCommontMapper.insert(activityCommont);
	}

	/**
	 * -删除评论
	 */
	@Override
	public int delComment(String commentId) {
		
		return activityCommontMapper.deleteByPrimaryKey(commentId);
	}
	
	
	/**
	 *-回复评论
	 */
	@Override
	public int replycomment(ActivityCommontReply activityCommontReply) {
		
		return activityCommontReplyMapper.insert(activityCommontReply);
	}

	/**
	 * -删除回复评论
	 */
	@Override
	public int delreplycomment(ActivityCommontReply activityCommontReply) {
		
		return activityCommontReplyMapper.deleteByPrimaryKey(activityCommontReply.getUserId());
		
	}
	
	
	public List<ActivityCommentVo> listComments(ActivityCommentVo activityCommentVo){
		
		return activityCommontReplyMapper.listComment(activityCommentVo);		
	};
	

}
