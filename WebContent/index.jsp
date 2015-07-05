<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+
						request.getServerPort()+path+"/";
					%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%= basePath%>">
<title>Insert title here</title>
</head>
<body>
<s:debug></s:debug>
积分:<s:property value="#session.memberinfo.point"/><br>
等级:<s:property value="#session.memberinfo.graderecord.gradename"/><br>
日期:<s:property value="#session.date"/><br>
星期:<s:property value="#session.day"/><br>
	<s:date name="date" format="z Gyyyy年MM月dd日 hh:mm:ss E " /><br>
星期:<s:property value="#request.msg"/><br>
${msg }
</body>
</html>