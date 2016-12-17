package com.hm.birthday.master.prize.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.hm.birthday.admin.prize.dao.PrizeInfoMapper;
import com.hm.birthday.entity.PrizeInfo;
import com.hm.birthday.entity.WinPrizeInfo;
import com.hm.birthday.master.prize.dao.WinPrizeInfoMapper;
import com.hm.birthday.master.prize.service.IWinPrizeInfoService;
import com.hm.birthday.master.prize.vo.PrizeVo;
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
	public List<WinPrizeInfo> queryWithPage(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public WinPrizeInfo luckyDraw(String phoneNum) throws Exception {
		return null;
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
}
