package com.eagle.run.web.action;

import com.eagle.run.common.bean.Memberinfo;
import com.eagle.run.common.exception.DataAccessException;
import com.eagle.run.common.exception.MemberServiceException;
import com.eagle.run.common.util.BeanFactory;
import com.eagle.run.service.IMemberService;
import com.opensymphony.xwork2.ActionSupport;

public class MemberRegisterAction extends ActionSupport {
	private String nickName;
	private String passwd;
	private String email;
	private String passwdQuestion;
	private String passwdAnswer;
	private String gender;
	private String recommender;
	private String provinceCity;
	private Long age;
	private String phone;
	private String address;
	private String authCode;//验证码
	
	private IMemberService memberService=
			(IMemberService) BeanFactory.getBean(BeanFactory.MEMBERSERVICE);
	
	@Override
	public String execute() {
		// TODO Auto-generated method stub
		Memberinfo m= new Memberinfo();
		m.setNickName(nickName);
		m.setPasswd(passwd);
		m.setEmail(email);
		m.setPasswdQuestion(passwdQuestion);
		m.setPasswdAnswer(passwdAnswer);
		m.setGender(gender);
		m.setPhone(phone);
		m.setAddress(address);
		m.setProvinceCity(provinceCity);
		m.setAge(age);
		m.setRecommender(recommender);

		try {
			try {
				memberService.registerMemberinfo(m);
			} catch (DataAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (MemberServiceException e) {
			e.printStackTrace();
			
			return ERROR;
		}
		
		
		return SUCCESS;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
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

	public String getRecommender() {
		return recommender;
	}

	public void setRecommender(String recommender) {
		this.recommender = recommender;
	}

	public String getProvinceCity() {
		return provinceCity;
	}

	public void setProvinceCity(String provinceCity) {
		this.provinceCity = provinceCity;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
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

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	
}
