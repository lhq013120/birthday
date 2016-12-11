package com.hm.birthday.admin.upload.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hm.birthday.utils.ImgUtils;
import com.hm.birthday.utils.JsonUtils;

@Controller
@RequestMapping("img")
public class UpdoadImg {
	
	private final static Logger logger = LoggerFactory.getLogger(UpdoadImg.class);
	private final static String prefix = "shrink_";
	private final static String base_path = "imgs/headpro/";
	
	@ResponseBody
	@RequestMapping("updoad")
	public String updoadimg(HttpServletRequest request, HttpServletResponse response)
			throws IllegalStateException, IOException {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		
		String ctxPath = request.getSession().getServletContext().getRealPath("/") +"/"+ base_path;
		
		// 创建文件夹
		File file = new File(ctxPath);
		if (!file.exists()) {
			file.mkdirs();
		}
		StringBuffer srcFile = new StringBuffer(base_path); // 原图片保存的位置
		StringBuffer shrinkFile = new StringBuffer(base_path); // 缩略图的位置
		
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			// 上传文件名
			// System.out.println("key: " + entity.getKey());
			MultipartFile mf = entity.getValue();
			final String fileName = new String(mf.getOriginalFilename().getBytes(),"UTF-8");
			
			final String compFileName = prefix+fileName; // 压缩文件的文件名
			final File uploadFile = new File(ctxPath + fileName);
			try {
				FileCopyUtils.copy(mf.getBytes(), uploadFile);
				ImgUtils.shrinkImgWithSize(ctxPath, ctxPath, fileName , compFileName, null, null);
				srcFile.append(fileName);
				shrinkFile.append(compFileName);
				logger.info("上传用户头像成功....{}",new Object[]{ctxPath + fileName});
			} catch (IOException e) {
				logger.error("上传用户头像失败....",e);
			}
		}
		Map<String,String> map = new HashMap<String,String>();
		map.put("srcFile", srcFile.toString());
		map.put("shrinkFile", shrinkFile.toString());
		return JsonUtils.toJsonString(map);
	}
}
