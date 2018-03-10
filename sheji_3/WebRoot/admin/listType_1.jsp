<%@page import="com.hzyc.practice.models.Page"%>
<%@page import="com.hzyc.practice.models.Type"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<Type> list =(List<Type>)request.getAttribute("list");
Page myPage =(Page)request.getAttribute("page");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link href="admin/style/all.css" rel="stylesheet" type="text/css" />
    <title>My JSP 'listType_1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	var currentPage=1;//刚进入时是第一页
		function selectAll(){
		//取到全选按钮
		var all = document.getElementById("all");
		var array = document.getElementsByName("typeId");
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
		//批量删除
		function deleteMul(){
		//取到表单
		var form =document.getElementById("mainForm");
		//绝对路径
		form.action="http://localhost:8080/sheji_3/TypeController/deleteMulType.do";
		form.submit();
		}
		//下一页
		function next(){
		currentPage++;
		window.location="aaaaaaaaa";
		}
		//输入第几页，进行跳转
		function turn(){
		//取到表单
		var form =document.getElementById("mainForm");
		//取到输入的页数
		var page=document.getElementById("myPage").value;
		//绝对路径
		form.action="http://localhost:8080/sheji_3/TypeController/selectPageType.do?currentPage="+page;
		//提交
		form.submit();
		}
		</script>
  </head>
  
  <body style="background: #e1e9eb;">
		<form action="" id="mainForm" method="post">
			<div class="right">
				<div class="rightCont">
					<p class="g_title fix">内容列表 <a class="btn03" href="admin/addType.jsp">新 增</a>&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" onclick="deleteMul()" class="btn03"  value="删除"> <!-- <a class="btn03"  onclick="deleteMul()">删 除</a> --></p>
					<div class="zixun fix">
						<table class="tab2" width="100%">
							<tbody>
								<tr>
								    <th>全选<input type="checkbox" id="all" onclick="selectAll()" name=""/></th>
								    <th>分类名称</th>
								    <th>操作</th>
								</tr>
								<c:forEach items="${list}" var="type">
								<tr>
									<td><input type="checkbox" name="typeId" value="${type.id}"/></td>
									<td>${type.name}</td>
									<td>
										<a href="TypeController/editType.do?id=${type.id }">修改</a>&nbsp;&nbsp;&nbsp;
										<a href="TypeController/deleteType.do?id=${type.id }">删除</a>
									</td>
								</tr>
								</c:forEach>
								
							</tbody>
						</table>
						<div class='page fix'>
							共 <b><%=myPage.getLength() %></b> 条
							<a href='TypeController/selectPageType.do?currentPage=1' class='first'>首页</a>
							<a href='TypeController/selectPageType.do?currentPage=<%=myPage.getBack() %>' class='pre'>上一页</a>
							当前第<span><%=myPage.getCurrentPage() %>/<%=myPage.getAllPage() %></span>页
							<a href='TypeController/selectPageType.do?currentPage=<%=myPage.getNext() %>' class='next'>下一页</a>
							<a href='TypeController/selectPageType.do?currentPage=<%=myPage.getAllPage() %>' class='last'>末页</a>
							跳至&nbsp;<input type='text' id="myPage" value='1' class='allInput w28' />&nbsp;页&nbsp;
							<a href='javascript:turn()' class='go'>GO</a>
						</div>
					</div>
				</div>
			</div>
	    </form>
	</body>
</html>
