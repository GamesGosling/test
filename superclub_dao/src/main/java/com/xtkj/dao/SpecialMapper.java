package com.xtkj.dao;

import com.xtkj.pojo.Special;

public interface SpecialMapper {
    int insert(Special record);

    int insertSelective(Special record);
}