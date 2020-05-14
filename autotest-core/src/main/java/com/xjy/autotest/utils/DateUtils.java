package com.xjy.autotest.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DateUtils {
	private static final String patternDef = "yyyy-MM-dd";
	private static Map<String, ThreadLocal<SimpleDateFormat>> sdfMap = new ConcurrentHashMap();

	public DateUtils() {
	}

	private static SimpleDateFormat getSdf(final String pattern) {
		ThreadLocal<SimpleDateFormat> sdf = (ThreadLocal)sdfMap.get(pattern);
		if (sdf == null) {
			sdf = new ThreadLocal<SimpleDateFormat>() {
				protected SimpleDateFormat initialValue() {
					return new SimpleDateFormat(pattern);
				}
			};
			sdfMap.put(pattern, sdf);
		}

		return (SimpleDateFormat)sdf.get();
	}

	public static Date paresMonday(Date time) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		int dayWeek = cal.get(7);
		if (1 == dayWeek) {
			cal.add(5, -1);
		}

		cal.setFirstDayOfWeek(2);
		int day = cal.get(7);
		cal.add(5, cal.getFirstDayOfWeek() - day);
		return cal.getTime();
	}

	public static Date paresSunday(Date time) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		int dayWeek = cal.get(7);
		if (1 == dayWeek) {
			cal.add(5, -1);
		}

		cal.setFirstDayOfWeek(2);
		int day = cal.get(7);
		cal.add(5, cal.getFirstDayOfWeek() - day);
		cal.add(5, 6);
		return cal.getTime();
	}

	public static String formatDate(Date date, String pattern) {
		SimpleDateFormat formater = getSdf(pattern);
		return formater.format(date);
	}

	public static String formatDate(Date date) {
		return getSdf("yyyy-MM-dd").format(date);
	}

	public static Date newDate(long timeMillis) {
		Calendar logDate = Calendar.getInstance();
		logDate.setTimeInMillis(timeMillis);
		return logDate.getTime();
	}

	public static Date parseDate(String dateStr, String pattern) {
		SimpleDateFormat formater = getSdf(pattern);

		try {
			return formater.parse(dateStr);
		} catch (ParseException var4) {
			var4.printStackTrace();
			return null;
		}
	}

	public static Date parseDate(String dateStr) {
		return parseDate(dateStr, "yyyy-MM-dd");
	}

	public static Date parseDate2(String dateStr) {
		return parseDate(dateStr, "yyyy-MM-dd HH:mm:ss");
	}

	public static int getCurrentYear() {
		return Calendar.getInstance().get(1);
	}

	public static int getCurrentMonth() {
		return Calendar.getInstance().get(2) + 1;
	}

	public static long getSencondDiffer(Date d1, Date d2) {
		long rel = d2.getTime() - d1.getTime();
		return Math.abs(rel / 1000L);
	}

	public static int compareToDay(Date date1, Date date2) {
		if (date1 != null && date2 != null) {
			SimpleDateFormat sdf = getSdf("yyyyMMdd");
			return sdf.format(date1).compareTo(sdf.format(date2));
		} else {
			return 0;
		}
	}

	public static int compareToHour(Date date1, Date date2) {
		if (date1 != null && date2 != null) {
			SimpleDateFormat sdf = getSdf("yyyyMMddHH");
			return sdf.format(date1).compareTo(sdf.format(date2));
		} else {
			return 0;
		}
	}

	public static int compareToSecond(Date date1, Date date2) {
		if (date1 != null && date2 != null) {
			SimpleDateFormat sdf = getSdf("yyyyMMddHHmmss");
			return sdf.format(date1).compareTo(sdf.format(date2));
		} else {
			return 0;
		}
	}

	public static Date getStartDateOfDay(Date day) {
		if (day == null) {
			return null;
		} else {
			Calendar cal = Calendar.getInstance();
			cal.setTime(day);
			cal.set(14, 0);
			cal.set(13, 0);
			cal.set(12, 0);
			cal.set(11, 0);
			return cal.getTime();
		}
	}

	public static Date getEndDateOfDay(Date day) {
		if (day == null) {
			return null;
		} else {
			Calendar cal = Calendar.getInstance();
			cal.setTime(day);
			cal.set(14, 0);
			cal.set(13, 59);
			cal.set(12, 59);
			cal.set(11, 23);
			return cal.getTime();
		}
	}

	public static Date getStartDateOfMonth(Date day) {
		if (day == null) {
			return null;
		} else {
			Calendar cal = Calendar.getInstance();
			cal.setTime(day);
			cal.set(14, 0);
			cal.set(13, 0);
			cal.set(12, 0);
			cal.set(11, 0);
			cal.set(5, 1);
			return cal.getTime();
		}
	}

	public static Date getEndDateOfMonth(Date day) {
		if (day == null) {
			return null;
		} else {
			Calendar cal = Calendar.getInstance();
			cal.setTime(day);
			cal.set(14, 0);
			cal.set(13, 59);
			cal.set(12, 59);
			cal.set(11, 23);
			cal.set(5, 1);
			cal.add(2, 1);
			cal.add(5, -1);
			return cal.getTime();
		}
	}

	public static Date getStartDateOfYear(Date day) {
		if (day == null) {
			return null;
		} else {
			Calendar cal = Calendar.getInstance();
			cal.setTime(day);
			cal.set(14, 0);
			cal.set(13, 0);
			cal.set(12, 0);
			cal.set(11, 0);
			cal.set(5, 1);
			cal.set(2, 0);
			return cal.getTime();
		}
	}

	public static Date getEndDateOfYear(Date day) {
		if (day == null) {
			return null;
		} else {
			Calendar cal = Calendar.getInstance();
			cal.setTime(day);
			cal.set(14, 0);
			cal.set(13, 59);
			cal.set(12, 59);
			cal.set(11, 23);
			cal.set(5, 1);
			cal.set(2, 0);
			cal.add(1, 1);
			cal.add(6, -1);
			return cal.getTime();
		}
	}

	public static Date getDate(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(1, year);
		cal.set(2, month);
		cal.set(5, day);
		cal.set(11, 0);
		cal.set(12, 0);
		cal.set(13, 0);
		cal.set(14, 0);
		return cal.getTime();
	}

	public static Date getDate(int year, int month, int day, int hour, int minute, int second) {
		Calendar cal = Calendar.getInstance();
		cal.set(1, year);
		cal.set(2, month);
		cal.set(5, day);
		cal.set(11, hour);
		cal.set(12, minute);
		cal.set(13, second);
		cal.set(14, 0);
		return cal.getTime();
	}

	public static int getYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(1);
	}

	public static int getMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(2);
	}

	public static int getDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(5);
	}

	public static int calculateMonthDistance(Date start, Date end) {
		int year1 = getYear(start);
		int year2 = getYear(end);
		int month1 = getMonth(start);
		int month2 = getMonth(end);
		return 12 * (year1 - year2) + (month1 - month2);
	}

	public static int calculateDayDistance(Date start, Date end) {
		long startTimeInMillis = start.getTime();
		long endTimeInMillis = end.getTime();
		return (int)((startTimeInMillis - endTimeInMillis) / 86400000L);
	}

	public static Date now() {
		return Calendar.getInstance().getTime();
	}

	public static long nowInMillis() {
		return Calendar.getInstance().getTimeInMillis();
	}

	public static String nowInFormat(String pattern) {
		SimpleDateFormat sdf = getSdf(pattern);
		return sdf.format(Calendar.getInstance().getTime());
	}

//	public static String nowAfterMouth(String dateStr, String pattern) {
//		Date date = parseDate(dateStr, pattern);
//		date.setMonth(date.getMonth() + 1);
//		String datestr2 = formatDate(date, pattern);
//		return datestr2;
//	}

	public static String nowBeforeMouth() {
		String dateStr = nowInFormat("yyyy-MM-dd");
		Date now = parseDate(dateStr);
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(2, -1);
		Date date2 = c.getTime();
		String datestr2 = formatDate(date2, "yyyy-MM-dd");
		return datestr2;
	}

	public static Date changeDays(Date date, int count) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(5, count);
		Date date2 = c.getTime();
		return date2;
	}

	public static Date changeDays(String date, int count) {
		Date date1 = parseDate(date);
		Calendar c = Calendar.getInstance();
		c.setTime(date1);
		c.add(5, count);
		Date date2 = c.getTime();
		return date2;
	}

	public static Date changeHours(Date date, int count) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(10, count);
		Date date2 = c.getTime();
		return date2;
	}

	public static Date changeMinute(Date date, int count) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(12, count);
		Date date2 = c.getTime();
		return date2;
	}

	public static Date changeMonth(Date date, int count) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(2, count);
		Date date2 = c.getTime();
		return date2;
	}

	public static Date changeYear(Date date, int count) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(1, count);
		Date date2 = c.getTime();
		return date2;
	}

	public static Date changeSecond(Date date, int count) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(13, count);
		return calendar.getTime();
	}

	public static Date changeSecond(String date, int count) {
		Date date1 = parseDate(date);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date1);
		calendar.add(13, count);
		return calendar.getTime();
	}

	public static boolean checkDate(Date startDate, Date endDate) {
		boolean result = false;
		if (startDate != null && endDate != null) {
			Date nowDate = now();
			if (compareToSecond(nowDate, startDate) > 0 && compareToSecond(endDate, nowDate) > 0) {
				result = true;
			}
		}

		return result;
	}

	public static boolean checkDate2(Date startDate, Date endDate) {
		boolean result = false;
		Date nowDate;
		if (startDate != null && endDate != null) {
			nowDate = now();
			if (compareToSecond(nowDate, startDate) > 0 && compareToSecond(endDate, nowDate) > 0) {
				result = true;
			}
		} else if (startDate == null && endDate != null) {
			nowDate = now();
			if (compareToSecond(endDate, nowDate) > 0) {
				result = true;
			}
		} else if (startDate != null && endDate == null) {
			nowDate = now();
			if (compareToSecond(nowDate, startDate) > 0) {
				result = true;
			}
		} else {
			result = true;
		}

		return result;
	}

	/**
	 * @return返回长时间格式 yyyy-MM-dd HH:mm:ss
	 */
	public static Date getSqlDate() {
		Date sqlDate = new java.sql.Date(new Date().getTime());
		return sqlDate;
	}

	/**
	 * 明天
	 */
	public static Date tomorrow() {
		try {
			Date nowDate = new Date();
			Calendar cd = Calendar.getInstance();
			cd.setTime(nowDate);
			cd.add(Calendar.DATE, 1);//增加一天
			//cd.add(Calendar.MONTH, n);//增加一个月
			return cd.getTime();
		} catch (Exception e) {
			return null;
		}
	}
}
