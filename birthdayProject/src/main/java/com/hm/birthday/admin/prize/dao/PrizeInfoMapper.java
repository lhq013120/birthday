package com.hm.birthday.admin.prize.dao;

import com.hm.birthday.entity.PrizeInfo;

public interface PrizeInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PrizeInfo record);

    int insertSelective(PrizeInfo record);

    PrizeInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PrizeInfo record);

    int updateByPrimaryKey(PrizeInfo record);
}