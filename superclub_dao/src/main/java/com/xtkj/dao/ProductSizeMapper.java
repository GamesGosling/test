package com.xtkj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xtkj.pojo.ProductSize;

public interface ProductSizeMapper {
    int deleteByPrimaryKey(String id);

    int insert(ProductSize record);

    int insertSelective(ProductSize record);

    ProductSize selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ProductSize record);

    int updateByPrimaryKey(ProductSize record);
    
    /**
     * -根据商品ID和颜色查询商品颜色
     * @param proId
     * @param colorId
     * @return
     */
    List<ProductSize> selectSizeByProIdColor(@Param("proId")String proId,@Param("colorId")String colorId);
}