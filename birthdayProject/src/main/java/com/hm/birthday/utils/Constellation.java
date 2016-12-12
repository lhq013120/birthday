package com.hm.birthday.utils;

import java.util.Calendar;
import java.util.Date;

public class Constellation {
	public static final int[] constellationEdgeDay = { 20, 19, 21, 21, 21, 22, 23, 23, 23, 23, 22, 22 };
	public static final String[] constellationArr = { "水瓶座", "双鱼座", "白羊座",
			"金牛座", "双子座", "巨蟹座",
			"狮子座", "处女座", "天秤座",
			"天蝎座", "射手座", "魔羯座" };

	/**
	 * 根据日期获取星座
	 * 
	 * @param time
	 * @return
	 */
	public static String date2Constellation(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);

		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		if (day < constellationEdgeDay[month]) {
			month = month - 1;
		}
		if (month >= 0) {
			return constellationArr[month];
		}
		return constellationArr[11];
	}
}
