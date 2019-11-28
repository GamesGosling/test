package com.xtkj.dao;

import java.util.List;

import com.xtkj.pojo.Product;

public interface ProductMapper {
    int deleteByPrimaryKey(String id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
    
    //按照商品热度显示商品
    List<Product> selectProducts();
}