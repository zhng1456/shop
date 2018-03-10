<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function editCate(id){
		window.location="editType.do?id="+id;
	}
	function delCate(id){
		if(window.confirm("您确定要删除吗？删除之后不能恢复哦！！！")){
			window.location="deleteType.do?id="+id;
		}
	}
	function addCate(){
		window.location="addType.jsp";
	}
</script>
</head>
<body>
<div class="details">
                    <div class="details_operation clearfix">
                        <!-- <div class="bui_select">
                            <input type="button" value="添&nbsp;&nbsp;加" class="add"  onclick="addCate()">
                        </div> -->
                            
                    </div>
                    <!--表格-->
                    <table class="table" cellspacing="0" cellpadding="0">
                        <thead>
                            <tr>
                            	<th>选择</th>
                                <th >分类名称</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody>
                                <!--这里的id和for里面的c1 需要循环出来-->
                                <c:forEach items="${list}" var="type">
                                <tr>
                                <td><input type="checkbox" name="typeId" value="${type.id}"></td>
                                <td>${type.name}</td>
                                <td align="center"><input type="button" value="修改" class="btn" onClick="editCate('${type.id}')"><input type="button" value="删除" class="btn"  onclick=""></td>
                                </tr>
                                </c:forEach>
                                <!-- <td><input type="checkbox" id="c1" class="check"><label for="c1" class="label">1</label></td>
                                <td>bbbbbb</td>
                                <td align="center"><input type="button" value="修改" class="btn" onClick=""><input type="button" value="删除" class="btn"  onclick=""></td> -->
                            <tr>
                            	<td colspan="4">第1页，共2页</td>
                            </tr>
                        </tbody>
                    </table>
                </div>

</body>
</html>