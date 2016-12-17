package com.hm.birthday.master.blessing.dao;

import com.hm.birthday.entity.BirthBlessing;

public interface BirthBlessingMapper {
    int deleteByPrimaryKey(Integer id) throws Exception;

    int insert(BirthBlessing record) throws Exception;;

    int insertSelective(BirthBlessing record) throws Exception;

    BirthBlessing selectByPrimaryKey(Integer id) throws Exception;

    int updateByPrimaryKeySelective(BirthBlessing record) throws Exception;

    int updateByPrimaryKey(BirthBlessing record) throws Exception;
}