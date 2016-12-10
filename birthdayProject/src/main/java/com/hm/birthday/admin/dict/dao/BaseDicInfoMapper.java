package com.hm.birthday.admin.dict.dao;

import java.util.List;

import com.hm.birthday.entity.BaseDicInfo;

public interface BaseDicInfoMapper {
    int deleteByPrimaryKey(Integer id) throws Exception;

    int insert(BaseDicInfo record) throws Exception;

    int insertSelective(BaseDicInfo record) throws Exception;

    BaseDicInfo selectByPrimaryKey(Integer id) throws Exception;

    int updateByPrimaryKeySelective(BaseDicInfo record) throws Exception;

    int updateByPrimaryKey(BaseDicInfo record) throws Exception;
    
    List<BaseDicInfo> selectByType(String type) throws Exception;
}