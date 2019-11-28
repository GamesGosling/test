package com.xtkj.pojo;

import java.util.Date;

public class ActivityCommentVo {

	private String id;

    private String activityId;

    private User replyUserId;

    private User userId;

    private String commitContext;

    private Date updateTime;

    private Date createTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}



	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public User getReplyUserId() {
		return replyUserId;
	}

	public void setReplyUserId(User replyUserId) {
		this.replyUserId = replyUserId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}
	public String getCommitContext() {
		return commitContext;
	}

	public void setCommitContext(String commitContext) {
		this.commitContext = commitContext;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public ActivityCommentVo() {
		super();
	}
      
}
