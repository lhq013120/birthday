package com.hm.birthday.master.praise.service;

import com.hm.birthday.entity.WinPraise;
import com.hm.birthday.enums.RetMsg;

/**
 * 
 * 用户点赞服务接口
 * 
 * @author hanyd
 *
 */
public interface IWinPraiseService {
	
	int getPraise();
	
	RetMsg add(WinPraise Praise);
}
