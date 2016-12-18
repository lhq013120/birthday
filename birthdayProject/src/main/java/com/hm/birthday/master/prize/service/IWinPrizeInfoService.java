package com.hm.birthday.master.prize.service;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.hm.birthday.entity.WinPrizeInfo;
import com.hm.birthday.master.prize.vo.PrizeVo;
import com.hm.birthday.master.prize.vo.WinPrizeVo;

public interface IWinPrizeInfoService {
	/**
	 * 分页查询查询用户中奖信息
	 * 
	 * @param param
	 * @param pageBounds
	 * @return
	 * @throws Exception
	 */
	public PageList<WinPrizeInfo> queryWithPage(Map<String,Object> param, PageBounds pageBounds) throws Exception;
	
	/**
	 * 获取本月所有过生日人的中奖纪录
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public List<WinPrizeVo> currentMonthWinPrizeInfo() throws Exception;
	
	/**
	 * 用户抽奖
	 * 
	 * @param phoneNum 用户名
	 * @param workerName 员工姓名
	 * @return 抽奖结果
	 * @throws Exception
	 */
	public PrizeVo luckyDraw(String phoneNum,String workerName) throws Exception;

	/**
	 * 获取所有的奖品信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<PrizeVo> allPrize() throws Exception;
	
	/**
	 * 获取用户当年的抽奖记录
	 * @return
	 * @throws Exception 
	 */
	public WinPrizeInfo getByPhoneWithYear(String phoneNum) throws Exception;
}
