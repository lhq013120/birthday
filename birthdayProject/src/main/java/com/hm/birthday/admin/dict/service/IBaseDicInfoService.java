package com.hm.birthday.admin.dict.service;

import java.util.List;

import com.hm.birthday.entity.BaseDicInfo;

public interface IBaseDicInfoService {
	
	List<BaseDicInfo> selectByType(String type) throws Exception;
	
}
