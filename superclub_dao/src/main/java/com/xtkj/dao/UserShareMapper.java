package com.xtkj.dao;

import com.xtkj.pojo.UserShare;

public interface UserShareMapper {
	
    int deleteByPrimaryKey(String id);

    int insert(UserShare record);

    int insertSelective(UserShare record);

    UserShare selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserShare record);

    int updateByPrimaryKey(UserShare record);
}