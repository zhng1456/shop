<%@page import="com.hzyc.practice.models.Page"%>
<%@page import="com.hzyc.practice.models.Good"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<Good> list =(List<Good>)request.getAttribute("list");
Page myPage =(Page)request.getAttribute("page");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'listPro.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="admin/style/all.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="admin/style/backstage.css">
<link rel="stylesheet" href="admin/scripts/jquery-ui/css/ui-lightness/jquery-ui-1.10.4.custom.css" />
<script src="admin/scripts/jquery-ui/js/jquery-1.10.2.js"></script>
<script src="admin/scripts/jquery-ui/js/jquery-ui-1.10.4.custom.js"></script>
<script src="admin/scripts/jquery-ui/js/jquery-ui-1.10.4.custom.min.js"></script>
  <script type="text/javascript">
	function search(){
		var start =document.getElementById("start").value;
		var end =document.getElementById("end").value;
		window.location="OrderController/selectOrderByTime.do?start="+start+"&end="+end;
	}
	function change(val){
		window.location="listPro.php?order="+val;
	}
	//输入第几页，进行跳转
		function turn(){
		//取到表单
		var form =document.getElementById("mainForm");
		//取到输入的页数
		var page=document.getElementById("myPage").value;
		//绝对路径
		form.action="http://localhost:8080/sheji_3/OrderController/selectAllOrder.do?currentPage="+page;
		//提交
		form.submit();
		}
</script>

  </head>
  
  <body>
<div id="showDetail"  style="display:none;">

</div>
<div class="details">
                    <div class="details_operation clearfix">
                       
                        <div class="fr">
                            <div class="text">
                                <span>起止时间:</span>
                                <input type="date" id="start">
                                <input type="date" id="end">
                                 <input type="button" value="查询" class="search" onclick="search()">
                            </div>
                        </div>
                    </div>
                    <!--表格-->
                    <form action="" id="mainForm" method="post" enctype="application/x-www-form-urlencoded">
                    <table class="table" cellspacing="0" cellpadding="0">
                        <thead>
                            <tr>
                                <th width="10%">订单编号</th>
                                <th width="20%">时间</th>
                                <th width="10%">金额</th>
                                
                                <th width="10%">购买人</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${list}" var="order">
                            <tr>
                             
                                 <td><label for="c1" class="label">${order.id }</label></td>
                               <td>${order.time}</td> 
                                <td><fmt:formatNumber type="number" value="${order.money }" pattern="0.00" maxFractionDigits="2"/></td>
                                 <td>${order.user.personName }</td>
                                
                            </tr>
                            </c:forEach>
                           
                        </tbody>
                    </table>
                    </form>
                    <c:if test="${not empty page }">
                    <div class='page fix'>
							共 <b><%=myPage.getLength() %></b> 条
							<a href='OrderController/selectAllOrder.do?currentPage=1' class='first'>首页</a>
							<a href='OrderController/selectAllOrder.do?currentPage=<%=myPage.getBack() %>' class='pre'>上一页</a>
							当前第<span><%=myPage.getCurrentPage() %>/<%=myPage.getAllPage() %></span>页
							<a href='OrderController/selectAllOrder.do?currentPage=<%=myPage.getNext() %>' class='next'>下一页</a>
							<a href='OrderController/selectAllOrder.do?currentPage=<%=myPage.getAllPage() %>' class='last'>末页</a>
							跳至&nbsp;<input type='text' id="myPage" value='1' class='allInput w28' />&nbsp;页&nbsp;
							<a href='javascript:turn()' class='go'>GO</a>
						</div>
                    </c:if>
                    
                </div>

</body>
</html>
