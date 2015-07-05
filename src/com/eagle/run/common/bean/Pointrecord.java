package com.eagle.run.common.bean;

import java.util.Date;

/**
 * Pointrecord entity.
 * 
 * @author MyEclipse Persistence Tools
 */
//增加积分记录
public class Pointrecord implements java.io.Serializable {

	// Fields

	private Long id;
	//用户完成的增加积分的动作
	private Pointaction pointaction;
	//谁完成的
	private String nickname;
	//完成的时间
	private Date receivedate;

	// Constructors

	/** default constructor */
	public Pointrecord() {
	}

	/** minimal constructor */
	public Pointrecord(String nickname, Date receivedate) {
		this.nickname = nickname;
		this.receivedate = receivedate;
	}

	/** full constructor */
	public Pointrecord(Pointaction pointaction, String nickname,
			Date receivedate) {
		this.pointaction = pointaction;
		this.nickname = nickname;
		this.receivedate = receivedate;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pointaction getPointaction() {
		return this.pointaction;
	}

	public void setPointaction(Pointaction pointaction) {
		this.pointaction = pointaction;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getReceivedate() {
		return this.receivedate;
	}

	public void setReceivedate(Date receivedate) {
		this.receivedate = receivedate;
	}

}