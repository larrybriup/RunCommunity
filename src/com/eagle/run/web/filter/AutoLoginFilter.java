package com.eagle.run.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AutoLoginFilter implements Filter{

	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		Cookie[] cookies = request.getCookies();
		String username=null;
		String password=null;
		for(Cookie c:cookies){
			String cName=c.getName();
			String cValue=c.getValue();
			if("username".equals(cName)){
				username=cValue;
			}
			if("password".equals(cName)){
				password=cValue;
			}
		}
		if(username!=null&&password!=null){
			String action="LoginAction.action?username="+username+"&password="+password;
			response.sendRedirect(action);
		}else{
			chain.doFilter(req, resp);
		}

	}

	public void init(FilterConfig conf) throws ServletException {
		
	}

}
