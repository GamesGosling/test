package com.xtkj.dao;

import com.xtkj.pojo.RolePower;
import com.xtkj.pojo.RolePowerKey;

public interface RolePowerMapper {
    int deleteByPrimaryKey(RolePowerKey key);

    int insert(RolePower record);

    int insertSelective(RolePower record);

    RolePower selectByPrimaryKey(RolePowerKey key);

    int updateByPrimaryKeySelective(RolePower record);

    int updateByPrimaryKey(RolePower record);
}