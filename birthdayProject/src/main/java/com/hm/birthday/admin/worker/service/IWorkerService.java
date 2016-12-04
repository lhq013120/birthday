package com.hm.birthday.admin.worker.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.hm.birthday.entity.Worker;

public interface IWorkerService {
	
	public PageList<Worker> queryWithPage(Worker w, PageBounds pageBounds);
	
}
