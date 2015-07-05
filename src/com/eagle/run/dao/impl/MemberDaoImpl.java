package com.eagle.run.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.eagle.run.common.bean.Blackrecord;
import com.eagle.run.common.bean.Friendrecord;
import com.eagle.run.common.bean.Graderecord;
import com.eagle.run.common.bean.Memberinfo;
import com.eagle.run.common.bean.Memberspace;
import com.eagle.run.common.bean.Pointaction;
import com.eagle.run.common.bean.Pointrecord;
import com.eagle.run.common.exception.DataAccessException;
import com.eagle.run.common.util.HibernateSessionFactory;
import com.eagle.run.dao.IMemberDao;

public class MemberDaoImpl implements IMemberDao{

	public Memberinfo findMemberinfoByName(String name)
			throws DataAccessException {
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			
			String hql="from Memberinfo m where m.nickName='"+name+"'";
			
			Query query=session.createQuery(hql);
			
			Object m = query.uniqueResult();
			if(m!=null){
				return (Memberinfo)m;
			}
		} catch (Exception e) {
			throw new DataAccessException(e.getMessage());
		}
		
		
		return null;
	}

	public void saveOrUpdateMemberinfo(Memberinfo memberinfo)
			throws DataAccessException {
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			
			session.saveOrUpdate(memberinfo);
			
		} catch (Exception e) {
			throw new DataAccessException(e.getMessage());
		}
		
		
		
	}

	public List<Memberinfo> findMemberinfoByNum(int number)
			throws DataAccessException {
		org.hibernate.Session session = HibernateSessionFactory.getSession();
		
		String hql="from Memberinfo m order by m.point desc";
		Query query = session.createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(number);
		List<Memberinfo> list = query.list();
		
		
		return list;
	}

	public Integer findMemberinfoOnline() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public Graderecord findMemberinfoLevel(Long point)
			throws DataAccessException {
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			
			String hql= "from Graderecord g where "+point+">=g.minpoint and "+point+"<g.maxpoint";
			Query query = session.createQuery(hql);
			
			Object p = query.uniqueResult();
			if(p!=null){
				return  (Graderecord) p;
			}
		} catch (Exception e) {
			throw new DataAccessException(e.getMessage());
		}
		
		return null;
	}

	public Pointaction findPointactionByPointAction(String pointAction)
			throws DataAccessException {
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			
			String hql= "from Pointaction p where p.actionname='"+pointAction+"'";
			Query query = session.createQuery(hql);
			
			Object pa = query.uniqueResult();
			if(pa!=null){
				return (Pointaction) pa;
			}
		} catch (Exception e) {
			throw new DataAccessException(e.getMessage());
		}
		
		return null;
	}

	public void saveOrUpdatePointrecord(Pointrecord pointrecord)
			throws DataAccessException {
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			
			session.saveOrUpdate(pointrecord);
			
		} catch (Exception e) {
			throw new DataAccessException(e.getMessage());
		}
		
	}

	public void saveOrUpdateFriend(Friendrecord friend)
			throws DataAccessException {
		// TODO Auto-generated method stub
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			
			session.saveOrUpdate(friend);
			
		} catch (Exception e) {
			throw new DataAccessException(e.getMessage());
		}
		
	}

	public void saveOrUpdateFriend(Blackrecord friend)
			throws DataAccessException {
		// TODO Auto-generated method stub
		try {
			org.hibernate.Session session = HibernateSessionFactory.getSession();
			
			session.saveOrUpdate(friend);
			
		} catch (Exception e) {
			throw new DataAccessException(e.getMessage());
		}
		
	}

	public List<Memberinfo> listFriend(String selfname)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Memberinfo> listBlack(String selfname)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleleBlack(Blackrecord black) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	public void deleleFriend(Friendrecord friend) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	public Friendrecord findfriend(String selfName, String friendName)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public Blackrecord findBlack(String selfName, String blackName)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public Memberspace findSpace(Long id) throws DataAccessException {
		org.hibernate.Session session = HibernateSessionFactory.getSession();
		String hql="from Memberspace m where m.id="+id;
		Query query = session.createQuery(hql);
		
		Object m = query.uniqueResult();
		if(m!=null){
			return (Memberspace) m;
		}
		return null;
	}

	public void delSpace(Memberspace space) throws DataAccessException {
		org.hibernate.Session session = HibernateSessionFactory.getSession();
		String hql="delete from Memberspace m where m.id="+space.getId();
		Query query = session.createQuery(hql);
		query.executeUpdate();
	}

	public Memberinfo recommender(String name) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
