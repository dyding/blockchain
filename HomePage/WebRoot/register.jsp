<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   
   <form action="RegisterServlet" method="post">
		用户名：<input type="text" id="userId" name="userName" placeholder="输入用户名" /><br>
		密码：<input type="password" id="pwdId1" name="pwdName1" placeholder="输入密码" /><br>
		密码：<input type="password" id="pwdId2" name="pwdName2" placeholder="再次输入密码" /><br>
		<button type="submit">注册</button>
	</form>

  </body>
</html>
