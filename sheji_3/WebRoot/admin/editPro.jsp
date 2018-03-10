<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'editPro.jsp' starting page</title>
    
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
<h3>修改商品</h3>
<form action="GoodController/updateGood.do" method="post" enctype="multipart/form-data">
<table width="70%"  border="1" cellpadding="5" cellspacing="0" bgcolor="#cccccc">
	<tr>
		<td align="right">商品名称</td>
		<td><input type="text" name="name"  value="${requestScope.good.name}"/></td>
	</tr>
	<tr>
		<td align="right">商品分类</td>
		<td>
		<select name="type.id">
		<c:forEach items="${requestScope.list}" var="type" >
		<option value="${type.id}" <c:if test="${type.id==requestScope.good.type.id}">selected</c:if>>${type.name}</option>
		</c:forEach>
		</select>
		</td>
	</tr>
	<tr>
		<td align="right">商品数量</td>
		<td><input type="text" name="number"  value="${requestScope.good.number}"/></td>
	</tr>
	<tr>
		<td align="right">商品市场价</td>
		<td><input type="text" name="price"  value="${requestScope.good.price}"/></td>
	</tr>
	<tr>
		<td align="right">商品描述</td>
		<td>
			<textarea name="description" id="editor_id" style="width:100%;height:150px;">${requestScope.good.description}</textarea>
		</td>
	</tr>
	<tr>
		<td align="right">商品图像</td>
		<td>
			<input type="file" name="file">
		</td>
		<td><input type="hidden" name="id" value="${requestScope.good.id}"></td>
		<td><input type="hidden" name="pictureName" value="${requestScope.good.pictureName}"></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit"  value="编辑商品"/></td>
	</tr>
</table>
</form>
</body>
</html>
