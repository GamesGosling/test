package com.xtkj.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.xtkj.pojo.Travel;
import com.xtkj.pojo.TravelKey;
import com.xtkj.pojo.User;

public interface TravelMapper {
    int deleteByPrimaryKey(TravelKey key);

    int insert(Travel record);

    int insertSelective(Travel record);

    Travel selectByPrimaryKey(TravelKey key);

    int updateByPrimaryKeySelective(Travel record);

    int updateByPrimaryKey(Travel record);
    
    
    /**
     * 获得用户的游记列表
     * @param user
     * @return
     */
    @Select("select * from tb_travel where user_id ='#{userId}'")
    @ResultMap("com.xtkj.dao.TravelMapper.BaseResultHasUser")
    List<Travel> listTrvel(User user);
}