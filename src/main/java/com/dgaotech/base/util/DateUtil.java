/**
 * <p>datetime： 2009 2009-12-29 下午02:41:09 <p/>
 * <p>Title:ReportMsgVO.java</p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2008</p>
 * <p>Company: 北京海特网联信息技术有限公司</p>
 *
 * @author JasonFeng
 * @version 1.0
 */
package com.dgaotech.base.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author JasonFeng
 *
 */
public class DateUtil {

	// Date Format
	public static final String DATE_FORMAT_DEFAULT = "yyyy-MM-dd";
	public static final String DATE_FORMAT_YYYYMM = "yyyy-MM";
	public static final String DATE_FORMAT_SOLIDUS = "yyyy/MM/dd";
    public static final String DATE_FORMAT_DOT = "yyyy.MM.dd";
    public static final String DATE_FORMAT_TIME = "HH:mm:ss";
    public static final String DATE_FORMAT_DEFAULT_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_FULL_AP_LINE= "yyyy-MM-dd a KK:mm:ss";
    public static final String DATE_FORMAT_FULL_LINE = "yyyy-MM-dd hh:mm:ss.SSS";
    public static final String DATE_FORMAT_FULL_NO_SEPARATOR = "yyyyMMddhhmmssSSS";
    
	/**
	 * 
	 * @datetime ：Sep 25, 2008 9:39:15 AM
	 * @功能 ：Convert Date-String to Date Object, default date format is "yyyy-MM-dd"
	 * @param dateString
	 * @return
	 */
	public static Date parse(String dateString) {
		return parse(dateString, DATE_FORMAT_DEFAULT);
	}
	
	/**
	 * 
	 * @datetime ：Sep 25, 2008 9:41:13 AM
	 * @功能 ：Convert Date-String to Date Object
	 * @param dateString
	 * @param dateFormat
	 * @return
	 */
	public static Date parse(String dateString, String dateFormat) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);   
	    try {
	    	date = sdf.parse(dateString);
		} catch (ParseException e) {
			return null;
		} catch (Exception e) {
			return null;
		}
		return date;
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends java.util.Date> T parse(String dateString,String dateFormat,Class<T> targetResultType) {
		if(StringUtil.isEmpty(dateString))
			return null;
		DateFormat df = new SimpleDateFormat(dateFormat);
		try {
			long time = df.parse(dateString).getTime();
			java.util.Date t = targetResultType.getConstructor(long.class).newInstance(time);
			return (T)t;
		} catch (ParseException e) {
			String errorInfo = "cannot use dateformat:"+dateFormat+" parse datestring:"+dateString;
			throw new IllegalArgumentException(errorInfo,e);
		} catch (Exception e) {
			throw new IllegalArgumentException("error targetResultType:"+targetResultType.getName(),e);
		}
	}
	/**
	 * 
	 * @datetime ：Oct 6, 2008 1:37:20 PM
	 * @功能 ：Convert Date to String, using the default date format - "yyyy-MM-dd";
	 * @param date
	 * @return
	 */
	public static String transDate2String(Date date) {
		return format(date, DATE_FORMAT_DEFAULT);
	}
	
	/**
	 * 
	 * @datetime ：Oct 6, 2008 1:37:23 PM
	 * @功能 ：Convert Date to String
	 * @param date
	 * @param dateFormat
	 * @return
	 */
	public static String format(Date date, String dateFormat) {
		String dateString = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);   
		    dateString = sdf.format(date);
		} catch (RuntimeException e) {}
		return dateString;
	}
	
	/**
	 * 
	 * @datetime ：2009-2-27 上午09:19:29
	 * @功能 ：返回指定时间的Calendar对象
	 * @param date
	 * @return
	 */
	public static Calendar getCalendar(String dateString) {
		Date date = parse(dateString);
		Calendar calendar = getCalendar(date);
		return calendar;
	}
	
	/**
	 * 
	 * @datetime ：2009-2-27 上午09:19:29
	 * @功能 ：返回指定时间的Calendar对象
	 * @param date
	 * @return
	 */
	public static Calendar getCalendar(String dateString, String dateFormat) {
		Date date = parse(dateString, dateFormat);
		Calendar calendar = getCalendar(date);
		return calendar;
	}
	
	/**
	 * 
	 * @datetime ：2009-2-27 上午09:19:29
	 * @功能 ：返回指定时间的Calendar对象
	 * @param date
	 * @return
	 */
	public static Calendar getCalendar(Date date) {
		Calendar calendar = null;
		if (date != null) {
			calendar = Calendar.getInstance();
			calendar.setTime(date);
		}
		return calendar;
	}
	
	/**
	 * 功能描述：返回年份
	 * 
	 * @param date
	 *            Date 日期
	 * @return 返回年份
	 */
	public static int getYear(Date date) {
		Calendar calendar = getCalendar(date);
		return calendar.get(Calendar.YEAR);
	}
	
	/**
	 * 功能描述：返回月份
	 * 
	 * @param date
	 *            Date 日期
	 * @return 返回月份
	 */
	public static int getMonth(Date date) {
		Calendar calendar = getCalendar(date);
		return calendar.get(Calendar.MONTH) + 1;
	}
	
	/**
	 * 功能描述：返回日份
	 * 
	 * @param date
	 *            Date 日期
	 * @return 返回日份
	 */
	public static int getDay(Date date) {
		Calendar calendar = getCalendar(date);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * 功能描述：返回小时
	 * 
	 * @param date
	 *            日期
	 * @return 返回小时
	 */
	public static int getHour(Date date) {
		Calendar calendar = getCalendar(date);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 功能描述：返回分钟
	 * 
	 * @param date
	 *            日期
	 * @return 返回分钟
	 */
	public static int getMinute(Date date) {
		Calendar calendar = getCalendar(date);
		return calendar.get(Calendar.MINUTE);
	}

	/**
	 * 返回秒钟
	 * 
	 * @param date
	 *            Date 日期
	 * @return 返回秒钟
	 */
	public static int getSecond(Date date) {
		Calendar calendar = getCalendar(date);
		return calendar.get(Calendar.SECOND);
	}
	
	/**
	 * 功能描述：返回毫秒
	 * 		E.g., at 10:04:15.250 PM the <code>MILLISECOND</code> is 250.
	 * @param date
	 *            日期
	 * @return 返回毫秒
	 */
	public static int getMillisecond(Date date) {
		Calendar calendar = getCalendar(date);
		return calendar.get(Calendar.MILLISECOND);
	}

	/**
	 * 功能描述：返回指定时间的毫秒
	 * 
	 * @param date
	 *            日期
	 * @return 返回毫秒
	 */
	public static long getMillis(Date date) {
		Calendar calendar = getCalendar(date);
		return calendar.getTimeInMillis();
	}
	
	/**
	 * 功能描述：日期加指定年数
	 * 
	 * @param date
	 *            Date 日期
	 * @param day
	 *            int 天数
	 * @return 返回相加后的日期
	 */
	public static Date addYear(Date date, int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, year);
		return calendar.getTime();
	}
	
	/**
	 * 功能描述：日期减指定年数
	 * 
	 * @param date
	 *            Date 日期
	 * @param day
	 *            int 天数
	 * @return 返回相减后的日期
	 */
	public static Date diffYear(Date date, int year) {
		year = 0 - year;
		return addMonth(date, year);
	}
	
	/**
	 * 功能描述：日期加指定月数
	 * 
	 * @param date
	 *            Date 日期
	 * @param day
	 *            int 天数
	 * @return 返回相加后的日期
	 */
	public static Date addMonth(Date date, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, month);
		return calendar.getTime();
	}
	
	/**
	 * 功能描述：日期减指定月数
	 * 
	 * @param date
	 *            Date 日期
	 * @param day
	 *            int 天数
	 * @return 返回相减后的日期
	 */
	public static Date diffMonth(Date date, int month) {
		month = 0 - month;
		return addMonth(date, month);
	}
	
	/**
	 * 功能描述：日期加指定天数
	 * 
	 * @param date
	 *            Date 日期
	 * @param day
	 *            int 天数
	 * @return 返回相加后的日期
	 */
	public static Date addDay(Date date, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, day);
		return calendar.getTime();
	}
	
	/**
	 * 功能描述：日期减指定天数
	 * 
	 * @param date
	 *            Date 日期
	 * @param day
	 *            int 天数
	 * @return 返回相减后的日期
	 */
	public static Date diffDay(Date date, int day) {
		day = 0 - day;
		return addDay(date, day);
	}
	
	/**
	 * 功能描述：日期相减
	 * 
	 * @param date
	 *            Date 日期
	 * @param date1
	 *            Date 日期
	 * @return 返回相减后的天数
	 */
	public static int diffDate(Date date, Date date1) {
		return (int) ((getMillis(date) - getMillis(date1)) / (24 * 3600 * 1000));
	}
	
	/**
	 * 
	 * @datetime ：2009-2-27 下午01:19:51
	 * @功能 ：取得指定月份的第一天
	 * @param dateStr
	 * @return
	 */
	
	public static Date getFirstDayForMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int day = calendar.get(Calendar.DAY_OF_MONTH) - 1;
		return diffDay(date, day);
	}
	
	/**
	 * 
	 * @datetime ：2009-2-27 下午03:31:18
	 * @功能 ：取得指定月份的第一天
	 * @param dateStr
	 * @return
	 */
	public static String getFirstDayForMonth(String dateStr) {
		Date date = parse(dateStr);
		date = getFirstDayForMonth(date);
		return transDate2String(date);
	}
	
	/**
	 * 
	 * @datetime ：2009-2-27 下午03:31:25
	 * @功能 ：取得指定月份的最后一天
	 * @param date
	 * @return
	 */
	public static Date getLastDayForMonth(Date date) {
		date = getFirstDayForMonth(date);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		calendar.add(Calendar.DAY_OF_YEAR, -1);
		return calendar.getTime();
	}
	
	/**
	 * 
	 * @datetime ：2009-2-27 下午03:31:37
	 * @功能 ：取得指定月份的最后一天
	 * @param dateStr
	 * @return
	 */
	public static String getLastDayForMonth(String dateStr) {
		Date date = parse(dateStr);
		date = getLastDayForMonth(date);
		return transDate2String(date);
	}
	
	/**
	 * 
	 * @datetime ：2009-7-6 下午04:42:35
	 * @author ：JasonFeng
	 * @功能 ：得到当前日期的年份
	 * @return
	 */
	public static String getCurrentYear() {
		Calendar calendar = Calendar.getInstance();
		return String.valueOf(calendar.get(Calendar.YEAR));
	}
	
	/**
	 * 
	 * @datetime ：2009-7-6 下午04:42:51
	 * @author ：JasonFeng
	 * @功能 ：得到当前日期的月份
	 * @return
	 */
	public static String getCurrentMonth() {
		Calendar calendar = Calendar.getInstance();
		return String.valueOf(calendar.get(Calendar.MONTH) + 1);
	}
	
	public static void main(String[] args) {
		/*Calendar c1 = Calendar.getInstance();
		c1.set(2009, 6, 8, 14, 10, 0);
		//System.out.println(minuteDiff(c1.getTime(), 23));*/
		//System.out.println(getLastDayForMonth("2009-01-13"));
		
	}
	
	private static String minuteDiff(Date date, int m1) {
		long diff = 0;
		String rtn = "";
		long tn = Calendar.getInstance().getTimeInMillis();
		Calendar c2 = Calendar.getInstance();
		c2.setTime(date);
		c2.add(Calendar.MINUTE, m1);
		long ty = c2.getTimeInMillis();
		
		diff = (ty - tn) / 1000;
		if (diff < 0) {
			diff = Math.abs(diff);
		}
		if (diff > 60) {
			rtn = (diff / 60) + "分钟";
		} else {
			rtn = diff + "秒";
		}
		return rtn;
	}
	
}