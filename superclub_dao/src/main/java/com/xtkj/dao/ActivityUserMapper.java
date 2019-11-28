package com.xtkj.dao;

import com.xtkj.pojo.ActivityUser;
import com.xtkj.pojo.ActivityUserKey;

public interface ActivityUserMapper {
    int deleteByPrimaryKey(ActivityUserKey key);

    int insert(ActivityUser record);

    int insertSelective(ActivityUser record);

    ActivityUser selectByPrimaryKey(ActivityUserKey key);

    int updateByPrimaryKeySelective(ActivityUser record);

    int updateByPrimaryKey(ActivityUser record);
    
    ActivityUser selectByActivityId(String activityId);
}