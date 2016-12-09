package com.hm.birthday.admin.worker.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.hm.birthday.admin.worker.service.IWorkerService;
import com.hm.birthday.core.controller.AbstractDisplayController;
import com.hm.birthday.entity.WorkerInfo;

@Controller
@RequestMapping("worker")
public class WorkerController extends AbstractDisplayController {
	
	@Autowired
	private IWorkerService workerService;
	
	@RequestMapping(value="doSerach")
	public ModelAndView doSerach(@RequestParam Map<String, Object> params ) throws Exception {
		
		Integer pageNum = params.get("pageNum") == null ? null : Integer.parseInt(params.get("pageNum").toString());
		Integer limit = params.get("numPerPage") == null ? null : Integer.parseInt(params.get("numPerPage").toString());
		String phoneNum = params.get("phoneNum") == null ? "" : params.get("phoneNum").toString();
		String workNm = params.get("workNm") == null ? "" : params.get("workNm").toString();
		WorkerInfo worker = new WorkerInfo();
		worker.setPhoneNum(phoneNum);
		worker.setWorkName(workNm);
		PageList<WorkerInfo> list = workerService.queryWithPage(worker, buildPageBounds(limit, pageNum));
		
		Map<String,Object> modelMap = new HashMap<String,Object>();
		modelMap.put("worker", worker);
		modelMap.put("workers",list);
		
		return setModelView("admin/worker/workerList",modelMap);
	}
}
