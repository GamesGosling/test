package com.xtkj.dao;

import com.xtkj.pojo.RoderProduct;

public interface RoderProductMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(RoderProduct record);

    int insertSelective(RoderProduct record);

    RoderProduct selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(RoderProduct record);

    int updateByPrimaryKey(RoderProduct record);
}