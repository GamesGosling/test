package com.xtkj.dao;

import com.xtkj.pojo.Judge;

public interface JudgeMapper {
    int deleteByPrimaryKey(String id);

    int insert(Judge record);

    int insertSelective(Judge record);

    Judge selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Judge record);

    int updateByPrimaryKey(Judge record);
}