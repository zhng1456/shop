<%@page import="com.hzyc.practice.models.Page"%>
<%@page import="com.hzyc.practice.models.Good"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
function showDetail(id,t){
	$("#showDetail"+id).dialog({
		  height:"auto",
	      width: "auto",
	      position: {my: "center", at: "center",  collision:"fit"},
	      modal:false,//是否模式对话框
	      draggable:true,//是否允许拖拽
	      resizable:true,//是否允许拖动
	      title:"商品名称："+t,//对话框标题
	      show:"slide",
	      hide:"explode"
	});
}
	function addPro(){
		window.location='admin/addPro.jsp';
	}
	function editPro(id){
		window.location="GoodController/editGood.do?id="+id;
	}
	function delPro(id){
		if(window.confirm("您确认要删除嘛？添加一次不易，且删且珍惜!")){
			window.location="GoodController/downGood.do?id="+id;
		}
	}
	function search(){
		if(event.keyCode==13){
			var val=document.getElementById("search").value;
			
			window.location="GoodController/selectGoodByNameForFeatured.do?name="+encodeURI(encodeURI(val));
		}
	}
	//输入第几页，进行跳转
		function turn(){
		//取到表单
		var form =document.getElementById("mainForm");
		//取到输入的页数
		var page=document.getElementById("myPage").value;
		//绝对路径
		form.action="http://localhost:8080/sheji_3/GoodController/selectPageGoodForFeatured.do?currentPage="+page;
		//提交
		form.submit();
		}
		//将某个商品设置为特色商品
		function setFeatured(id){
			window.location="http://localhost:8080/sheji_3/GoodController/setFeatured.do?id="+id;
		}
		//取消某个商品的特色商品
		function cancelFeatured(id){
		window.location="http://localhost:8080/sheji_3/GoodController/cancelFeatured.do?id="+id;
		}
</script>
  </head>
  
  <body>
<div id="showDetail"  style="display:none;">

</div>
<div class="details">
                    <div class="details_operation clearfix">
                        <div class="bui_select">
                            <input type="button" value="添&nbsp;&nbsp;加" class="add" onClick="addPro()">
                        </div>
                        <div class="fr">
                            <div class="text">
                                <span>搜索</span>
                                <input type="text" value="" class="search"  id="search" onKeyPress="search()" >
                            </div>
                        </div>
                    </div>
                    <!--表格-->
                    <form action="" id="mainForm" method="post" enctype="application/x-www-form-urlencoded">
                    <table class="table" cellspacing="0" cellpadding="0">
                        <thead>
                            <tr>
                                <th width="10%">编号</th>
                                <th width="20%">商品名称</th>
                                <th width="10%">特色商品</th>
                                
                                <th width="10%">价格</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody>
                        
                            <c:forEach items="${list}" var="good">
                            <tr>
                             
                                <td><%-- <input type="checkbox" id="${good.id }" class="check" value="${good.id }" name="checkGood"/> --%><label for="c1" class="label">${good.id }</label></td>
                                <td>${good.name}</td>
                                <td><c:if test="${good.featured==0 }">否</c:if><c:if test="${good.featured==1 }">是</c:if></td>
                                  <td>${good.price }</td>
                                <td align="center">
                                				<input type="button" value="详情" class="btn" onClick="showDetail('${good.id}','${good.name }')"><c:if test="${good.featured==0 }"><input type="button" value="设置" class="btn" onClick="setFeatured('${good.id}')"></c:if><c:if test="${good.featured==1 }"><input type="button" value="取消" class="btn" onClick="cancelFeatured('${good.id}')"></c:if>
					                            <div id="showDetail${good.id }" style="display:none;">
					                        	<table class="table" cellspacing="0" cellpadding="0">
					                        		<tr>
					                        			<td width="20%" align="right">商品名称</td>
					                        			<td>${good.name }</td>
					                        		</tr>
					                        		<tr>
					                        			<td width="20%"  align="right">商品类别</td>
					                        			<td>${good.type.name }</td>
					                        		</tr>
					          
					                        		<tr>
					                        			<td width="20%"  align="right">商品数量</td>
					                        			<td>${good.number}</td>
					                        		</tr>
					                        		<tr>
					                        			<td  width="20%"  align="right">商品价格</td>
					                        			<td>${good.price}</td>
					                        		</tr>
					                        		
					                        		<tr>
					                        			<td width="20%"  align="right">商品图片</td>
					                        			<td>
					                        			
					                        			<img width="100" height="100" src="pictures/${good.pictureName}" alt=""/> &nbsp;&nbsp;
					                        			
					                        			</td>
					                        		</tr>
					                        		
					                  
					                        	</table>

					                        	<span style="display:block;width:80%; ">
					                        	商品描述<br/>
					                        	${good.description}
					                        	</span>
					                        </div>
                                
                                </td>
                            </tr>
                            </c:forEach>
                           
                        </tbody>
                    </table>
                    </form>
                    <c:if test="${not empty page }">
                    <div class='page fix'>
							共 <b><%=myPage.getLength() %></b> 条
							<a href='GoodController/selectPageGoodForFeatured.do?currentPage=1' class='first'>首页</a>
							<a href='GoodController/selectPageGoodForFeatured.do?currentPage=<%=myPage.getBack() %>' class='pre'>上一页</a>
							当前第<span><%=myPage.getCurrentPage() %>/<%=myPage.getAllPage() %></span>页
							<a href='GoodController/selectPageGoodForFeatured.do?currentPage=<%=myPage.getNext() %>' class='next'>下一页</a>
							<a href='GoodController/selectPageGoodForFeatured.do?currentPage=<%=myPage.getAllPage() %>' class='last'>末页</a>
							跳至&nbsp;<input type='text' id="myPage" value='1' class='allInput w28' />&nbsp;页&nbsp;
							<a href='javascript:turn()' class='go'>GO</a>
						</div>
                    </c:if>
                    
                </div>

</body>
</html>
