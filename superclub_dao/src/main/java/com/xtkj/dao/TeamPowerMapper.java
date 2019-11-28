package com.xtkj.dao;

import com.xtkj.pojo.TeamPower;

public interface TeamPowerMapper {
    int deleteByPrimaryKey(String id);

    int insert(TeamPower record);

    int insertSelective(TeamPower record);

    TeamPower selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TeamPower record);

    int updateByPrimaryKey(TeamPower record);
}