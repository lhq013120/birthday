package com.hm.birthday.admin.worker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.hm.birthday.admin.worker.dao.WorkerMapper;
import com.hm.birthday.admin.worker.service.IWorkerService;
import com.hm.birthday.entity.Worker;

@Service("workerService")
public class WorkerServiceImpl implements IWorkerService {

	@Autowired
	private WorkerMapper workerMapper;
	
	@Override
	public PageList<Worker> queryWithPage(Worker w,PageBounds pageBounds) {
		
		try {
			return workerMapper.queryWithPage(w, pageBounds);
		} catch (Exception e) {
			e.printStackTrace();
		};
		return null;
	}
	
	
	
	
}
