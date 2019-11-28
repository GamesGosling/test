package com.xtkj.utils;

import java.util.Calendar;

/**
 *- 将时间转成字符串
 * @author Administrator
 */
public class DateToString {

	/**
	 * -获取当前时间的年月
	 * @return
	 */
	public static String getYearAndMonth() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		//格式为:1990-10
		return year + "_"+month;
	}
}
