package com.hm.birthday.admin.prize.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.hm.birthday.entity.PrizeInfo;

public interface PrizeInfoMapper {
	PageList<PrizeInfo> queryWithPage(PrizeInfo prizeInfo, PageBounds pageBounds) throws Exception;
    int deleteByPrimaryKey(Integer id) throws Exception;

    int insert(PrizeInfo record) throws Exception;

    int insertSelective(PrizeInfo record) throws Exception;

    PrizeInfo selectByPrimaryKey(Integer id) throws Exception;

    int updateByPrimaryKeySelective(PrizeInfo record) throws Exception;

    int updateByPrimaryKey(PrizeInfo record) throws Exception;
}