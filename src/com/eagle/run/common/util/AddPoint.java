package com.eagle.run.common.util;

import java.util.Date;

import com.eagle.run.common.bean.Graderecord;
import com.eagle.run.common.bean.Memberinfo;
import com.eagle.run.common.bean.Pointaction;
import com.eagle.run.common.bean.Pointrecord;
import com.eagle.run.service.IMemberService;

public class AddPoint {
	public static String REGISTER = "REGISTER";
	public static String RECOMMEND = "RECOMMEND";
	public static String LOGIN = "LOGIN";
	public static String LOGINDESKHELPER = "LOGINDESKHELPER";
	public static String CREATEPERSONALSPACE = "CREATEPERSONALSPACE";
	public static String SENDSTICK = "SENDSTICK";
	public static String REPLYSTICK = "REPLYSTICK";
	public static String GOODSTICK = "GOODSTICK";
	public static String SUPERGOODSTICK = "SUPERGOODSTICK";
	public static String BBSMANAGER = "BBSMANAGER";
	public static String REPLYTENSTICK = "REPLYTENSTICK";
	public static String EDM = "EDM";
	public static String JOINRUNNING = "JOINRUNNING";
	public static String WINRUNNING1 = "WINRUNNING1";
	public static String WINRUNNING2 = "WINRUNNING2";
	private static IMemberService service = (IMemberService) BeanFactory
			.getBean(BeanFactory.MEMBERSERVICE);

	public static Memberinfo addpoint(String action, Memberinfo memberinfo)
			throws Exception {

		// 根据动作的名称查找加分动作
		Pointaction pointaction = service.findPointactionByPointAction(action);
		Date date = new Date();
		if (REGISTER.equals(action)) {
			// 设置注册日期
			memberinfo.setRegisterdate(date);
			// 获得这个动作应该加的分数,并且给memberinfo
			memberinfo.setPoint(pointaction.getPoint());
			// 获得现在积分所属的等级
			Graderecord new_level = service.findMemberinfoLevel(memberinfo
					.getPoint());
			memberinfo.setGraderecord(new_level);
		}
		/**
		 * 如果是登陆动作,更新其他状态
		 * */
		else if (LOGIN.equals(action)) {
			/**
			 * 如果不是同一天登陆就更新积分和等级
			 * */
			if (!Util.compareDateBoolean(date, memberinfo.getLatestdate())) {
				// 获得这个动作应该加的分数,并且给memberinfo
				memberinfo.setPoint(pointaction.getPoint()
						+ memberinfo.getPoint());
				// 获得用户当前等级
				Graderecord curr_level = memberinfo.getGraderecord();
				// 如果用户现在的积分大于现在所属的等级的最大积分,就更新用户等级
				if (memberinfo.getPoint() > curr_level.getMaxpoint()) {
					// 获得现在积分所属的等级
					Graderecord new_level = service
							.findMemberinfoLevel(memberinfo.getPoint());
					memberinfo.setGraderecord(new_level);
				}
			}
			// 更新latestdate
			memberinfo.setLatestdate(date);
			// 设置当前状态为在线
			memberinfo.setIsonline(1L);

		} else {
			/**
			 * 更新积分和等级
			 * */
			// 获得这个动作应该加的分数,并且给memberinfo
			memberinfo.setPoint(pointaction.getPoint() + memberinfo.getPoint());
			// 获得用户当前等级
			Graderecord curr_level = memberinfo.getGraderecord();
			// 如果用户现在的积分大于现在所属的等级的最大积分,就更新用户等级
			if (memberinfo.getPoint() > curr_level.getMaxpoint()) {
				// 获得现在积分所属的等级
				Graderecord new_level = service.findMemberinfoLevel(memberinfo
						.getPoint());
				memberinfo.setGraderecord(new_level);
			}
		}
		// 保存更新后的用户信息
		service.saveOrUpdate(memberinfo);

		// 既然加分就一定要更新加分记录表
		Pointrecord pr = new Pointrecord(pointaction, memberinfo.getNickName(),
				new Date());
		// 更新加分记录表
		service.save(pr);

		return memberinfo;
	}
}
