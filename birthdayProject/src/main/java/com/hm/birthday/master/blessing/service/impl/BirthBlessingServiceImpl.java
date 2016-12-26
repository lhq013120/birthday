package com.hm.birthday.master.blessing.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.hm.birthday.admin.dict.dao.BaseDicInfoMapper;
import com.hm.birthday.admin.worker.service.IWorkerService;
import com.hm.birthday.entity.BaseDicInfo;
import com.hm.birthday.entity.BirthBlessing;
import com.hm.birthday.entity.WorkerInfo;
import com.hm.birthday.master.blessing.dao.BirthBlessingMapper;
import com.hm.birthday.master.blessing.service.IBirthBlessingService;
import com.hm.birthday.master.blessing.vo.BlessingLimitVo;
import com.hm.birthday.master.blessing.vo.BlessingVo;
import com.hm.birthday.utils.DateUtils;

/**
 * 生日祝福服务类
 * 
 * @author hanyd
 *
 */
@Service("birthBlessingService")
public class BirthBlessingServiceImpl implements IBirthBlessingService {

	private final static Logger logger = LoggerFactory.getLogger(BirthBlessingServiceImpl.class);
	
	@Autowired
	private BirthBlessingMapper birthBlessingMapper;
	
	@Autowired
	private IWorkerService workerService;
	
	@Autowired
	private BaseDicInfoMapper baseDicInfoMapper;
	
	
	@Override
	public int addBlessing(BirthBlessing blessing) throws Exception {
		int count = 0;
		try {
			count = birthBlessingMapper.insert(blessing);
			if ( count == 0) {
				throw new Exception();
			}
		} catch (Exception e) {
			logger.error("添加留言祝福系统异常.........",e);
			throw e;
		}
		return count;
	}

	@Override
	public List<BlessingLimitVo> newBlessing() throws Exception {
		
		List<BlessingLimitVo> list = new ArrayList<BlessingLimitVo>();
		
		List<WorkerInfo> workers = workerService.allBirthWorker(); // 获取本月生日用户
		if (!CollectionUtils.isEmpty(workers)) {
			// 查询血型字典
			List<BaseDicInfo> bloodTypes = baseDicInfoMapper.selectByType("blood_type");
			for(WorkerInfo worker : workers) {
				BlessingLimitVo blv = new BlessingLimitVo(); // 生日用户以及留言 
				blv.setPhoneNum(worker.getPhoneNum());
				blv.setWorkName(worker.getWorkName());
				blv.setWorkerImg(worker.getWorkerImg());
				blv.setShrinkImg(worker.getShrinkImg());
				blv.setWorkerConstellation(worker.getWorkerConstellation());
				blv.setWorkerHobby(worker.getWorkerHobby());
				final String btCode = (String) worker.getBloodType(); // 血型的字典码
				String btName = "A型";
				if(!StringUtils.isEmpty(btCode)) {
					for(BaseDicInfo bdi : bloodTypes) {
						if (btCode.equals(bdi.getCode())) {
							btName = bdi.getName();
							break;
						}
					}
				}
				blv.setBloodType(btName); // 血型
				blv.setBirthday(DateUtils.dateFormat(8,worker.getBirthday())); // 生日
				
				// 获取本月生日用户的留言前两条
				List<BirthBlessing> blessings;
				try {
					blessings = birthBlessingMapper.selectBirthLimit2(worker.getPhoneNum());
					for(BirthBlessing blessing : blessings) {
						BlessingVo bVo = new BlessingVo(blessing.getId(),
								blessing.getBirthPerson(),
								blessing.getBirthPersonPnum(),
								blessing.getBlePerson(),
								blessing.getBlePersonPnum(),
								blessing.getBleContent(),
								DateUtils.dateFormat(2, blessing.getCreateTime()));
						blv.getLimit2Blessing().add(bVo);
					}
				} catch (Exception e) {
					logger.error("获取生日用户评价的前两条评价异常",e);
					throw e;
				}
				list.add(blv);
			}
		}
		
		
		return list;
	}

	@Override
	public List<BlessingVo> allBlessing(String birthPersonPnum) throws Exception {
		List<BlessingVo> voList = new ArrayList<BlessingVo>();
		try {
			List<BirthBlessing> list = birthBlessingMapper.selectAllByMonth(birthPersonPnum);
			for(BirthBlessing blessing : list) {
				BlessingVo bVo = new BlessingVo(blessing.getId(),
						blessing.getBirthPerson(),
						blessing.getBirthPersonPnum(),
						blessing.getBlePerson(),
						blessing.getBlePersonPnum(),
						blessing.getBleContent(),
						DateUtils.dateFormat(2, blessing.getCreateTime()));
				voList.add(bVo);
			}
		} catch (Exception e) {
			logger.error("获取寿星当年的所以留言祝福系统异常", e);
			throw e;
		}
		
		return voList;
	}
	
}
