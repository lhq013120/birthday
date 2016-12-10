package com.hm.birthday.admin.dict.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.birthday.admin.dict.dao.BaseDicInfoMapper;
import com.hm.birthday.admin.dict.service.IBaseDicInfoService;
import com.hm.birthday.entity.BaseDicInfo;

@Service("baseDicInfoService")
public class BaseDicInfoServiceImpl implements IBaseDicInfoService {

	private final Logger logger = LoggerFactory.getLogger(BaseDicInfoServiceImpl.class);
	
	@Autowired
	private BaseDicInfoMapper baseDicInfoMapper;
	
	@Override
	public List<BaseDicInfo> selectByType(String type) throws Exception {
		try {
			return baseDicInfoMapper.selectByType(type);
		} catch (Exception e) {
			logger.error("查询字段表信息系统错误 type ["+ type +"]", e);
			throw e;
		}
	}

}
