package com.hm.birthday.master.praise.dao;

import com.hm.birthday.entity.WinPraise;

/**
 * 
 * 用户点赞 DAO
 * 
 * @author hanyd
 *
 */
public interface WinPraiseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WinPraise record);

    int insertSelective(WinPraise record);

    WinPraise selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WinPraise record);

    int updateByPrimaryKey(WinPraise record);
}