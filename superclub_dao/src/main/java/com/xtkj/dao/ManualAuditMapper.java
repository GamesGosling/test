package com.xtkj.dao;

import com.xtkj.pojo.ManualAudit;

public interface ManualAuditMapper {
    int deleteByPrimaryKey(String artId);

    int insert(ManualAudit record);

    int insertSelective(ManualAudit record);

    ManualAudit selectByPrimaryKey(String artId);

    int updateByPrimaryKeySelective(ManualAudit record);

    int updateByPrimaryKey(ManualAudit record);
}