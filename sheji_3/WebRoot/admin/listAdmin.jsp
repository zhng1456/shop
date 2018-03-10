<%@page import="com.hzyc.practice.models.Admin"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<Admin> list = (List<Admin>)request.getAttribute("list");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../admin/style/all.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
		function selectAll(){
		//取到全选按钮
		var all = document.getElementById("all");
		var array = document.getElementsByName("adminId");
		if(all.checked){
		//全选被选中，将其下所有checkbox选中
		
		for(var i=0;i<array.length;++i){
			array[i].checked=true;
			}
		}
		else{
		//将其下所有checkbox不选中
		for(var i=0;i<array.length;++i){
			array[i].checked=false;
			}
		}
		}
		
		</script>
  </head>
</head>
<body style="background: #e1e9eb;">
		<form action="<%=basePath %>AdminController/deleteMulType.do" id="mainForm" method="post">
			<div class="right">
				<div class="rightCont">
					<p class="g_title fix">内容列表 <a class="btn03" href="../admin/addAdmin.jsp">新 增</a>
					<div class="zixun fix">
						<table class="tab2" width="100%">
							<tbody>
								<tr>
								    <th>全选<input type="checkbox" id="all" onclick="selectAll()" name=""/></th>
								    <th>管理员用户名</th>
								    <th>密码</th>
								    <th>邮箱</th>
								    <th>操作</th>
								</tr>
								<c:forEach items="${list}" var="admin">
								<tr>
									<td><input type="checkbox" name="adminId" value="${admin.id}"/></td>
									<td>${admin.username}</td>
									<td>${admin.password}</td>
									<td>${admin.email }</td>
									<td>
										<a href="editAdmin.do?id=${admin.id }">修改</a>&nbsp;&nbsp;&nbsp;
										<a href="deleteAdmin.do?id=${admin.id }">删除</a>
									</td>
								</tr>
								</c:forEach>
								
							</tbody>
						</table>
						<div class='page fix'>
							共 <b><%=list.size() %></b> 条
						</div>
					</div>
				</div>
			</div>
	    </form>
	</body>
</html>