package com.eagle.run.web.action;

import java.util.Map;

import com.eagle.run.common.bean.Memberinfo;
import com.eagle.run.common.util.BeanFactory;
import com.eagle.run.service.IMemberService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {
	private IMemberService service=
			(IMemberService) BeanFactory.getBean(BeanFactory.MEMBERSERVICE);
	@Override
	public String execute() throws Exception {
		try {
			ActionContext ac= ActionContext.getContext();
			Map<String, Object> session = ac.getSession();
			
			Memberinfo memberinfo=
					(Memberinfo) session.get("memberinfo");
			service.logout(memberinfo.getNickName());
			
			session.remove("memberinfo");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
		return SUCCESS;
	}
}
