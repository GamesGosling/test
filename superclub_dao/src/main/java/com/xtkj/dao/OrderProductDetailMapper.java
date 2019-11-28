package com.xtkj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.xtkj.pojo.OrderProductDetail;

public interface OrderProductDetailMapper {
    int deleteByPrimaryKey(String id);

    int insert(OrderProductDetail record);

    int insertSelective(OrderProductDetail record);

    OrderProductDetail selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OrderProductDetail record);

    int updateByPrimaryKey(OrderProductDetail record);
    
    
    @Select("select extract(YEAR from CREATE_TIME) as dates,(SELECT pro.PRODUCT_NAME from TB_PRODUCT pro where pro.id =datail.PRODUCT_ID) names,\r\n" + 
    		"sum(NUM) sales from HXX.TB_ORDER_PRODUCT_DETAIL datail GROUP BY (extract(YEAR from datail.CREATE_TIME)),datail.PRODUCT_ID ORDER BY extract(YEAR from datail.CREATE_TIME)")
	List<OrderProductDetail> selectYear();
	
	@Select("select to_char(CREATE_TIME,'yyyy-mm') dates,(SELECT pro.PRODUCT_NAME from TB_PRODUCT pro where pro.id =datail.PRODUCT_ID) names,sum(NUM) sales from HXX.TB_ORDER_PRODUCT_DETAIL datail group by to_char(CREATE_TIME,'yyyy-mm'),datail.PRODUCT_ID order by to_char(CREATE_TIME,'yyyy-mm')")
	List<OrderProductDetail> selectMonth();
	
	@Select("select to_char(CREATE_TIME,'yyyy-Q') dates,DECODE(extract(MONTH from TO_DATE(to_char(CREATE_TIME,'yyyy-Q'), 'yyyy-mm')),1,'春',2,'夏',3,'秋','冬') quarter,(SELECT pro.PRODUCT_NAME from TB_PRODUCT pro where pro.id =datail.PRODUCT_ID) names,sum(NUM) sales from HXX.TB_ORDER_PRODUCT_DETAIL datail group by to_char(CREATE_TIME,'yyyy-Q'),datail.PRODUCT_ID order by to_char(CREATE_TIME,'yyyy-Q')")
	List<OrderProductDetail> selectQuarter();
	
	@Select("select to_char(CREATE_TIME,'yyyy-MM-dd') dates,(SELECT pro.PRODUCT_NAME from TB_PRODUCT pro where pro.id =datail.PRODUCT_ID) names,sum(NUM) sales from HXX.TB_ORDER_PRODUCT_DETAIL datail group by to_char(CREATE_TIME,'yyyy-MM-dd'),datail.PRODUCT_ID order by to_char(CREATE_TIME,'yyyy-MM-dd')")
	List<OrderProductDetail> selectDay();
}