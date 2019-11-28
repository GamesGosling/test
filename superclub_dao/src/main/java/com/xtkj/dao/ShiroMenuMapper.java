package com.xtkj.dao;

import com.xtkj.pojo.ShiroMenu;

public interface ShiroMenuMapper {
    int deleteByPrimaryKey(Short menuId);

    int insert(ShiroMenu record);

    int insertSelective(ShiroMenu record);

    ShiroMenu selectByPrimaryKey(Short menuId);

    int updateByPrimaryKeySelective(ShiroMenu record);

    int updateByPrimaryKey(ShiroMenu record);
}