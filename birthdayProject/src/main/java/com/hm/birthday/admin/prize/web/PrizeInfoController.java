package com.hm.birthday.admin.prize.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.hm.birthday.admin.prize.servic.IPrizeInfoService;
import com.hm.birthday.core.controller.AbstractDisplayController;
import com.hm.birthday.entity.PrizeInfo;

@Controller
@RequestMapping("prize")
public class PrizeInfoController extends AbstractDisplayController {
	
	@Autowired
	private IPrizeInfoService prizeInfoService;
	
	@RequestMapping(value="doSerach")
	public ModelAndView doSerach(@RequestParam Map<String, Object> params ) throws Exception {
		Integer pageNum = params.get("pageNum") == null ? null : Integer.parseInt(params.get("pageNum").toString());
		Integer limit = params.get("numPerPage") == null ? null : Integer.parseInt(params.get("numPerPage").toString());
		
		PageList<PrizeInfo> list = prizeInfoService.queryWithPage(new PrizeInfo(), buildPageBounds(limit, pageNum));
		Map<String,Object> modelMap = new HashMap<String,Object>();
		modelMap.put("prizes",list);
		
		return setModelView("admin/prize/prizeList",modelMap);
	}
}
