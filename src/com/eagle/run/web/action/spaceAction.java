package com.eagle.run.web.action;

import java.util.Map;

import com.eagle.run.common.bean.Memberinfo;
import com.eagle.run.common.bean.Memberspace;
import com.eagle.run.common.util.BeanFactory;
import com.eagle.run.service.IMemberService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class spaceAction extends ActionSupport {
	private IMemberService service=
			(IMemberService) BeanFactory.getBean(BeanFactory.MEMBERSERVICE);
	@Override
	public String execute() throws Exception {
			Map<String, Object> session = ActionContext.getContext().getSession();
			Memberinfo memberinfo=(Memberinfo) session.get("memberinfo");
			
			if(memberinfo.getMemberSpace()==null){
				return ERROR;
			}else{
				return SUCCESS;
			}
	}
}
