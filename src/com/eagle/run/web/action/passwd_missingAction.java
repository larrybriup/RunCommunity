package com.eagle.run.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.eagle.run.common.bean.Memberinfo;
import com.eagle.run.common.transaction.HibernateTransaction;
import com.eagle.run.common.util.BeanFactory;
import com.eagle.run.common.util.HibernateSessionFactory;
import com.eagle.run.common.util.Util;
import com.eagle.run.service.IMemberService;
import com.opensymphony.xwork2.ActionSupport;

public class passwd_missingAction extends ActionSupport {
	private String userName;
	private String passwdQuestion;
	private String passwdAnswer;
	private IMemberService service=
			(IMemberService) BeanFactory.getBean(BeanFactory.MEMBERSERVICE);
	@Override
	public String execute() throws Exception {
		HttpServletRequest req = ServletActionContext.getRequest();
		HibernateTransaction tran= new HibernateTransaction();
		tran.beginTransaction();
		try {
			Memberinfo memberinfo = service.findMemberinfoByName(userName);
			if(!memberinfo.getPasswdQuestion().equals(passwdQuestion)||
					!memberinfo.getPasswdAnswer().equals(passwdAnswer)){
				req.setAttribute("msg", "对不起!您输入的问题或者答案有误.");
				req.setAttribute("userName", userName);
				return ERROR;
			}else{
				String passwd=Util.getRandomPasswd();
				memberinfo.setPasswd(passwd);
				service.saveOrUpdate(memberinfo);
				tran.commit();
				req.setAttribute("msg", "ok");
				req.setAttribute("passwd", passwd);
				req.setAttribute("userName", userName);
				return SUCCESS;
			}
		} catch (Exception e) {
			req.setAttribute("msg", e.getMessage());
			tran.rollback();
			return ERROR;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswdQuestion() {
		return passwdQuestion;
	}

	public void setPasswdQuestion(String passwdQuestion) {
		this.passwdQuestion = passwdQuestion;
	}

	public String getPasswdAnswer() {
		return passwdAnswer;
	}

	public void setPasswdAnswer(String passwdAnswer) {
		this.passwdAnswer = passwdAnswer;
	}
	
}
