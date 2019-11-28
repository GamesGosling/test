package com.xtkj.dao;

import com.xtkj.pojo.ShiroRolesPermissionsKey;

public interface ShiroRolesPermissionsMapper {
    int deleteByPrimaryKey(ShiroRolesPermissionsKey key);

    int insert(ShiroRolesPermissionsKey record);

    int insertSelective(ShiroRolesPermissionsKey record);
}