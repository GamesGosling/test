package com.xtkj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.xtkj.pojo.KeyWords;

public interface KeyWordsMapper {
    int deleteByPrimaryKey(String id);

    int insert(KeyWords record);

    int insertSelective(KeyWords record);

    KeyWords selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(KeyWords record);

    int updateByPrimaryKey(KeyWords record);
    
    @Select("select * from TB_KEY_WORDS where use=1")
    @ResultMap("com.xtkj.dao.KeyWordsMapper.BaseResultMap")
    List<KeyWords> listKeys();
    
    @Delete("delete from TB_KEY_WORDS where KEY_WORDS=#{content}")
    int deleteKey(@Param("content") String content);
}