package com.xtkj.utils;

import java.util.List;

import com.alibaba.fastjson.JSON;

public class JSONStringUtils {

	/**
	 * -将JSON字符串转成集合
	 * @param json
	 * @param cls
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List jsonToJava(String json, Class cls) {
		return JSON.parseArray(json, cls);
	}

	/**
	 * -将对象转成JSON字符串
	 * @param obj
	 * @return
	 */
	public static String javaToJson(Object obj) {
		return JSON.toJSONString(obj);
	}
}
