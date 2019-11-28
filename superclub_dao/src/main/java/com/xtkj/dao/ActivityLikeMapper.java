package com.xtkj.dao;

import com.xtkj.pojo.ActivityLike;

public interface ActivityLikeMapper {
    int deleteByPrimaryKey(String activityId)throws Exception;

    int insert(ActivityLike record)throws Exception;

    int insertSelective(ActivityLike record)throws Exception;

    ActivityLike selectByPrimaryKey(String activityId)throws Exception;

    int updateByPrimaryKeySelective(ActivityLike record)throws Exception;

    int updateByPrimaryKey(ActivityLike record)throws Exception;
    
    int deleteByUserId(String id)throws Exception;
   
}