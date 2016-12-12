package com.hm.birthday.admin.worker.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.hm.birthday.admin.dict.dao.BaseDicInfoMapper;
import com.hm.birthday.admin.worker.service.IWorkerService;
import com.hm.birthday.constant.Constants;
import com.hm.birthday.core.controller.AbstractDisplayController;
import com.hm.birthday.entity.BaseDicInfo;
import com.hm.birthday.entity.WorkerInfo;
import com.hm.birthday.enums.RetMsg;
import com.hm.birthday.utils.Constellation;
import com.hm.birthday.utils.DateUtils;
import com.hm.birthday.utils.MD5Utils;

@Controller
@RequestMapping("worker")
public class WorkerController extends AbstractDisplayController {
	
	@Autowired
	private IWorkerService workerService;
	@Autowired
	private BaseDicInfoMapper baseDicInfoMapper;
	/**
	 * 分页查询
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="doSerach")
	public ModelAndView doSerach(@RequestParam Map<String, Object> params ) throws Exception {
		
		Integer pageNum = params.get("pageNum") == null ? null : Integer.parseInt(params.get("pageNum").toString());
		Integer limit = params.get("numPerPage") == null ? null : Integer.parseInt(params.get("numPerPage").toString());
		String phoneNum = params.get("phoneNum") == null ? "" : params.get("phoneNum").toString();
		String workNm = params.get("workName") == null ? "" : params.get("workName").toString();
		WorkerInfo worker = new WorkerInfo();
		worker.setPhoneNum(phoneNum);
		worker.setWorkName(workNm);
		PageList<WorkerInfo> list = workerService.queryWithPage(worker, buildPageBounds(limit, pageNum));
		List<BaseDicInfo> bloodTypes = baseDicInfoMapper.selectByType("blood_type"); // 获取血型字典
		
		Map<String,Object> modelMap = new HashMap<String,Object>();
		modelMap.put("bloodTypes", bloodTypes);
		modelMap.put("pworker", worker);
		modelMap.put("workers",list);
		
		return setModelView("admin/worker/workerList",modelMap);
	}
	
	/**
	 * 新增页面显示信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="showAdd")
	public ModelAndView showAdd() throws Exception {
		
		Map<String,Object> modelMap = new HashMap<String,Object>();
		
		List<BaseDicInfo> bloodTypes = baseDicInfoMapper.selectByType("blood_type");
		modelMap.put("bloodTypes", bloodTypes);
		
		return setModelView("admin/worker/addWorker",modelMap);
	}
	
	/**
	 * 添加新用户
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("add")
	public ModelAndView add(@RequestParam Map<String, Object> params) throws Exception {
		final String phoneNum = (String) params.get("phoneNum");
		if(phoneNum.length() != 11) {
			Map<String,Object> modelMap = setResultMap(RetMsg.PHONENUM_ERROR);
			return setModelView(Constants.page_ajaxError,modelMap);
		}
		final String password = MD5Utils.MD5Encoder(phoneNum.substring(7));
		final String workName = (String) params.get("workName");
		final Date birthday = DateUtils.StringtoDate((String) params.get("birthday"), DateUtils.pattern_ymd_interval );
		final String workerRole = (String) params.get("workerRole");
		final String workerImg = (String) params.get("workerImg");
		final String shrinkImg = (String) params.get("shrinkImg");
		final String workerConstellation = Constellation.date2Constellation(birthday);
		final String bloodType = (String) params.get("bloodType");
		final String workerHobby = (String) params.get("workerHobby");
		
		Date sysDate = DateUtils.now();
		
		WorkerInfo workerInfo = new WorkerInfo(phoneNum,
				workName,
				password,
				birthday,
				workerRole,
				workerImg,
				shrinkImg,
				workerConstellation,
				bloodType,
				workerHobby,null, sysDate,sysDate);
		workerService.AddWorker(workerInfo);
		return setModelView("admin/worker/edit_ajaxSuccess");
	}
	
	/**
	 * 删除用户
	 * 
	 * @param id 用户id
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("del")
	public ModelAndView delete(@RequestParam String workid) throws Exception {
		if (StringUtils.isEmpty(workid)) {
			Map<String,Object> modelMap = setResultMap(RetMsg.ILLEGALITY_OPERATION);
			return setModelView(Constants.page_ajaxError,modelMap);
		}
		
		Integer id = Integer.parseInt(workid);
		
		workerService.deleteWorker(id);
		
		return setModelView(Constants.page_ajaxDone);
	}
}
