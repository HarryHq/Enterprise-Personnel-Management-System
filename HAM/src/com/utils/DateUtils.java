package com.utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtils {
	
	/**
	 * 把java.util.Date--》java.sql.Date
	 * @param date
	 * @return
	 */
	public static Date toSqlDate(java.util.Date date) {
		if (date==null) {
			return null;
		}
		java.sql.Date sqlDate=new Date(date.getTime());		
		return sqlDate;		
	}
	
	/**
	 *  string类型日期"2013-01-14"转换为java.util.Date类型日期
	 * @param string 传入一个"2013-01-14"字符串类型日期
	 * @return 返回一个java.util.Date类型日期
	 */
	public static java.util.Date toUtilDate(String string) {
		
		if (string.equals("") || string.trim().equals("")) {
			return null;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		java.util.Date date = null; //初始化date 
		try {
			date=sdf.parse(string);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;		
	}
	
	/**
	 * 设置一个参考时间，比如上下班时间
	 * @param hour 需要设定的小时
	 * @param minute  需要设定的分钟
	 * @param second  需要设定的秒
	 * @return 返回一个java.util.Date 的时间
	 */
	public static java.util.Date setClork(int hour,int minute,int second) {
		Calendar calendar = Calendar.getInstance();
		int year=calendar.get(Calendar.YEAR);
		int month=calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.set(year, month,day, hour, minute, second);
		java.util.Date date = calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.format(date);
		return date;
		
	}
	
	/**
	 * 判断是否是今天
	 * @param date
	 * @return
	 */
	 public static boolean isToday(java.util.Date date){
	     SimpleDateFormat fmt=new SimpleDateFormat("yyyy-MM-dd");
	     if(fmt.format(date).toString().equals(fmt.format(date).toString())){//格式化为相同格式
	          return true;
	      }else {
	        return false;
	      }
	  }

}
