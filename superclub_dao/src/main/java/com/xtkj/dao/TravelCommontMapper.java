package com.xtkj.dao;

import com.xtkj.pojo.TravelCommont;

public interface TravelCommontMapper {
    int deleteByPrimaryKey(String id);

    int insert(TravelCommont record);

    int insertSelective(TravelCommont record);

    TravelCommont selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TravelCommont record);

    int updateByPrimaryKey(TravelCommont record);
}