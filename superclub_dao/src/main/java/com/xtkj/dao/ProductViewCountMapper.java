package com.xtkj.dao;

import com.xtkj.pojo.ProductViewCount;

public interface ProductViewCountMapper {
    int deleteByPrimaryKey(String id);

    int insert(ProductViewCount record);

    int insertSelective(ProductViewCount record);

    ProductViewCount selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ProductViewCount record);

    int updateByPrimaryKey(ProductViewCount record);
}