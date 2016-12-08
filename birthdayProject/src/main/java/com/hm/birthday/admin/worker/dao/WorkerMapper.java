package com.hm.birthday.admin.worker.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.hm.birthday.entity.WorkerInfo;

public interface WorkerMapper {
	
	public PageList<WorkerInfo> queryWithPage(WorkerInfo worker, PageBounds pageBounds) throws Exception;
	
}