package com.hm.birthday.admin.worker.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.hm.birthday.entity.WorkerInfo;

public interface IWorkerService {
	
	public PageList<WorkerInfo> queryWithPage(WorkerInfo w, PageBounds pageBounds);
	
}
