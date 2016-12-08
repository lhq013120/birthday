package com.hm.birthday.admin.dict.dao;

import com.hm.birthday.entity.BaseDicInfo;

public interface BaseDicInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaseDicInfo record);

    int insertSelective(BaseDicInfo record);

    BaseDicInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseDicInfo record);

    int updateByPrimaryKey(BaseDicInfo record);
}