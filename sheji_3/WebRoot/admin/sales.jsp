<%@page import="com.hzyc.practice.models.Page"%>
<%@page import="com.hzyc.practice.models.Good"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
		if(event.keyCode==13){
			var val=document.getElementById("search").value;
			
			window.location="OrderController/selectSalesByYear.do?year="+val;
		}
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
                                <span>年份</span>
                                <input type="text" value="" class="search"  id="search" onKeyPress="search()" >
                            </div>
                        </div>
                    </div>
                    <!--表格-->
                    <form action="" id="mainForm" method="post" enctype="application/x-www-form-urlencoded">
                    <table class="table" cellspacing="0" cellpadding="0">
                        <thead>
                            <tr>
                                <th width="10%">月份</th>
                                <th width="20%">销售额</th>
                                <th width="10%">订单数量</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${list}" var="sale">
                            <tr>
                             
                                 <td><label for="c1" class="label">${sale.m }</label></td>
                               <td><fmt:formatNumber type="number" value="${sale.monthTotal}" pattern="0.00" maxFractionDigits="2"/></td> 
                                <td>${sale.orderNumber}</td>
                                
                                
                            </tr>
                            </c:forEach>
                           
                        </tbody>
                    </table>
                    </form>
                    
                    
                </div>

</body>
</html>
