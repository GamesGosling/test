package com.xtkj.controller.friendscircle;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xtkj.pojo.ActivityCommentVo;
import com.xtkj.pojo.ActivityCommont;
import com.xtkj.pojo.ActivityCommontReply;
import com.xtkj.service.friendcircle.IFriendsCircleCommentService;
import com.xtkj.utils.ObjectResult;

@Controller
@RequestMapping("/friendsCommentController")
public class FriendsCommentController{

	@Resource
	private IFriendsCircleCommentService friendsCircleComment;

	/**
	 * -获取评论列表
	 */
	@RequestMapping("/listComments")
	@ResponseBody
	public ObjectResult listComments(ActivityCommentVo activityCommentVo ) {
		ObjectResult json = null; 
		try {
			List<ActivityCommentVo> list=friendsCircleComment.listComments(activityCommentVo);
			
			json=new ObjectResult("200", "success",list);

		} catch (Exception e) {
			e.printStackTrace();
			json=new ObjectResult("500", "error", e.getMessage());
		}

		return json;	
	}




	/**
	 * -给活动评论
	 * @param request
	 * @return 
	 */
	@RequestMapping("/addcomment")
	@ResponseBody
	public ObjectResult friendsCircleComment(HttpServletRequest request,ActivityCommont activityCommont) {
		ObjectResult json = null; 
		try {
			int i=friendsCircleComment.friendsCircleComment(activityCommont);

			if(i>0) {
				json=new ObjectResult("200", "success","评论成功");
			}else {
				json=new ObjectResult("200", "fail","评论失败");
			}

		} catch (Exception e) {
			e.printStackTrace();
			json=new ObjectResult("500", "error", e.getMessage());
		}

		return json;		
	}


	/**
	 * -删除评论
	 * @param request
	 * @param activityCommont
	 * @return
	 */
	@RequestMapping("/delcomment")
	@ResponseBody
	public ObjectResult delComment(HttpServletRequest request,ActivityCommont activityCommont) {
		ObjectResult json = null; 
		try {
			int i=friendsCircleComment.delComment(activityCommont.getActivityId());
			if(i>0) {
				json=new ObjectResult("200", "success","删除成功");
			}else {
				json=new ObjectResult("200", "fail","删除失败");
			}

		} catch (Exception e) {
			e.printStackTrace();
			json=new ObjectResult("500", "error", e.getMessage());
		}

		return json;		
	}

	/**
	 * -回复评论
	 * @param request
	 * @param activityCommont
	 * @return
	 */
	@RequestMapping("/replycomment")
	@ResponseBody
	public ObjectResult replyComment(HttpServletRequest request,ActivityCommontReply activityCommontReply) {
		ObjectResult json = null; 
		try {
			int i=friendsCircleComment.replycomment(activityCommontReply);
			if(i>0) {
				json=new ObjectResult("200", "success","回复成功");
			}else {
				json=new ObjectResult("200", "fail","回复失败");
			}

		} catch (Exception e) {
			e.printStackTrace();
			json=new ObjectResult("500", "error", e.getMessage());
		}

		return json;		
	}

	/**
	 * -删除回复评论
	 * @param request
	 * @param activityCommontReply
	 * @return
	 */
	@RequestMapping("/delreplycomment")
	@ResponseBody
	public ObjectResult delreplyComment(HttpServletRequest request,ActivityCommontReply activityCommontReply) {
		ObjectResult json = null; 
		try {
			int i=friendsCircleComment.delreplycomment(activityCommontReply);
			if(i>0) {
				json=new ObjectResult("200", "success","删除评论成功");
			}else {
				json=new ObjectResult("200", "fail","删除评论失败");
			}

		} catch (Exception e) {
			e.printStackTrace();
			json=new ObjectResult("500", "error", e.getMessage());
		}

		return json;		
	}

}
