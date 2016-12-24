package com.hm.birthday.master.praise.web;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.birthday.core.controller.AbstractDisplayController;
import com.hm.birthday.entity.WinPraise;
import com.hm.birthday.enums.PraiseEnum;
import com.hm.birthday.enums.RetMsg;
import com.hm.birthday.master.praise.service.IWinPraiseService;
import com.hm.birthday.master.praise.vo.PraiseVo;
import com.hm.birthday.utils.JsonUtils;

/**
 * 点赞控制类
 * 
 * @author hanyd
 *
 */
@Controller
@RequestMapping("praise")
public class WinPraiseController extends AbstractDisplayController{
	
	private final static Logger logger = LoggerFactory.getLogger(WinPraiseController.class);
	@Autowired
	private IWinPraiseService winPraiseService;
	
	
	/**
	 * 获取点赞总数和用户点赞
	 * 
	 * @param userName
	 * @return
	 */
	@ResponseBody
	@RequestMapping("count.do")
	public String getPraise(@RequestParam String userName) {
		logger.info("获取用户点赞 userName:{}",userName);
		Map<String,Object> result = new HashMap<String, Object>();
		if (StringUtils.isEmpty(userName)) {
			result = setResultMap(RetMsg.USER_ANME_NULL);
			return JsonUtils.toJsonString(result);
		}
		
		boolean isActivePra = false; // 用户是否点过赞
		boolean isPrizePra = false; // 用户是否点过赞
		PraiseVo praCount = winPraiseService.getPraise(); // 用户点赞总数
		WinPraise wp = winPraiseService.get(userName,PraiseEnum.TYPE_ACTIVE.value());
		if (wp != null) {
			isActivePra = true;
		}
		wp = winPraiseService.get(userName,PraiseEnum.TYPE_PRIZE.value());
		if (wp != null) {
			isPrizePra = true;
		}
		result.put("isActivePra", isActivePra);
		result.put("isPrizePra", isPrizePra);
		result.put("praCount", praCount);
		result.put("result", RetMsg.SUCCESS.name());
		result.put("info", RetMsg.SUCCESS.value());
		return JsonUtils.toJsonString(result);
	}
	
	/**
	 * 用户过奖方式点赞接口
	 * 
	 * @param userName
	 * @return
	 */
	@ResponseBody
	@RequestMapping("active/add.do")
	public String addPraise(@RequestParam String userName,@RequestParam String isEndorse) {
		Map<String,Object> result = new HashMap<String, Object>();
		if (StringUtils.isEmpty(userName)) {
			result = setResultMap(RetMsg.USER_ANME_NULL);
			return JsonUtils.toJsonString(result);
		}
		PraiseVo praCount  =winPraiseService.add(userName,PraiseEnum.TYPE_ACTIVE.value(),isEndorse);
		result.put("isActivePra", true); // 已经点赞
		result.put("praCount", praCount); // 点赞总数
		result.put("result", RetMsg.SUCCESS.name());
		result.put("info", RetMsg.SUCCESS.value());
		return JsonUtils.toJsonString(result);
	}
	
	@ResponseBody
	@RequestMapping("prize/add.do")
	public String addPrizePraise(@RequestParam String userName,@RequestParam String isEndorse) {
		Map<String,Object> result = new HashMap<String, Object>();
		if (StringUtils.isEmpty(userName)) {
			result = setResultMap(RetMsg.USER_ANME_NULL);
			return JsonUtils.toJsonString(result);
		}
		PraiseVo praCount  =winPraiseService.add(userName,PraiseEnum.TYPE_PRIZE.value(),isEndorse);
		result.put("isPrizePra", true); // 已经点赞
		result.put("praCount", praCount); // 点赞总数
		result.put("result", RetMsg.SUCCESS.name());
		result.put("info", RetMsg.SUCCESS.value());
		return JsonUtils.toJsonString(result);
	}

}
