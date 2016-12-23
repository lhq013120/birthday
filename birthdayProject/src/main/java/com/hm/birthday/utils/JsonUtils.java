package com.hm.birthday.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class JsonUtils {
	/**
	 *  将对象转换成JSON字符串
	 *  
	 * @param o
	 * @return
	 */
	public static String toJsonString(Object o){
		return JSON.toJSONString(o,new SerializerFeature[]{
				SerializerFeature.WriteNullStringAsEmpty, // null 字符串 按"" 输出
				SerializerFeature.WriteNullBooleanAsFalse,// boolean null 时按false 输出
				SerializerFeature.WriteNullListAsEmpty}); // list 为null 时按 [] 输出
	}
}
