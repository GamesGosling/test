package com.xtkj.dao;

import com.xtkj.pojo.ShiroUser;

public interface ShiroUserMapper {
    int deleteByPrimaryKey(Short userId);

    int insert(ShiroUser record);

    int insertSelective(ShiroUser record);

    ShiroUser selectByPrimaryKey(Short userId);

    int updateByPrimaryKeySelective(ShiroUser record);

    int updateByPrimaryKey(ShiroUser record);
}