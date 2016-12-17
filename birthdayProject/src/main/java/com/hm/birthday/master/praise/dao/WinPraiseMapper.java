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
	
	int selectCount() throws Exception;

    int insert(WinPraise record) throws Exception;

    WinPraise selectByPhoneNum(String phoneNum) throws Exception;
    
    
}