<%@page import="com.hzyc.practice.models.Admin"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Admin admin=(Admin)request.getAttribute("admin");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'editAdmin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h3>修改管理员</h3>
<form action="<%=basePath %>/AdminController/updateAdmin.do" method="post">
<table width="70%" border="1" cellpadding="5" cellspacing="0" bgcolor="#cccccc">
	<tr>
		<td align="right">管理员名称</td>
		<td><input type="text" name="username" value="<%=admin.getUsername()%>"/></td>
	</tr>
	<tr>
		<td align="right">管理员密码</td>
		<td><input type="text" name="password" value="<%=admin.getPassword()%>"/></td>
	</tr>
	<tr>
		<td align="right">管理员邮箱</td>
		<td><input type="text" name="email" value="<%=admin.getEmail()%>"/></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit"  value="修改"/></td>
		<td><input type="hidden" name="id" value="<%=admin.getId()%>"></td>
	</tr>
</table>
</form>
  </body>
</html>
