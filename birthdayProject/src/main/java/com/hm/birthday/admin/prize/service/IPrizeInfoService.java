package com.hm.birthday.admin.prize.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.hm.birthday.entity.PrizeInfo;

public interface IPrizeInfoService {
	
	public PageList<PrizeInfo> queryWithPage(PrizeInfo w, PageBounds pageBounds) throws Exception;
}
