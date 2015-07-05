package com.eagle.run.common.util;

import com.eagle.run.dao.IMemberDao;
import com.eagle.run.dao.IMessengerDao;
import com.eagle.run.dao.impl.MemberDaoImpl;
import com.eagle.run.dao.impl.MessengerDaoImpl;
import com.eagle.run.service.IMemberService;
import com.eagle.run.service.IMessengerService;
import com.eagle.run.service.impl.MemberServiceImpl;
import com.eagle.run.service.impl.MessengerServiceImpl;

//帮我们获得dao层或者实现层的实现类对象
public class BeanFactory {
	public static String MEMBERDAO = "memberDao";
	public static String MEMBERSERVICE = "memberService";
	public static String MESSENGERDAO = "messengerDao";
	public static String MESSENGERSERVICE = "messengerService";

	private static IMemberDao memberDao=new MemberDaoImpl();
	private static IMemberService memberService=new MemberServiceImpl();
	private static IMessengerDao messengerDao=new MessengerDaoImpl();
	private static IMessengerService messengerService=new MessengerServiceImpl();

	public static Object getBean(String beanName) {
		if (beanName.equals(MEMBERDAO)) {
			memberDao = getMemberDao();
			return memberDao;
		}
		if (beanName.equals(MEMBERSERVICE)) {
			memberService = getMemberService();
			return memberService;
		}
		if (beanName.equals(MESSENGERDAO)) {
			messengerDao = getMessengerDao();
			return messengerDao;
		}
		if (beanName.equals(MESSENGERSERVICE)) {
			messengerService = getMessengerService();
			return messengerService;
		}
		
		return null;
	}
	
	synchronized private static IMemberDao getMemberDao() {

		return memberDao;
	}

	synchronized private static IMemberService getMemberService() {
		return memberService;
	}

	synchronized private static IMessengerDao getMessengerDao() {
		return messengerDao;
	}

	synchronized private static IMessengerService getMessengerService() {
		return messengerService;
	}
}
