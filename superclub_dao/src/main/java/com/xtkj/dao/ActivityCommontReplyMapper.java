package com.xtkj.dao;

import java.util.List;

import com.xtkj.pojo.ActivityCommentVo;
import com.xtkj.pojo.ActivityCommontReply;

public interface ActivityCommontReplyMapper {
    int deleteByPrimaryKey(String id);

    int insert(ActivityCommontReply record);

    int insertSelective(ActivityCommontReply record);

    ActivityCommontReply selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ActivityCommontReply record);

    int updateByPrimaryKey(ActivityCommontReply record);
    
    List<ActivityCommentVo> listComment(ActivityCommentVo activityCommentVo);
}