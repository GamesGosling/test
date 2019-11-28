package com.xtkj.dao;

import com.xtkj.pojo.ShiroPermissions;

public interface ShiroPermissionsMapper {
    int deleteByPrimaryKey(Short pId);

    int insert(ShiroPermissions record);

    int insertSelective(ShiroPermissions record);

    ShiroPermissions selectByPrimaryKey(Short pId);

    int updateByPrimaryKeySelective(ShiroPermissions record);

    int updateByPrimaryKey(ShiroPermissions record);
}