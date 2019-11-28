package com.xtkj.dao;

import com.xtkj.pojo.NewInfor;

public interface NewInforMapper {
    int deleteByPrimaryKey(String inforId);

    int insert(NewInfor record);

    int insertSelective(NewInfor record);

    NewInfor selectByPrimaryKey(String inforId);

    int updateByPrimaryKeySelective(NewInfor record);

    int updateByPrimaryKey(NewInfor record);
}