package com.eagle.run.service.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.id.IdentityGenerator.GetGeneratedKeysDelegate;

import com.eagle.run.common.bean.Friendrecord;
import com.eagle.run.common.bean.Graderecord;
import com.eagle.run.common.bean.Memberinfo;
import com.eagle.run.common.bean.Memberspace;
import com.eagle.run.common.bean.Pointaction;
import com.eagle.run.common.bean.Pointrecord;
import com.eagle.run.common.exception.DataAccessException;
import com.eagle.run.common.exception.MemberServiceException;
import com.eagle.run.common.transaction.HibernateTransaction;
import com.eagle.run.common.util.AddPoint;
import com.eagle.run.common.util.BeanFactory;
import com.eagle.run.common.util.HibernateSessionFactory;
import com.eagle.run.common.util.Util;
import com.eagle.run.dao.IMemberDao;
import com.eagle.run.service.IMemberService;

public class MemberServiceImpl implements IMemberService {
	private IMemberDao dao = (IMemberDao) BeanFactory
			.getBean(BeanFactory.MEMBERDAO);
	private HibernateTransaction tran = new HibernateTransaction();

	public void registerMemberinfo(Memberinfo memberinfo)
			throws MemberServiceException {
		// 开启事务
		tran.beginTransaction();
		try {
			// 查询用户名是否存在
			Memberinfo findMemberinfo = dao.findMemberinfoByName(memberinfo
					.getNickName());
			if (findMemberinfo != null) {
				throw new MemberServiceException("用户名已经被占用!");
			}
			memberinfo = AddPoint.addpoint(AddPoint.REGISTER, memberinfo);

			String recommender = memberinfo.getRecommender();

			if (recommender != null && !recommender.equals("")) {
				Memberinfo findRecommender = dao
						.findMemberinfoByName(recommender);
				if (findRecommender != null) {
					AddPoint.addpoint(AddPoint.RECOMMEND, findRecommender);
				}
			}
			// 提交事务
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
			// 回滚事务
			tran.rollback();
			throw new MemberServiceException(e.getMessage());
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	public Memberinfo findMemberinfoByName(String nickname)
			throws MemberServiceException {
		Memberinfo memberinfoByName = null;
		try {
			// 找到当前昵称的用户
			memberinfoByName = dao.findMemberinfoByName(nickname);
			// 如果没有找到抛出异常
			if (memberinfoByName == null) {
				throw new MemberServiceException("没有此用户!");
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new MemberServiceException(e.getMessage());
		}
		return memberinfoByName;
	}

	public Memberinfo login(String username, String passwd)
			throws MemberServiceException {
		tran.beginTransaction();
		// 得到找到的用户
		Memberinfo memberinfoByName = findMemberinfoByName(username);
		// 查看有没有此用户
		if (memberinfoByName == null) {
			throw new MemberServiceException("没有此用户!");
		}
		// 查看账户是否被冻结
		if (memberinfoByName.getStatus() == 1) {
			throw new MemberServiceException("该账户已经被冻结!");
		}
		// 查看该账户是否已经登陆
		if (memberinfoByName.getIsonline() == 1) {
			System.out.println("该用户已经在线了.");
		}
		// 如果用户名和密码不对应抛出异常
		if (!memberinfoByName.getPasswd().equals(passwd)
				|| !memberinfoByName.getNickName().equals(username)) {
			throw new MemberServiceException("账户或密码不正确");
		}
		// 更新latestdate之前先把上次登陆日期拿到
		Date latestdate = memberinfoByName.getLatestdate();
		try {
			memberinfoByName = AddPoint.addpoint(AddPoint.LOGIN,
					memberinfoByName);
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
			throw new MemberServiceException(e.getMessage());
		} finally {
			HibernateSessionFactory.closeSession();
		}
		// 把用户的最近登陆日期改成上次的登陆日期
		// 但是并不保存这个信息,而是返回给前台
		memberinfoByName.setLatestdate(latestdate);
		return memberinfoByName;
	}

	public void logout(String nickname) throws MemberServiceException {
		try {
			tran.beginTransaction();
			Memberinfo findMemberinfoByName = findMemberinfoByName(nickname);
			if (findMemberinfoByName != null) {
				findMemberinfoByName.setIsonline(0L);
				dao.saveOrUpdateMemberinfo(findMemberinfoByName);
				tran.commit();
			} else {
				throw new MemberServiceException("退出失败,请重试.");
			}
		} catch (Exception e) {
			tran.rollback();
			throw new MemberServiceException(e.getMessage());
		} finally {
			HibernateSessionFactory.closeSession();
		}

	}

	public List<Memberinfo> findMemberinfoByNum(int number)
			throws MemberServiceException {
		List<Memberinfo> members = null;
		try {
			members = dao.findMemberinfoByNum(number);

		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new MemberServiceException(e.getMessage());
		}
		return members;
	}

	public int findMemberinfoOnline() throws MemberServiceException {
		// TODO Auto-generated method stub
		return 0;
	}

	public Graderecord findMemberinfoLevel(Long point)
			throws MemberServiceException {
		// TODO Auto-generated method stub
		Graderecord graderecord = null;
		try {
			graderecord = dao.findMemberinfoLevel(point);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new MemberServiceException(e.getMessage());
		}

		return graderecord;
	}

	public Memberinfo saveOrUpDate(Memberinfo memberinfo, String oldPasswd)
			throws MemberServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getBackPasswd(String nickname, String pwdQuestion,
			String pwdAnswer) throws MemberServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveOrUpdate(Memberinfo memberinfo)
			throws MemberServiceException {
//		tran.beginTransaction();
		try {
			dao.saveOrUpdateMemberinfo(memberinfo);
//			tran.commit();
		} catch (DataAccessException e) {
//			tran.rollback();
			e.printStackTrace();
			throw new MemberServiceException(e.getMessage());
		} 
//		finally {
//			HibernateSessionFactory.closeSession();
//		}

	}

	public void saveOrUpdate(String selfname, String friendname)
			throws MemberServiceException {
		// TODO Auto-generated method stub

	}

	public List<Memberinfo> listFriend(String selfname)
			throws MemberServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public void moveToBlack(String selfname, String blackname)
			throws MemberServiceException {
		// TODO Auto-generated method stub

	}

	public List<Memberinfo> listBlack(String selfname)
			throws MemberServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public Friendrecord findFriend(String friend) throws MemberServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean isMemberspace(Long id) throws MemberServiceException {
		boolean flag = false;
		try {
			Memberspace findSpace = dao.findSpace(id);
			if (findSpace != null) {
				flag = true;
			}
		} catch (DataAccessException e) {
			throw new MemberServiceException(e.getMessage());
		}
		return flag;
	}

	public void moveToFriend(String selfName, String name_searching)
			throws MemberServiceException {
		// TODO Auto-generated method stub

	}

	public void deleleBlack(String selfName, String black)
			throws MemberServiceException {
		// TODO Auto-generated method stub

	}

	public void deleleFriend(String selfName, String friend)
			throws MemberServiceException {
		// TODO Auto-generated method stub

	}

	public void delSpace(Long id) throws MemberServiceException {
//		tran.beginTransaction();

		try {
			dao.delSpace(dao.findSpace(id));
//			tran.commit();
		} catch (DataAccessException e) {
			e.printStackTrace();
//			tran.rollback();
			throw new MemberServiceException(e.getMessage());
		} 
//		finally {
//			HibernateSessionFactory.closeSession();
//		}

	}

	public Pointaction findPointactionByPointAction(String actionName)
			throws MemberServiceException {
		Pointaction pointaction = null;
			try {
				pointaction = dao.findPointactionByPointAction(actionName);
			} catch (DataAccessException e) {
				e.printStackTrace();
				throw new MemberServiceException(e.getMessage());
			}
		return pointaction;
	}

	public void save(Pointrecord pointrecord) throws MemberServiceException {
		// TODO Auto-generated method stub
//		tran.beginTransaction();
		try {
			dao.saveOrUpdatePointrecord(pointrecord);
//			tran.commit();
		} catch (DataAccessException e) {
			e.printStackTrace();
//			tran.rollback();
			throw new MemberServiceException(e.getMessage());
		}
//		finally {
//			HibernateSessionFactory.closeSession();
//		}

	}

}
