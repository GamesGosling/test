package com.xtkj.dao;

import com.xtkj.pojo.AdviceShenhe;

public interface AdviceShenheMapper {
    int deleteByPrimaryKey(String id);

    int insert(AdviceShenhe record);

    int insertSelective(AdviceShenhe record);

    AdviceShenhe selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AdviceShenhe record);

    int updateByPrimaryKey(AdviceShenhe record);
}