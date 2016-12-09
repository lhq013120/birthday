package com.hm.birthday.admin.worker.service.impl;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.hm.birthday.admin.worker.dao.WorkerMapper;
import com.hm.birthday.admin.worker.service.IWorkerService;
import com.hm.birthday.entity.WorkerInfo;


@Service("workerService")
public class WorkerServiceImpl implements IWorkerService {
	
	private final Logger logger = LoggerFactory.getLogger(WorkerServiceImpl.class);
	
	@Autowired
	private WorkerMapper workerMapper;
	
	@Override
	public PageList<WorkerInfo> queryWithPage(WorkerInfo w,PageBounds pageBounds) throws Exception {
		
		try {
			return workerMapper.queryWithPage(w, pageBounds);
		} catch (Exception e) {
			logger.error("插叙员工信息失败", e);
		};
		return null;
	}

	@Override
	public Map<String,Object> login(String phoneNum,String password) throws Exception{
		Map<String,Object> map = workerMapper.selectByPhoneNumAndPass(phoneNum, password);
		return map;
	}

	@Override
	public int setFirstLogin(Integer id) throws Exception {
		WorkerInfo workerInfo = new WorkerInfo();
		workerInfo.setId(id);
		workerInfo.setIsfirstLogin("02");
		workerInfo.setUpdateTime(new Date());
		int update = workerMapper.updateByPrimaryKeySelective(workerInfo);
		return update;
	}
	
}
