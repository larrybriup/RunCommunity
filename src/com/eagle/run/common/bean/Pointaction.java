package com.eagle.run.common.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Pointaction entity.
 * 
 * @author MyEclipse Persistence Tools
 */
//可以增加积分的动作
public class Pointaction implements java.io.Serializable {

	// Fields

	private Long id;
	//可以加分的行为是什么,例如登陆,注册
	private String actionname;
	//可以加多少分
	private Long point;
	//对着个动作的描述
	private String description;
	//由哪些动作记录引用了这个动作
	private Set pointrecords = new HashSet(0);

	// Constructors

	/** default constructor */
	public Pointaction() {
	}

	/** minimal constructor */
	public Pointaction(Long point) {
		this.point = point;
	}

	/** full constructor */
	public Pointaction(String actionname, Long point, String description,
			Set pointrecords) {
		this.actionname = actionname;
		this.point = point;
		this.description = description;
		this.pointrecords = pointrecords;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getActionname() {
		return this.actionname;
	}

	public void setActionname(String actionname) {
		this.actionname = actionname;
	}

	public Long getPoint() {
		return this.point;
	}

	public void setPoint(Long point) {
		this.point = point;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set getPointrecords() {
		return this.pointrecords;
	}

	public void setPointrecords(Set pointrecords) {
		this.pointrecords = pointrecords;
	}

}