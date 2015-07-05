package com.eagle.run.web.action;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.eagle.run.common.bean.Memberinfo;
import com.eagle.run.common.util.BeanFactory;
import com.eagle.run.service.IMemberService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String username;
	private String password;
	private String authCode;
	private String autoLogin;
	private Map<String, Object> session;
	private Date latestdate;
	private IMemberService service = (IMemberService) BeanFactory
			.getBean(BeanFactory.MEMBERSERVICE);

	/* 用户登陆 */
	@Override
	public String execute() throws Exception {
		try {
			if("yes".equals(autoLogin)){
				HttpServletResponse resp = ServletActionContext.getResponse();
				// 创建新cookie
				Cookie c1 = new Cookie("username", username);
				Cookie c2 = new Cookie("password", password);
				
				c1.setMaxAge(60*60*24*365);
				c2.setMaxAge(60*60*24*365);
				
				resp.addCookie(c1);
				resp.addCookie(c2);
				
			}
				Memberinfo memberinfo = service.login(username, password);

				session  = ActionContext.getContext().getSession();
				session.put("memberinfo", memberinfo);

		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}

		return SUCCESS;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getAutoLogin() {
		return autoLogin;
	}

	public void setAutoLogin(String autoLogin) {
		this.autoLogin = autoLogin;
	}

	public Date getLatestdate() {
		return latestdate;
	}

	public void setLatestdate(Date latestdate) {
		this.latestdate = latestdate;
	}

}
