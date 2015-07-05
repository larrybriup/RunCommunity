package com.eagle.run.common.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Memberinfo implements java.io.Serializable {

	private Long id;
	private Graderecord graderecord;
	private String nickName;
	private String passwd;
	private String gender;
	private Long age;
	private String email;
	//省市
	private String provinceCity;
	private String address;
	private String phone;
	//找回密码提示问题
	private String passwdQuestion;
	//找回密码提示问题答案
	private String passwdAnswer;
	//推荐人
	private String recommender;
	//积分
	private Long point=0L;
	//注册日期
	private Date registerdate;
	//最后登陆时间
	private Date latestdate;
	//用户的状态,0正常,1冻结
	private Long status;
	//用户是否在线,0下线,1在线
	private Long isonline;
	//用户的个人空间
	private Memberspace memberSpace;

	public Memberinfo() {
	}

	public Memberinfo( String nickName,
			String passwd, String gender, Long age, String email) {
		this.nickName = nickName;
		this.passwd = passwd;
		this.gender = gender;
		this.age = age;
		this.email = email;
	}
	
	public Memberinfo(String nickName, String passwd, String gender,
			String email, String provinceCity, String address, String phone,
			String passwdQuestion, String passwdAnswer) {
		this.nickName = nickName;
		this.passwd = passwd;
		this.gender = gender;
		this.email = email;
		this.provinceCity = provinceCity;
		this.address = address;
		this.phone = phone;
		this.passwdQuestion = passwdQuestion;
		this.passwdAnswer = passwdAnswer;
	}

	public Memberinfo(Long id, Graderecord graderecord, String nickName,
			String passwd, String gender, Long age, String email,
			String provinceCity, String address, String phone,
			String passwdQuestion, String passwdAnswer, String recommender,
			Long point, Date registerdate, Date latestdate, Long status,
			Long isonline, Memberspace memberSpace) {
		this.id = id;
		this.graderecord = graderecord;
		this.nickName = nickName;
		this.passwd = passwd;
		this.gender = gender;
		this.age = age;
		this.email = email;
		this.provinceCity = provinceCity;
		this.address = address;
		this.phone = phone;
		this.passwdQuestion = passwdQuestion;
		this.passwdAnswer = passwdAnswer;
		this.recommender = recommender;
		this.point = point;
		this.registerdate = registerdate;
		this.latestdate = latestdate;
		this.status = status;
		this.isonline = isonline;
		this.memberSpace = memberSpace;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Graderecord getGraderecord() {
		return graderecord;
	}

	public void setGraderecord(Graderecord graderecord) {
		this.graderecord = graderecord;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProvinceCity() {
		return provinceCity;
	}

	public void setProvinceCity(String provinceCity) {
		this.provinceCity = provinceCity;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getRecommender() {
		return recommender;
	}

	public void setRecommender(String recommender) {
		this.recommender = recommender;
	}

	public Long getPoint() {
		return point;
	}

	public void setPoint(Long point) {
		this.point = point;
	}

	public Date getRegisterdate() {
		return registerdate;
	}

	public void setRegisterdate(Date registerdate) {
		this.registerdate = registerdate;
	}

	public Date getLatestdate() {
		return latestdate;
	}

	public void setLatestdate(Date latestdate) {
		this.latestdate = latestdate;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Long getIsonline() {
		return isonline;
	}

	public void setIsonline(Long isonline) {
		this.isonline = isonline;
	}

	public Memberspace getMemberSpace() {
		return memberSpace;
	}

	public void setMemberSpace(Memberspace memberSpace) {
		this.memberSpace = memberSpace;
	}



}