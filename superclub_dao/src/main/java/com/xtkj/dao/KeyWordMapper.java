package com.xtkj.dao;

import com.xtkj.pojo.KeyWord;

public interface KeyWordMapper {
    int deleteByPrimaryKey(String keyId);

    int insert(KeyWord record);

    int insertSelective(KeyWord record);

    KeyWord selectByPrimaryKey(String keyId);

    int updateByPrimaryKeySelective(KeyWord record);

    int updateByPrimaryKey(KeyWord record);
}