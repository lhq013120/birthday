package com.hm.birthday.master.praise.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.birthday.entity.WinPraise;
import com.hm.birthday.master.praise.dao.WinPraiseMapper;
import com.hm.birthday.master.praise.service.IWinPraiseService;
import com.hm.birthday.utils.DateUtils;

/**
 * 
 * 用户点赞服务类
 * 
 * @author hanyd
 *
 */
@Service("winPraiseService")
public class WinPraiseServiceImpl implements IWinPraiseService {

	private final static Logger logger = LoggerFactory.getLogger(WinPraiseServiceImpl.class);
	
	@Autowired
	private WinPraiseMapper winPraiseMapper;
	
	/**
	 * 获取点赞总数
	 * 
	 */
	@Override
	public int getPraise() {
		int count = 0;
		try {
			count = winPraiseMapper.selectCount();
		} catch (Exception e) {
			logger.error("获取用户点赞总数系统异常",e);
		}
		return count;
	}

	@Override
	public int add(String phoneNum) {
		int count = 0;
		WinPraise wp = new WinPraise();
		wp.setPhoneNum(phoneNum);
		Date now = DateUtils.now();
		wp.setCreteTime(now);
		wp.setUpdateTime(now);
		try {
			if(get(phoneNum) == null){ // 用户没有点过赞
			  winPraiseMapper.insert(wp);
			}
			count = getPraise();
		} catch (Exception e) {
			logger.error("用户点赞插入异常",e);
		}
		return count;
	}

	@Override
	public WinPraise get(String phoneNum) {
		WinPraise wp = null;
		try {
			wp = winPraiseMapper.selectByPhoneNum(phoneNum);
		} catch (Exception e) {
			logger.error("获取用户点赞异常",e);
		}
		return wp;
	}
}
