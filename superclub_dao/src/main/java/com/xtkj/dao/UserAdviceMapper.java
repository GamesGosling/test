package com.xtkj.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.xtkj.pojo.UserAdvice;

public interface UserAdviceMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserAdvice record);

    int insertSelective(UserAdvice record);

    UserAdvice selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserAdvice record);

    int updateByPrimaryKey(UserAdvice record);
    
    @Select("select * from TB_USER_ADVICE")
    @ResultMap("com.xtkj.dao.UserAdviceMapper.BaseResultMap")
    List<UserAdvice> listUserAdvice();
}