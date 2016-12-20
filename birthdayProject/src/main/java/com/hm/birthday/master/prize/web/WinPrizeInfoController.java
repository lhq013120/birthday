package com.hm.birthday.master.prize.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.hm.birthday.admin.worker.service.IWorkerService;
import com.hm.birthday.constant.Constants;
import com.hm.birthday.core.controller.AbstractDisplayController;
import com.hm.birthday.entity.WinPrizeInfo;
import com.hm.birthday.entity.WorkerInfo;
import com.hm.birthday.enums.RetMsg;
import com.hm.birthday.master.prize.service.IWinPrizeInfoService;
import com.hm.birthday.master.prize.vo.PrizeVo;
import com.hm.birthday.master.prize.vo.WinPrizeVo;
import com.hm.birthday.utils.JsonUtils;

@Controller
@RequestMapping("winPrize")
public class WinPrizeInfoController extends AbstractDisplayController {
	
	@Autowired
	private IWinPrizeInfoService winPrizeInfoService;
	
	@Autowired
	private IWorkerService workerService;
	
	/**
	 * 查询用户获奖信息（分页查询）
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="doSerach.do")
	public ModelAndView doSerach(@RequestParam Map<String, Object> params) throws Exception {
		Integer pageNum = params.get("pageNum") == null ? null : Integer.parseInt(params.get("pageNum").toString());
		Integer limit = params.get("numPerPage") == null ? null : Integer.parseInt(params.get("numPerPage").toString());
		
		PageList<WinPrizeInfo> list = winPrizeInfoService.queryWithPage(params, buildPageBounds(limit, pageNum));
		Map<String,Object> modelMap = new HashMap<String,Object>();
		modelMap.put("phoneNum",params.get("phoneNum"));
		modelMap.put("workName",params.get("workName"));
		modelMap.put("tcDateStart",params.get("tcDateStart"));
		modelMap.put("tcDateEnd",params.get("tcDateEnd"));
		modelMap.put("winprizes",list);
		
		return setModelView("admin/prize/winprizeList",modelMap);
	}
	
	/**
	 * 当月生日的所以用户获奖信息
	 * 
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("month.do")
	public String currentMonthWinPrizeInfo() {
		try {
			List<WinPrizeVo> list = winPrizeInfoService.currentMonthWinPrizeInfo();
			return JsonUtils.toJsonString(setResultMap("winPrizes",list));
		} catch (Exception e) {
			return JsonUtils.toJsonString(setResultMap(RetMsg.SYSTEM_ERROR));
		}
	}
	
	/**
	 * 用户抽奖
	 * 
	 * @param phoneNum 手机号
	 * @param name 姓名
	 * @return
	 */
	@ResponseBody
	@RequestMapping("lucky.do")
	public String luckyDraw(@RequestParam String phoneNum, @RequestParam String name) { 
		Map<String,Object> result = new HashMap<String, Object>();
		
		try {
			// 判断用户是否抽过奖
			if(winPrizeInfoService.getByPhoneWithYear(phoneNum)!=null) {
				return JsonUtils.toJsonString(setResultMap(RetMsg.ALREADY_WIN_PRIZE));
			}
			
			WorkerInfo w = workerService.getWorkerByPhone(phoneNum);
			if (w == null) {
				return JsonUtils.toJsonString(setResultMap(RetMsg.USER_NOT_EXIST));
			}
			
			PrizeVo p = winPrizeInfoService.luckyDraw(phoneNum, name);
			if (p == null) {
				result = setResultMap(RetMsg.PRIZE_NULL);
			} else {
				result = setResultMap("prizeinfo",p);
			}
			
		} catch (Exception e) {
			result = setResultMap(RetMsg.SYSTEM_ERROR);
		}
		return JsonUtils.toJsonString(result);
	}
	
	/**
	 * 获取所有的奖品信息
	 * 
	 * @return 奖品信息
	 */
	@ResponseBody
	@RequestMapping("prizes.do")
	public String allPrize() {
		Map<String,Object> result = new HashMap<String, Object>();
		try {
			List<PrizeVo> list = winPrizeInfoService.allPrize();
			result = setResultMap("prizes", list);
		} catch (Exception e) {
			result = setResultMap(RetMsg.SYSTEM_ERROR);
		}
		return JsonUtils.toJsonString(result);
	}
	
	/**
	 * 
	 * 删除获奖信息
	 * 
	 * @param workid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("del.do")
	public ModelAndView delete(@RequestParam String id) throws Exception {
		if (StringUtils.isEmpty(id)) {
			Map<String,Object> modelMap = setResultMap(RetMsg.ILLEGALITY_OPERATION);
			return setModelView(Constants.page_ajaxError,modelMap);
		}
		
		Integer winid = Integer.parseInt(id);
		
		winPrizeInfoService.deleteWinPrize(winid);
		
		return setModelView(Constants.page_ajaxDone);
	}

}
