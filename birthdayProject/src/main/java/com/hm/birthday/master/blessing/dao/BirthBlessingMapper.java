package com.hm.birthday.master.blessing.dao;

import java.util.List;

import com.hm.birthday.entity.BirthBlessing;

public interface BirthBlessingMapper {

    int insert(BirthBlessing record) throws Exception;

    List<BirthBlessing> selectAllByMonth(String birthPersonPnum) throws Exception;
}