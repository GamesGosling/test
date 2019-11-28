package com.xtkj.dao;

import com.xtkj.pojo.Order;
import com.xtkj.pojo.OrderKey;

public interface OrderMapper {
    int deleteByPrimaryKey(OrderKey key);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(OrderKey key);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
 
    /**
     * -向订单表中插入数据，并返回订单编号主键
     * @param record
     * @return
     */
    int insertOrders(Order record);
}