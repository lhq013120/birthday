package com.hm.birthday.admin.dict.dao;

import java.util.List;

import com.hm.birthday.entity.BaseDicInfo;

public interface BaseDicInfoMapper {

    List<BaseDicInfo> selectByType(String type) throws Exception;
}