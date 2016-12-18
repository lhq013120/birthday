package com.hm.birthday.master.prize.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.hm.birthday.admin.prize.dao.PrizeInfoMapper;
import com.hm.birthday.entity.PrizeInfo;
import com.hm.birthday.entity.WinPrizeInfo;
import com.hm.birthday.master.prize.dao.WinPrizeInfoMapper;
import com.hm.birthday.master.prize.service.IWinPrizeInfoService;
import com.hm.birthday.master.prize.vo.PrizeVo;
import com.hm.birthday.master.prize.vo.WinPrizeVo;
import com.hm.birthday.utils.DateUtils;

@Service("winPrizeInfoService")
public class WinPrizeInfoServiceImpl implements IWinPrizeInfoService {

	private final Logger logger = LoggerFactory.getLogger(WinPrizeInfoServiceImpl.class);
	
	@Autowired
	private WinPrizeInfoMapper winPrizeInfoMapper;
	@Autowired
	private PrizeInfoMapper prizeInfoMapper;
	
	@Override
	public PageList<WinPrizeInfo> queryWithPage(Map<String,Object> param, PageBounds pageBounds) throws Exception {
		
		String phoneNum = param.get("phoneNum") == null ? null : param.get("phoneNum").toString();
		String workName = param.get("workName") == null ? null : param.get("workName").toString();
		Date tcDateStart = param.get("tcDateStart") == null || "".equals(param.get("tcDateStart")) ? null : DateUtils.StringtoDate(param.get("tcDateStart").toString(), DateUtils.pattern_ymd_interval);
		Date tcDateEnd = param.get("tcDateEnd") == null || "".equals(param.get("tcDateEnd"))? null : DateUtils.StringtoDate(param.get("tcDateEnd").toString(), DateUtils.pattern_ymd_interval);
		
		Map<String, Object> sqlParam = new HashMap<String, Object>();
		sqlParam.put("phoneNum", phoneNum);
		sqlParam.put("workName", workName);
		sqlParam.put("tcDateStart", tcDateStart);
		sqlParam.put("tcDateEnd", tcDateEnd);
		
		try {
			return winPrizeInfoMapper.queryWithPage(sqlParam, pageBounds);
		} catch (Exception e) {
			logger.error("查询员工获奖信息失败", e);
			throw e;
		}
	}

	@Override
	public List<WinPrizeVo> currentMonthWinPrizeInfo() throws Exception {
		
		List<WinPrizeVo> list = new ArrayList<WinPrizeVo>();
		List<WinPrizeInfo> winPrizes;
		try {
			winPrizes = winPrizeInfoMapper.selectCurrentMonthLucky();
			// 获取本月获奖用户信息
			for(WinPrizeInfo winPrize: winPrizes) {
				WinPrizeVo wpVo = new WinPrizeVo(winPrize.getId(),
						winPrize.getPhoneNum(),
						winPrize.getWorkName(),
						winPrize.getPrizeNo(),
						winPrize.getPrizeGrade(),
						winPrize.getPrizeName(),
						winPrize.getWorkAddress(),
						DateUtils.dateFormat(2, winPrize.getUpdateTime()),
						DateUtils.dateFormat(2, winPrize.getCreateTime()));
				list.add(wpVo);
			}
		} catch (Exception e) {
			logger.error("查询当月生日用户获奖信息系统异常",e);
			throw e;
		} 
		return list;
	}

	@Override
	public PrizeVo luckyDraw(String phoneNum,String workerName) throws Exception {
		List<PrizeVo> list = allPrize();
		if (!CollectionUtils.isEmpty(list)) {
			Random rand = new Random();
			int randNum = rand.nextInt(list.size());
			PrizeVo prizeVo = list.get(randNum);
			logger.info("用户{},抽到奖品 : {}",new Object[]{phoneNum, prizeVo});
			if (prizeVo != null) {
				Date now = DateUtils.now();
				WinPrizeInfo wi = new WinPrizeInfo(null,
						phoneNum,
						workerName,
						prizeVo.getPrizeNo(),
						prizeVo.getPrizeGrade(),
						prizeVo.getPrizeName(),
						null,
						now,
						now);
				winPrizeInfoMapper.insert(wi);
			}
			return prizeVo;
		}else {
			logger.info("当前平台奖品信息为空....");
			return null;
		}
	}

	@Override
	public List<PrizeVo> allPrize() throws Exception {
		List<PrizeVo> voList = new ArrayList<PrizeVo>();
		try {
			List<PrizeInfo> list = prizeInfoMapper.queryWithPage(null);
			for(PrizeInfo pi : list) {
				PrizeVo pv = new PrizeVo();
				BeanUtils.copyProperties(pi, pv);
				voList.add(pv);
			}
		} catch (Exception e) {
			logger.error("获取奖品信息系统异常", e);
			throw e;
		}
		return voList;
	}

	@Override
	public WinPrizeInfo getByPhoneWithYear(String phoneNum) throws Exception {
		WinPrizeInfo winPrizeInfo = null;
		try {
			winPrizeInfo = winPrizeInfoMapper.selectByPhoneWithYear(phoneNum);
		} catch (Exception e) {
			logger.error("获取用户中奖记录查询系统异常...", e);
			throw e;
		}
		return winPrizeInfo;
	}
}
