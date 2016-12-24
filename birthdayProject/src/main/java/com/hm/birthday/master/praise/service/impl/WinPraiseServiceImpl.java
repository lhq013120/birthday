package com.hm.birthday.master.praise.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.birthday.entity.WinPraise;
import com.hm.birthday.enums.PraiseEnum;
import com.hm.birthday.master.praise.dao.WinPraiseMapper;
import com.hm.birthday.master.praise.service.IWinPraiseService;
import com.hm.birthday.master.praise.vo.PraiseVo;
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
	public PraiseVo getPraise() {
		
		int activeEndorse = 0;
		int activeOppose = 0;
		int prizeEndorse = 0;
		int prizeOppose = 0;
		PraiseVo p = null;
		Map<String, Object> sqlParam = new HashMap<String, Object>();
		try {
			sqlParam.put("activityType", PraiseEnum.TYPE_ACTIVE.value());
			sqlParam.put("isPraise", PraiseEnum.ENDORSE.value());
			activeEndorse = winPraiseMapper.selectCount(sqlParam);
			
			sqlParam.put("activityType", PraiseEnum.TYPE_ACTIVE.value());
			sqlParam.put("isPraise", PraiseEnum.OPPOSE.value());
			activeOppose = winPraiseMapper.selectCount(sqlParam);
			
			sqlParam.put("activityType", PraiseEnum.TYPE_PRIZE.value());
			sqlParam.put("isPraise", PraiseEnum.ENDORSE.value());
			prizeEndorse = winPraiseMapper.selectCount(sqlParam);
			
			sqlParam.put("activityType", PraiseEnum.TYPE_PRIZE.value());
			sqlParam.put("isPraise", PraiseEnum.OPPOSE.value());
			prizeOppose = winPraiseMapper.selectCount(sqlParam);
			p = new PraiseVo(activeEndorse, activeOppose, prizeEndorse, prizeOppose);
					
		} catch (Exception e) {
			logger.error("获取用户点赞总数系统异常",e);
		}
		return p;
	}

	@Override
	public PraiseVo add(String phoneNum, String typeActive, String isPraise) {
		PraiseVo count = null;
		WinPraise wp = new WinPraise();
		wp.setPhoneNum(phoneNum);
		wp.setActivityType(typeActive);
		wp.setIsPraise(isPraise);
		Date now = DateUtils.now();
		wp.setCreteTime(now);
		wp.setUpdateTime(now);
		try {
			if(get(phoneNum,typeActive) == null){ // 用户没有点过赞
			  winPraiseMapper.insert(wp);
			}
			count = getPraise();
		} catch (Exception e) {
			logger.error("用户点赞插入异常",e);
		}
		return count;
	}

	@Override
	public WinPraise get(String phoneNum,String typeActive) {
		WinPraise wp = null;
		try {
			Map<String, Object> sqlParam = new HashMap<String, Object>();
			sqlParam.put("phoneNum", phoneNum);
			sqlParam.put("activityType", typeActive);
			wp = winPraiseMapper.selectByPhoneNum(sqlParam);
		} catch (Exception e) {
			logger.error("获取用户点赞异常",e);
		}
		return wp;
	}
}
