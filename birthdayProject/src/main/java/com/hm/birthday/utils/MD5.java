package com.hm.birthday.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import sun.misc.BASE64Encoder;

/**
 * MD5服务类
 * 
 * @author hanyd
 *
 */
public class MD5 {
	
	private final static Logger logger = LoggerFactory.getLogger(MD5.class);
	
	/**
	 * MD5加密转换
	 * 
	 * @param target
	 * @return
	 */
	public static String MD5Encoder(String target) {
		String dis = "";
		
		if(StringUtils.isEmpty(target)) {
			return dis;
		}
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			BASE64Encoder base64 = new BASE64Encoder();
			dis = base64.encode(md5.digest(target.getBytes()));
		} catch (NoSuchAlgorithmException e) {
			logger.error("MD5 Encoder error ......", e);
		}
		return dis;
	}
	
	/**
	 * 比较是否相等
	 * 
	 * @param target
	 * @param src
	 * @return
	 */
	public static boolean checkEq(String target, String src){
		boolean b = false;
		if (MD5Encoder(target).equals(src)) {
			b = true;
		}
		return b;
	}
}
