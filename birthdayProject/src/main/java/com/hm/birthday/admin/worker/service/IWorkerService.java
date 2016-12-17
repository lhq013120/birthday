package com.hm.birthday.admin.worker.service;

import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.hm.birthday.entity.WorkerInfo;
import com.hm.birthday.enums.RetMsg;

public interface IWorkerService {
	
	public PageList<WorkerInfo> queryWithPage(WorkerInfo w, PageBounds pageBounds) throws Exception;
	/**
	 * 用户登录用service
	 * 
	 * @param phoneNum
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> login(String phoneNum,String password) throws Exception;
	
	public int setFirstLogin(Integer id) throws Exception;
	
	public RetMsg AddWorker(WorkerInfo workerInfo) throws Exception;
	
	public int updateWorker(WorkerInfo workerInfo) throws Exception;
	
	public int updateByPhone(WorkerInfo workerInfo) throws Exception;
	
	public int deleteWorker(Integer id) throws Exception;
	
	public WorkerInfo getWorker(Integer id) throws Exception;
	
	public WorkerInfo getWorkerByPhone(String phoneNum) throws Exception;
}
