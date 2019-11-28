package com.xtkj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xtkj.pojo.ProductColor;

public interface ProductColorMapper {
    int deleteByPrimaryKey(String id);

    int insert(ProductColor record);

    int insertSelective(ProductColor record);

    ProductColor selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ProductColor record);

    int updateByPrimaryKey(ProductColor record);
    
    List<ProductColor> selectByKey(@Param("productId") String productId);
}