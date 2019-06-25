package com.neuedu.web02.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
	
	public static String getCurrentTime() {
		Date date = new Date();   
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(date);
		System.out.println("TimeUtil_getCurrentTime:"+time);
		return time;
	}
	
	public static String dateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(date);
		return time;
	}
	
}
