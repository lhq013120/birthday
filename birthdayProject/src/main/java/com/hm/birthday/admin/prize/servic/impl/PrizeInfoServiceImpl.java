package com.hm.birthday.admin.prize.servic.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.hm.birthday.admin.prize.dao.PrizeInfoMapper;
import com.hm.birthday.admin.prize.servic.IPrizeInfoService;
import com.hm.birthday.admin.worker.service.impl.WorkerServiceImpl;
import com.hm.birthday.entity.PrizeInfo;

@Service("prizeInfoService")
public class PrizeInfoServiceImpl implements IPrizeInfoService {
	
	private final Logger logger = LoggerFactory.getLogger(WorkerServiceImpl.class);
	
	@Autowired
	private PrizeInfoMapper prizeInfoMapper;
	
	@Override
	public PageList<PrizeInfo> queryWithPage(PrizeInfo p, PageBounds pageBounds) throws Exception {
		try {
			return prizeInfoMapper.queryWithPage(p, pageBounds);
		} catch (Exception e) {
			logger.error("查询奖品信息系统异常", e);
			throw e;
		}
	}

}
