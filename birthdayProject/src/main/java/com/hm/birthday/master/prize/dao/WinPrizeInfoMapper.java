package com.hm.birthday.master.prize.dao;

import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.hm.birthday.entity.WinPrizeInfo;

public interface WinPrizeInfoMapper {
	
	public PageList<WinPrizeInfo> queryWithPage(Map<String, Object> param, PageBounds pageBounds) throws Exception;
	
	int deleteByPrimaryKey(Integer id);

	int insert(WinPrizeInfo record);

	int insertSelective(WinPrizeInfo record);

	WinPrizeInfo selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(WinPrizeInfo record);

	int updateByPrimaryKey(WinPrizeInfo record);
}