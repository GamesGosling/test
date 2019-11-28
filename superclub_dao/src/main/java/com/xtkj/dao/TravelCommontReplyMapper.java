package com.xtkj.dao;

import com.xtkj.pojo.TravelCommontReply;

public interface TravelCommontReplyMapper {
    int deleteByPrimaryKey(String id);

    int insert(TravelCommontReply record);

    int insertSelective(TravelCommontReply record);

    TravelCommontReply selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TravelCommontReply record);

    int updateByPrimaryKey(TravelCommontReply record);
}