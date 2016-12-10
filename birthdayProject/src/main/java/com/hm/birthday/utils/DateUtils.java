package com.hm.birthday.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    /**
     * 格式化当前日期，以字符串形式输出
     * 		i=0 -> {yyyyMMdd}
     * 		i=1  ->{HHmmss}
     * 		i=2  ->{yyyy-MM-dd HH:mm:ss}
     * 		i=3  ->{yyyy-MM-dd}
     * 		i=4  ->{HH:mm:ss}
     * 		i=5  ->{yyyyMMddHHmmss}
     * 		i=5  ->{yyyyMMddHHmmss}
     * 		i=6  ->{MM}
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
                pattern = "yyyyMMdd";
                break;
            case 1:
                pattern = "HHmmss";
                break;
            case 2:
                pattern = "yyyy-MM-dd HH:mm:ss";
                break;
            case 3:
                pattern = "yyyy-MM-dd";
                break;
            case 4:
                pattern = "HH:mm:ss";
                break;
            case 5:
                pattern = "yyyyMMddHHmmss";
                break;
            case 6:
            	pattern = "MM";
            	break;
            default:
                pattern = "yyyyMMddHHmmss";
                break;
        }

        DateFormat format = new SimpleDateFormat(pattern);
        return format.format(d);
    }
}
