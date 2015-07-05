package com.eagle.run.web.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.eagle.run.common.bean.Memberinfo;
import com.eagle.run.common.exception.MemberServiceException;
import com.eagle.run.common.util.BeanFactory;
import com.eagle.run.service.IMemberService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAfterAction extends ActionSupport implements SessionAware{
	private List<Memberinfo> members;
	private Map<String,Object> session;
	//查询当前吉米前几名用户
	private int num;
	private IMemberService service = (IMemberService) BeanFactory
			.getBean(BeanFactory.MEMBERSERVICE);

	@Override
	public String execute() {
		try {
			Object list=session.get("members");
			if(list==null){
				members = service.findMemberinfoByNum(num);
				session.put("members", members);
			}
		} catch (MemberServiceException e) {
			e.printStackTrace();
		}
		//不管结果如何都返回SUCCESS
		return SUCCESS;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public List<Memberinfo> getMembers() {
		return members;
	}

	public void setMembers(List<Memberinfo> members) {
		this.members = members;
	}

	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
}
