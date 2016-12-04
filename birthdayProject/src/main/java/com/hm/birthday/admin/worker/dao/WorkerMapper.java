package com.hm.birthday.admin.worker.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.hm.birthday.entity.Worker;

public interface WorkerMapper {
	
	public PageList<Worker> queryWithPage(Worker worker, PageBounds pageBounds) throws Exception;
	
    int deleteByPrimaryKey(String phonenum)throws Exception;

    int insert(Worker record);

    Worker selectByPrimaryKey(String phonenum) throws Exception;

    int updateByPrimaryKey(Worker record) throws Exception;
}