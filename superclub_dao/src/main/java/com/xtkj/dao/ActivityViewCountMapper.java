package com.xtkj.dao;

import com.xtkj.pojo.ActivityViewCount;

public interface ActivityViewCountMapper {
    int deleteByPrimaryKey(String id);

    int insert(ActivityViewCount record);

    int insertSelective(ActivityViewCount record);

    ActivityViewCount selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ActivityViewCount record);

    int updateByPrimaryKey(ActivityViewCount record);
}