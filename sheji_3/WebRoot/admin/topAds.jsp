<%@page import="com.hzyc.practice.models.Page"%>
<%@page import="com.hzyc.practice.models.Good"%>
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
  <script type="text/javascript">
function showDetail(id,t){
	$("#showDetail"+id).dialog({
		  height:"auto",
	      width: "auto",
	      position: {my: "center", at: "center",  collision:"fit"},
	      modal:false,//是否模式对话框
	      draggable:true,//是否允许拖拽
	      resizable:true,//是否允许拖动
	      title:"图片名称："+t,//对话框标题
	      show:"slide",
	      hide:"explode"
	});
}
	function delAds(adsId){
	window.location="AdsController/deleteAds.do?id="+adsId;
	}
</script>
  </head>
  
  <body>
<div class="details">
                    <div class="details_operation clearfix">
                        <!-- <div class="bui_select">
                            <input type="button" value="添&nbsp;&nbsp;加" class="add" onClick="addPro()">
                        </div> -->
                        <!-- <div class="fr">
                            <div class="text">
                                <span>搜索</span>
                                <input type="text" value="" class="search"  id="search" onKeyPress="search()" >
                            </div>
                        </div> -->
                    </div>
                    <!--表格-->
                    <form action="" id="mainForm" method="post" enctype="application/x-www-form-urlencoded">
                    <table class="table" cellspacing="0" cellpadding="0">
                        <thead>
                            <tr>
                                <th width="10%">编号</th>
                                <th width="20%">文件名称</th>
                                
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody>
                        
                            <c:forEach items="${aList}" var="ad">
                            <tr>
                             
                                <td><%-- <input type="checkbox" id="${good.id }" class="check" value="${good.id }" name="checkGood"/> --%><label for="c1" class="label">${ad.id }</label></td>
                                <td>${ad.name}</td>

                                <td align="center">
                                				<input type="button" value="详情" class="btn" onClick="showDetail('${ad.id}','${ad.name }')"><input type="button" value="删除" class="btn"onclick="delAds('${ad.id}')">
					                            <div id="showDetail${ad.id }" style="display:none;">
					                        	<table class="table" cellspacing="0" cellpadding="0">
					                        		<tr>
					                        			<td width="20%" align="right">广告id</td>
					                        			<td>${ad.id }</td>
					                        		</tr>
					                        		<tr>
					                        			<td width="20%"  align="right">文件名称</td>
					                        			<td>${ad.name }</td>
					                        		</tr>
					          
					
					                        		<tr>
					                        			<td width="20%"  align="right">商品图片</td>
					                        			<td>
					                        			
					                        			<img width="100" height="100" src="pictures/${ad.name}" alt=""/> &nbsp;&nbsp;
					                        			
					                        			</td>
					                        		</tr>
					                        		
					                  
					                        	</table>

					                        	
					                        </div>
                                
                                </td>
                            </tr>
                            </c:forEach>
                           
                        </tbody>
                    </table>
                    </form>
                    
                    
                </div>

</body>
</html>
