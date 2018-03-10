<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品</title>
</head>
<body>
<h3>添加商品</h3>
<form action="../GoodController/InsertGood.do" method="post" enctype="multipart/form-data">
<table width="70%"  border="1" cellpadding="5" cellspacing="0" bgcolor="#cccccc">
	<tr>
		<td align="right">商品名称</td>
		<td><input type="text" name="name"  value=""/></td>
	</tr>
	<tr>
		<td align="right">商品分类</td>
		<td>
		<select name="type.id">
		<c:forEach items="${list}" var="type">
		<option value="${type.id}">${type.name}</option>
		</c:forEach>
		</select>
		</td>
	</tr>
	<tr>
		<td align="right">商品数量</td>
		<td><input type="text" name="number"  value=""/></td>
	</tr>
	<tr>
		<td align="right">商品市场价</td>
		<td><input type="text" name="price"  value=""/></td>
	</tr>
	<tr>
		<td align="right">商品描述</td>
		<td>
			<textarea name="description" id="editor_id" style="width:100%;height:150px;"></textarea>
		</td>
	</tr>
	<tr>
		<td align="right">商品图像</td>
		<td>
			<input type="file" name="file">
		</td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit"  value="发布商品"/></td>
	</tr>
</table>
</form>
</body>
</html>