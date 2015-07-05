package com.eagle.run.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
		try {
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
//			System.out.println(sf.format(new Date()));

			// String d1=sf.format("2012-09-10");
			// String d2=sf.format("2012-09-11");

			// Date d1 = sf.parse("2012-09-10");
			// Date d2 = sf.parse("2012-09-10");

			// 创建两个不同的date
			Date d1 = new Date(1382403496729L);// 1382403496729
			Date d2 = new Date();
			System.out.println(compareDate(d1,d2));
			
			// 把date格式化为"yyyy-MM-dd"的形式
			String fDate1 = sf.format(d1);
			String fDate2 = sf.format(d2);
//			System.out.println(fDate1.equals(fDate2));// 比较两个字符串

			// 或者把日期形式的字符串解析为Date
			Date pDate1 = sf.parse(fDate1);
			Date pDate2 = sf.parse(fDate2);

//			System.out.println(pDate1.compareTo(pDate2));

			Calendar c1 = Calendar.getInstance();
			Calendar c2 = Calendar.getInstance();

			c1.setTime(d1);
			c2.setTime(d2);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 判断两个日期是不是同一天,是返回0, 第一参数比第二个参数早返回<0的数字 第一参数比第二个参数晚返回>0的数字
	 * */
	public static int compareDate(Date d1, Date d2) throws ParseException {
		// 构造一个"yyyy-MM-dd"形式的sf
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

		// 把日期格式化为规定的字符串
		String f1 = sf.format(d1);
		String f2 = sf.format(d2);

		// 解析日期字符串,解析后的日期格式为"yyyy-MM-dd"
		Date pDate1 = sf.parse(f1);
		Date pDate2 = sf.parse(f2);

		return pDate1.compareTo(pDate2);// 比较
	}
	/**
	 * 是同一天返回true
	 * */
	public static boolean compareDateBoolean(Date d1, Date d2){
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		
		// 把日期格式化为规定的字符串
		String f1 = sf.format(d1);
		String f2 = sf.format(d2);
		
		return f1.equals(f2);
	}
}
