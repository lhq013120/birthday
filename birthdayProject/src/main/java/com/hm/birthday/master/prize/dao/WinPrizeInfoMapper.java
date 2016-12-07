package com.hm.birthday.master.prize.dao;

import com.hm.birthday.entity.WinPrizeInfo;

public interface WinPrizeInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WinPrizeInfo record);

    int insertSelective(WinPrizeInfo record);

    WinPrizeInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WinPrizeInfo record);

    int updateByPrimaryKey(WinPrizeInfo record);
}