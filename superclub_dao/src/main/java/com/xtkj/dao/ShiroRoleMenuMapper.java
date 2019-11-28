package com.xtkj.dao;

import com.xtkj.pojo.ShiroRoleMenuKey;

public interface ShiroRoleMenuMapper {
    int deleteByPrimaryKey(ShiroRoleMenuKey key);

    int insert(ShiroRoleMenuKey record);

    int insertSelective(ShiroRoleMenuKey record);
}