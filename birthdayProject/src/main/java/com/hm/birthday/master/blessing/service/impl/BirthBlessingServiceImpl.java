package com.hm.birthday.master.blessing.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hm.birthday.entity.BirthBlessing;
import com.hm.birthday.master.blessing.dao.BirthBlessingMapper;
import com.hm.birthday.master.blessing.service.IBirthBlessingService;

/**
 * 生日祝福服务类
 * 
 * @author hanyd
 *
 */
@Service("birthBlessingService")
public class BirthBlessingServiceImpl implements IBirthBlessingService {

	private final static Logger logger = LoggerFactory.getLogger(BirthBlessingServiceImpl.class);
	
	private BirthBlessingMapper birthBlessingMapper;
	
	
	@Override
	public BirthBlessing addBlessing(BirthBlessing blessing) {
		int count = 0;
		try {
			count = birthBlessingMapper.insert(blessing);
			if ( count == 0) {
				throw new Exception();
			}
		} catch (Exception e) {
			logger.error("");
		}
		
		return null;
	}

	@Override
	public List<BirthBlessing> newBlessing() {
		// TODO
		return null;
	}

	@Override
	public List<BirthBlessing> allBlessing(String birthPerson) {
		// TODO
		return null;
	}
	
}
