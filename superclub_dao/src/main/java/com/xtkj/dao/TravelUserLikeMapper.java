package com.xtkj.dao;

import com.xtkj.pojo.TravelUserLike;
import com.xtkj.pojo.TravelUserLikeKey;

public interface TravelUserLikeMapper {
    int deleteByPrimaryKey(TravelUserLikeKey key);

    int insert(TravelUserLike record);

    int insertSelective(TravelUserLike record);

    TravelUserLike selectByPrimaryKey(TravelUserLikeKey key);

    int updateByPrimaryKeySelective(TravelUserLike record);

    int updateByPrimaryKey(TravelUserLike record);
}