package com.hm.birthday.utils;

import com.alibaba.fastjson.JSON;

public class JsonUtils {
	/**
	 *  将对象转换成JSON字符串
	 *  
	 * @param o
	 * @return
	 */
	public static String toJsonString(Object o){
		return JSON.toJSONString(o);
	}
	
}
