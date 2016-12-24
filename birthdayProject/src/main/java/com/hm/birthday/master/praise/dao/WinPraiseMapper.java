package com.hm.birthday.master.praise.dao;

import java.util.Map;

import com.hm.birthday.entity.WinPraise;

/**
 * 
 * 用户点赞 DAO
 * 
 * @author hanyd
 *
 */
public interface WinPraiseMapper {
	
	int selectCount(Map<String, Object> param) throws Exception;

    int insert(WinPraise record) throws Exception;

    WinPraise selectByPhoneNum(Map<String, Object> param) throws Exception;
    
    
}