package com.hm.birthday.master.prize.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.hm.birthday.core.controller.AbstractDisplayController;
import com.hm.birthday.entity.PrizeInfo;
import com.hm.birthday.entity.WinPrizeInfo;
import com.hm.birthday.enums.RetMsg;
import com.hm.birthday.master.prize.service.IWinPrizeInfoService;
import com.hm.birthday.master.prize.vo.PrizeVo;
import com.hm.birthday.utils.JsonUtils;

@RequestMapping("winPrize")
@Controller
public class WinPrizeInfoController extends AbstractDisplayController {
	
	@Autowired
	private IWinPrizeInfoService winPrizeInfoService;
	
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
	

}
