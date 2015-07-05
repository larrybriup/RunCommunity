<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+
						request.getServerPort()+path+"/";
					%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="<%= basePath%>">
<title>Insert title here</title>
<script type="text/javascript">
	function a(){
		//alert("hfg");
	}
</script>
</head>
<body>
<!-- 
	<a href="LogoutAction.action" onclick="LogoutAction.action">hsh</a><hr>
	<s:property value="#session.username"/><hr>
	<input type="button" value="注 销" onclick="LogoutAction.action">
	<font onclick="LogoutAction.action">sdg</font>
	<span onclick="a()">dvf</span>
 -->
 <h3>
 	<s:property value="msg"/>
 </h3>
	<form action="test/UploadAction.action" method="post" enctype="multipart/form-data">
		上传头像:<input type="file" name="image"/><br>
		<input type="submit" value="提交"/>
	</form>
	<hr>
	文件下载<br>
	<a href="test/DownloadAction.action?fileName=0.jpg">图片1</a>
	<a href="test/DownloadAction.action?fileName=1.gif">图片2</a>
	<a href="test/DownloadAction.action?fileName=3.png">图片3</a>
	<a href="test/DownloadAction.action?fileName=4.png">图片4</a>
	<s:debug></s:debug>
</body>
</html>