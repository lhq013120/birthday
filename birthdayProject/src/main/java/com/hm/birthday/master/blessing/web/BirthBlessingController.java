package com.hm.birthday.master.blessing.web;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.birthday.core.controller.AbstractDisplayController;
import com.hm.birthday.entity.BirthBlessing;
import com.hm.birthday.enums.RetMsg;
import com.hm.birthday.master.blessing.service.IBirthBlessingService;
import com.hm.birthday.utils.DateUtils;
import com.hm.birthday.utils.JsonUtils;

/**
 * 
 * 生日祝福控制类
 * 
 * @author hanyd
 *
 */
@Controller
@RequestMapping("blessing")
public class BirthBlessingController extends AbstractDisplayController{
	
	private final static Logger logger = LoggerFactory.getLogger(BirthBlessingController.class);
	@Autowired
	private IBirthBlessingService birthBlessingService;
	
	/**
	 * 给生日者留言祝福的接口
	 * 
	 * @param param
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping("add.do")
	public String addBlessing(@RequestParam Map<String, Object> param) throws UnsupportedEncodingException{
		logger.info("添加评论信息请求参数：{}",param);
		
		BirthBlessing blessing = new BirthBlessing();
		blessing.setBirthPerson((String)param.get("birthPerson"));
		blessing.setBirthPersonPnum((String)param.get("birthPersonPnum"));
		blessing.setBlePerson((String)param.get("blePerson"));
		blessing.setBlePersonPnum((String)param.get("blePersonPnum"));
		blessing.setBleContent((String)param.get("bleContent"));
		Date now = DateUtils.now();
		blessing.setUpdateTime(now);
		blessing.setCreateTime(now);
		try {
			birthBlessingService.addBlessing(blessing);
		} catch(Exception e) {
			return JsonUtils.toJsonString(setResultMap(RetMsg.SYSTEM_ERROR));
		}
		return  JsonUtils.toJsonString(setResultMap(RetMsg.SUCCESS));
	}
	
}
