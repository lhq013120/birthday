package com.hm.birthday.master.prize.dao;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.hm.birthday.entity.WinPrizeInfo;

public interface WinPrizeInfoMapper {
	
	public PageList<WinPrizeInfo> queryWithPage(Map<String, Object> param, PageBounds pageBounds) throws Exception;
	
	/**
	 * 获取当月获奖用户信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<WinPrizeInfo> selectCurrentMonthLucky() throws Exception;
	
	public int insert(WinPrizeInfo winPrizeInfo) throws Exception;
	
	public WinPrizeInfo selectByPhoneWithYear(String phoneNum) throws Exception;
	
	/**
	 * 删除获奖信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int deleteByPrimaryKey(Integer id) throws Exception;
	
}