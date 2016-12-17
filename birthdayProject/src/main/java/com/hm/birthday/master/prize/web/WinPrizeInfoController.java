package com.hm.birthday.master.prize.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.hm.birthday.core.controller.AbstractDisplayController;
import com.hm.birthday.entity.WinPrizeInfo;
import com.hm.birthday.master.prize.service.IWinPrizeInfoService;

@RequestMapping("winPrize")
@Controller
public class WinPrizeInfoController extends AbstractDisplayController {
	
	@Autowired
	private IWinPrizeInfoService winPrizeInfoService;
	
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
	

}
