package com.xtkj.dao;

import com.xtkj.pojo.Limit;

public interface LimitMapper {
    int deleteByPrimaryKey(String id);

    int insert(Limit record);

    int insertSelective(Limit record);

    Limit selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Limit record);

    int updateByPrimaryKey(Limit record);
}