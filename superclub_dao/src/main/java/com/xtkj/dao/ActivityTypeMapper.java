package com.xtkj.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.xtkj.pojo.ActivityType;

public interface ActivityTypeMapper {
    int deleteByPrimaryKey(String activityTypeId);

    int insert(ActivityType record);

    int insertSelective(ActivityType record);

    ActivityType selectByPrimaryKey(String activityTypeId);

    int updateByPrimaryKeySelective(ActivityType record);

    int updateByPrimaryKey(ActivityType record)throws Exception;
    
    @Select("select * from TB_ACTIVITY_TYPE")
    @ResultMap("BaseResultMap")
    List<ActivityType> selectActivityTypes()throws Exception;
}