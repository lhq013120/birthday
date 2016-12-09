package com.hm.birthday.admin.worker.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.hm.birthday.entity.WorkerInfo;

public interface WorkerMapper {
	
	public PageList<WorkerInfo> queryWithPage(WorkerInfo worker, PageBounds pageBounds) throws Exception;
	
	@Select("SELECT "
			+ " id id,"
			+ " phone_num phoneNum,"
			+ " work_name workName,"
			+ " password password,"
			+ " birthday birthday,"
			+ " worker_role workerRole,"
			+ " worker_img workerImg,"
			+ " worker_constellation workerConstellation,"
			+ " blood_type bloodType,"
			+ " worker_hobby workerHobby,"
			+ " isfirst_login isfirstLogin,"
			+ " update_time updateTime,"
			+ " crete_time creteTime"
			+ " FROM "
			+ " worker_info "
			+ " WHERE "
			+ " phone_num = #{phoneNum}"
			+ " AND password = #{password}"
			)
	public Map<String , Object> selectByPhoneNumAndPass(@Param("phoneNum") String phoneNum, @Param("password") String password) throws Exception;
}