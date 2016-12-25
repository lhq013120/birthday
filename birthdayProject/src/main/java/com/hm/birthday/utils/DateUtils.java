package com.hm.birthday.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	public final static String pattern_ymd = "yyyyMMdd";
	public final static String pattern_hms = "HHmmss";
	public final static String pattern_full_interval = "yyyy-MM-dd HH:mm:ss";
	public final static String pattern_ymd_interval = "yyyy-MM-dd";
	public final static String pattern_hms_interval = "HH:mm:ss";
	public final static String pattern_fill = "yyyyMMddHHmmss";
	public final static String pattern_m = "MM";
	public final static String pattern_y = "YYYY";
	
    /**
     * 格式化当前日期，以字符串形式输出
     * 		i=0 -> {yyyyMMdd}
     * 		i=1  ->{HHmmss}
     * 		i=2  ->{yyyy-MM-dd HH:mm:ss}
     * 		i=3  ->{yyyy-MM-dd}
     * 		i=4  ->{HH:mm:ss}
     * 		i=5  ->{yyyyMMddHHmmss}
     * 		i=6  ->{MM}
     * 		i=7  ->{YYYY}
     * 		default  ->{yyyyMMddHHmmss}
     * @param i
     * @param date 时间
     * @return
     */
    public static String dateFormat(int i, Date date) {
        Date d = (date == null ? new Date() : date);
        String pattern = "";
        switch (i) {
            case 0:
                pattern = pattern_ymd;
                break;
            case 1:
                pattern = pattern_hms;
                break;
            case 2:
                pattern = pattern_full_interval;
                break;
            case 3:
                pattern = pattern_ymd_interval;
                break;
            case 4:
                pattern = pattern_hms_interval;
                break;
            case 5:
                pattern = pattern_fill;
                break;
            case 6:
            	pattern = pattern_m;
            	break;
            case 7:
            	pattern = pattern_y;
            	break;
            default:
                pattern = pattern_fill;
                break;
        }

        DateFormat format = new SimpleDateFormat(pattern);
        return format.format(d);
    }
    
    /**
     * 
     * 将字符串转换成日期，默认返回系统时间
     * 
     * @param date
     * @param pattern
     * @return
     */
    public static Date StringtoDate(String date, String pattern) {
    	DateFormat formate = new SimpleDateFormat(pattern);
    	Date d = new Date();
    	try {
			d = formate.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return d;
    }
    
    /**
     * 返回系统当前时间
     * 
     * @return
     */
    public static Date now() {
    	return new Date();
    }
}
