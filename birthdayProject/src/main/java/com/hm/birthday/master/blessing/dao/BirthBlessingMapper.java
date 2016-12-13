package com.hm.birthday.master.blessing.dao;

import com.hm.birthday.entity.BirthBlessing;

public interface BirthBlessingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BirthBlessing record);

    int insertSelective(BirthBlessing record);

    BirthBlessing selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BirthBlessing record);

    int updateByPrimaryKey(BirthBlessing record);
}