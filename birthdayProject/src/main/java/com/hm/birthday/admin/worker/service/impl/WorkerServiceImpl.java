package com.hm.birthday.admin.worker.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.hm.birthday.admin.dict.dao.BaseDicInfoMapper;
import com.hm.birthday.admin.worker.dao.WorkerMapper;
import com.hm.birthday.admin.worker.service.IWorkerService;
import com.hm.birthday.entity.BaseDicInfo;
import com.hm.birthday.entity.WorkerInfo;
import com.hm.birthday.enums.RetMsg;
import com.hm.birthday.utils.DateUtils;


@Service("workerService")
public class WorkerServiceImpl implements IWorkerService {
	
	private final Logger logger = LoggerFactory.getLogger(WorkerServiceImpl.class);
	
	@Autowired
	private WorkerMapper workerMapper;
	
	@Autowired
	private BaseDicInfoMapper baseDicInfoMapper;
	
	@Override
	public PageList<WorkerInfo> queryWithPage(WorkerInfo w,PageBounds pageBounds) throws Exception {
		
		try {
			return workerMapper.queryWithPage(w, pageBounds);
		} catch (Exception e) {
			logger.error("查询员工信息失败", e);
			throw e;
		}
	}

	@Override
	public Map<String,Object> login(String phoneNum,String password) throws Exception {
		Map<String, Object> map = null;
		try {
			map = workerMapper.selectByPhoneNumAndPass(phoneNum, password);
			
			if (!CollectionUtils.isEmpty(map)) {
				// 查询血型字典
				List<BaseDicInfo> bloodTypes = baseDicInfoMapper.selectByType("blood_type");
				final String btCode = (String) map.get("bloodType"); // 血型的字典码
				String btName = "A型";
				if(StringUtils.isEmpty(btCode)) {
					for(BaseDicInfo bdi : bloodTypes) {
						if (btCode.equals(bdi.getCode())) {
							btName = bdi.getName();
							break;
						}
					}
				}
				map.put("bloodType", btName); // 设置血型
				// 查询用户生日的月份
				final String crrMonthBir = DateUtils.dateFormat(6, map.containsKey("birthday")? (Date) map.get("birthday"): null);
				final String nowMonth = DateUtils.dateFormat(6, new Date());
				boolean isLucky = false; // 是否已抽奖
				boolean isBirthday = false; // 是否本月生日
				if (nowMonth.equals(crrMonthBir)) {
					isBirthday = true;
				}
				map.put("birthday", DateUtils.dateFormat(3, (Date)map.get("birthday")));
				map.put("isLucky", isLucky); // 是否已抽奖
				map.put("isBirthday", isBirthday);// 是否生日
			}
		} catch (Exception e) {
			logger.error("用户登录查询失败", e);
			throw e;
		}
		
		return map;
	}

	@Override
	public int setFirstLogin(Integer id) throws Exception  {
		WorkerInfo workerInfo = new WorkerInfo();
		workerInfo.setId(id);
		workerInfo.setIsfirstLogin("02");
		workerInfo.setUpdateTime(new Date());
		int update = 0;
		try {
			update = workerMapper.updateByPrimaryKeySelective(workerInfo);
		} catch (Exception e) {
			logger.error("设置用户首次登陆的标志失败", e);
			throw e;
		}
		return update;
	}

	@Override
	public RetMsg AddWorker(WorkerInfo workerInfo) throws Exception {
		try {
			WorkerInfo w = workerMapper.selectByPhone(workerInfo.getPhoneNum());
			if (w != null) {
				return RetMsg.USER_EXIST;
			}
			int count = workerMapper.insertSelective(workerInfo);
			if(count == 1 ) {
				return RetMsg.SUCCESS;
			}
		} catch (Exception e) {
			logger.error("用户信息插入失败", e);
			throw e;
		}
		return RetMsg.USER_ADD_FAIL;
	}

	@Override
	public int deleteWorker(Integer id) throws Exception  {
		try {
			return  workerMapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("删除用户信息失败", e);
			throw e;
		}
	}

	@Override
	public WorkerInfo getWorker(Integer id) throws Exception {
		WorkerInfo worker = null;
		try {
			worker = workerMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("按id查询用户信息失败", e);
			throw e;
		}
		return worker;
	}

	@Override
	public WorkerInfo getWorkerByPhone(String phoneNum) throws Exception {
		WorkerInfo workerInfo = null;
		try {
			workerInfo = workerMapper.selectByPhone(phoneNum);
		} catch (Exception e) {
			logger.error("按手机号查询用户信息失败", e);
			throw e;
		}
		return workerInfo;
	}

	@Override
	public int updateWorker(WorkerInfo workerInfo) throws Exception  {
		int count = 0;
		try {
			count = workerMapper.updateByPrimaryKeySelective(workerInfo);
		} catch (Exception e) {
			logger.error("更新用户信息失败", e);
			throw e;
		}
		return count;
	}
	
}
