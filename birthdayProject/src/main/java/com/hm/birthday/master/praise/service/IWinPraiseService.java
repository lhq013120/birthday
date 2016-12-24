package com.hm.birthday.master.praise.service;

import com.hm.birthday.entity.WinPraise;
import com.hm.birthday.master.praise.vo.PraiseVo;

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
	PraiseVo getPraise();
	
	/**
	 * 
	 * 用户是否已经点过赞
	 * 
	 * @param phoneNum
	 * @return
	 */
	WinPraise get(String phoneNum, String typeActive);
	
	/**
	 * 插入用户点赞，并返回当前点赞的总数
	 * 
	 * @param phoneNum
	 * @return
	 */
	PraiseVo add(String phoneNum,  String typeActive, String isPraise);
}
