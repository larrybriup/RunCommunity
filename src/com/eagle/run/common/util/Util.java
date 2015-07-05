package com.eagle.run.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.eagle.run.common.util.ip.IPSeeker;
import com.eagle.run.web.action.passwd_missingAction;

public class Util {
	public static String PROVINCE[] = { "请选择", "北京", "上海", "天津", "重庆", "辽宁",
			"广东", "浙江", "江苏", "山东", "四川", "黑龙江", "湖南", "湖北", "河南", "安徽", "河北",
			"吉林", "江西", "广西", "山西", "内蒙古", "甘肃", "贵州", "新疆", "云南", "宁夏", "海南",
			"青海", "西藏", "港澳台", "海外", "其它" };

	public static String getProvinceNameById(String id) {
		return PROVINCE[Integer.parseInt(id)];
	}

	public static String getAddress(String ip) {
		String country = "";
		String area = "";
		IPSeeker seeker = IPSeeker.getInstance();
		country = seeker.getCountry(ip);
		area = seeker.getArea(ip);
		return country + area;
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
//	//产生一个6-11位的随即字符串
//	public static String getRandomPasswd(){
//		int i=(int) (Math.random()*6+6);//产生[6-12)中的整数
//		String str="abcdefghijklmnopqrstuvwxyz";
//		str+=str.toUpperCase()+"0123456789";
//		//str+="#$%^&";
//			String str2="";
//		for(int j=0;j<=i;j++){
//			str2+=str.charAt((int) (Math.random()*62));
//		}
//		return str2;
//	}
	
	//产生一个6位的随即字符串
	public static String getRandomPasswd(){
		String str="0123456789";
		String str2="";
		for(int j=0;j<6;j++){
			str2+=str.charAt((int) (Math.random()*10));
		}
		return str2;
	}
	
	public static void main(String[] args) {
		String passwd = getRandomPasswd();
		System.out.println(passwd);
		
//		try {
//			// 创建两个不同的date
//			Date d1 = new Date(1382403496729L);// 1382403496729
//			Date d2 = new Date();
//			System.out.println(compareDate(d1, d2));
//			System.out.println(compareDateBoolean(d1, d2));
//			
//			String provinceNameById = Util.getProvinceNameById("2");
//			System.out.println(provinceNameById);
//			
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
	}
}
