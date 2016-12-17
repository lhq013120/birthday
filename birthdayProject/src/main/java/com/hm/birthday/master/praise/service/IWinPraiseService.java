package com.hm.birthday.master.praise.service;

import com.hm.birthday.entity.WinPraise;

/**
 * 
 * 用户点赞服务接口
 * 
 * @author hanyd
 *
 */
public interface IWinPraiseService {
	/**
	 * 用户点赞总数
	 * 
	 * @return
	 */
	int getPraise();
	
	/**
	 * 
	 * 用户是否已经点过赞
	 * 
	 * @param phoneNum
	 * @return
	 */
	WinPraise get(String phoneNum);
	
	/**
	 * 插入用户点赞，并返回当前点赞的总数
	 * 
	 * @param phoneNum
	 * @return
	 */
	int add(String phoneNum);
}
