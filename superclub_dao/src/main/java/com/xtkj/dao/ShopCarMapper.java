package com.xtkj.dao;

import com.xtkj.pojo.ShopCar;

public interface ShopCarMapper {
    int deleteByPrimaryKey(String id);

    int insert(ShopCar record);

    int insertSelective(ShopCar record);

    ShopCar selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ShopCar record);

    int updateByPrimaryKey(ShopCar record);
}