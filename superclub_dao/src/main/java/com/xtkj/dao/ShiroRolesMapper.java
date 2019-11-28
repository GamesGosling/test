package com.xtkj.dao;

import com.xtkj.pojo.ShiroRoles;

public interface ShiroRolesMapper {
    int deleteByPrimaryKey(Short roleId);

    int insert(ShiroRoles record);

    int insertSelective(ShiroRoles record);

    ShiroRoles selectByPrimaryKey(Short roleId);

    int updateByPrimaryKeySelective(ShiroRoles record);

    int updateByPrimaryKey(ShiroRoles record);
}