package com.xtkj.dao;

import com.xtkj.pojo.ActivityCommont;

public interface ActivityCommontMapper {
    int deleteByPrimaryKey(String id);

    int insert(ActivityCommont record);

    int insertSelective(ActivityCommont record);

    ActivityCommont selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ActivityCommont record);

    int updateByPrimaryKey(ActivityCommont record);
}