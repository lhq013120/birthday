package com.hm.birthday.admin.prize.dao;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.hm.birthday.entity.PrizeInfo;

public interface PrizeInfoMapper {
	
	/**
	 * 获取奖品信息包含分页控件
	 * 
	 * @param prizeInfo
	 * @param pageBounds
	 * @return
	 * @throws Exception
	 */
	PageList<PrizeInfo> queryWithPage(PrizeInfo prizeInfo, PageBounds pageBounds) throws Exception;
	/**
	 * 获取奖品信息 不分页
	 * 
	 * @param prizeInfo
	 * @return
	 * @throws Exception
	 */
	List<PrizeInfo> queryAll(PrizeInfo prizeInfo) throws Exception;
 
}