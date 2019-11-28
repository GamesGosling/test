package com.xtkj.dao;

import com.xtkj.pojo.TourRole;

public interface TourRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(TourRole record);

    int insertSelective(TourRole record);

    TourRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TourRole record);

    int updateByPrimaryKey(TourRole record);
}