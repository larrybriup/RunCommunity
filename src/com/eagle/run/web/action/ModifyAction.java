package com.eagle.run.web.action;

import java.util.Map;

import com.eagle.run.common.bean.Memberinfo;
import com.eagle.run.common.transaction.HibernateTransaction;
import com.eagle.run.common.util.BeanFactory;
import com.eagle.run.common.util.HibernateSessionFactory;
import com.eagle.run.service.IMemberService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ModifyAction extends ActionSupport {
	private String oldPasswd;
	private String newPasswd;
	private String email;
	private String passwdQuestion;
	private String passwdAnswer;
	private String gender;
	private String provinceCity;
	private String phone;
	private String address;
	private IMemberService service=
			(IMemberService) BeanFactory.getBean(BeanFactory.MEMBERSERVICE);
	
	@Override
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		Memberinfo memberinfo=
				(Memberinfo) session.get("memberinfo");
		Memberinfo findMemberinfoByName = 
				service.findMemberinfoByName(memberinfo.getNickName());
		if(findMemberinfoByName.getPasswd().equals(oldPasswd)){
			findMemberinfoByName.setPasswd(newPasswd);
			findMemberinfoByName.setGender(gender);
			findMemberinfoByName.setEmail(email);
			findMemberinfoByName.setPasswdQuestion(passwdQuestion);
			findMemberinfoByName.setPasswdAnswer(passwdAnswer);
			findMemberinfoByName.setProvinceCity(provinceCity);
			findMemberinfoByName.setPhone(phone);
			findMemberinfoByName.setAddress(address);
			
			HibernateTransaction tran= new HibernateTransaction();
			tran.beginTransaction();
			try {
				service.saveOrUpdate(findMemberinfoByName);
				tran.commit();
				return SUCCESS;
			} catch (Exception e) {
				tran.rollback();
				e.printStackTrace();
				return ERROR;
			}finally{
				HibernateSessionFactory.closeSession();
			}
		}else{
			return ERROR;
		}
		
	}
	public String getOldPasswd() {
		return oldPasswd;
	}


	public void setOldPasswd(String oldPasswd) {
		this.oldPasswd = oldPasswd;
	}


	public String getNewPasswd() {
		return newPasswd;
	}


	public void setNewPasswd(String newPasswd) {
		this.newPasswd = newPasswd;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getProvinceCity() {
		return provinceCity;
	}


	public void setProvinceCity(String provinceCity) {
		this.provinceCity = provinceCity;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
