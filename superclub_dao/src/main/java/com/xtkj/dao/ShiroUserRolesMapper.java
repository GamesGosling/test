package com.xtkj.dao;

import com.xtkj.pojo.ShiroUserRolesKey;

public interface ShiroUserRolesMapper {
    int deleteByPrimaryKey(ShiroUserRolesKey key);

    int insert(ShiroUserRolesKey record);

    int insertSelective(ShiroUserRolesKey record);
}