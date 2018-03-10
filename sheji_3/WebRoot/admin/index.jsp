<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>主页</title>
<link rel="stylesheet" href="style/backstage.css">
<script type="text/javascript">
function show(num,change){
		var menu=document.getElementById(num);
		var change=document.getElementById(change);
		if(change.innerHTML=="+"){
				change.innerHTML="-";
    	}else{
				change.innerHTML="+";
        }
	   if(menu.style.display=='none'){
             menu.style.display='';
	    }else{
	         menu.style.display='none';
	    }
}
</script>
</head>

<body>
    <div class="head">
            <div class="logo fl"><a href="#"></a></div>
            <h3 class="head_text fr">电子商务后台管理系统</h3>
    </div>
    <div class="operation_user clearfix">
        <!-- <div class="link fl"><a href="#">慕课</a><span>&gt;&gt;</span><a href="#">商品管理</a><span>&gt;&gt;</span>商品修改</div> -->
        <div class="link fr">
            <a href="#" class="icon icon_i">首页</a><span></span><a href="#" class="icon icon_j">前进</a><span></span><a href="#" class="icon icon_t">后退</a><span></span><a href="#" class="icon icon_n">刷新</a><span></span><a href="#" class="icon icon_e">退出</a>
        </div>
    </div>
    <div class="content clearfix">
        <div class="main">
            <!--右侧内容-->
            <div class="cont">
                <div class="title">后台管理</div>
      	 		<!-- 嵌套网页开始 -->         
                <iframe src="main.jsp"  frameborder="0" name="mainFrame" width="100%" height="522"></iframe>
                <!-- 嵌套网页结束 -->   
            </div>
        </div>
        <!--左侧列表-->
        <div class="menu">
            <div class="cont">
                <div class="title">管理员</div>
                <ul class="mList">
                    <li>
                        <h3><span onClick="show('menu1','change1')" id="change1">+</span>商品管理</h3>
                        <dl id="menu1" style="display:none;">
                        	<dd><a href="../TypeController/PrepareForGood.do" target="mainFrame">添加商品</a></dd>
                            <dd><a href="../GoodController/selectPageGood.do?currentPage=1" target="mainFrame">商品列表</a></dd>
                        </dl>
                    </li>
                    <li>
                        <h3><span onClick="show('menu2','change2')" id="change2">+</span>分类管理</h3>
                        <dl id="menu2" style="display:none;">
                        	<dd><a href="addType.jsp" target="mainFrame">添加分类</a></dd>
                            <dd><a href="../TypeController/selectPageType.do?currentPage=1" target="mainFrame">分类列表</a></dd>
                        </dl>
                    </li>
                    <li>
                        <h3><span  onclick="show('menu3','change3')" id="change3" >+</span>订单管理</h3>
                        <dl id="menu3" style="display:none;">
                            <dd><a href="../OrderController/selectAllOrder.do?currentPage=1" target="mainFrame">查看订单</a></dd>
                        </dl>
                    </li>
                    <!-- <li>
                        <h3><span onClick="show('menu4','change4')" id="change4">+</span>用户管理</h3>
                        <dl id="menu4" style="display:none;">
                        	<dd><a href="addUser.jsp" target="mainFrame">添加用户</a></dd>
                            <dd><a href="listUser.jsp" target="mainFrame">用户列表</a></dd>
                        </dl>
                    </li> -->
                    <!-- <li>
                        <h3><span onClick="show('menu5','change5')" id="change5">+</span>管理员管理</h3>
                        <dl id="menu5" style="display:none;">
                        	<dd><a href="addAdmin.jsp" target="mainFrame">添加管理员</a></dd>
                            <dd><a href="../AdminController/selectAdmin.do" target="mainFrame">管理员列表</a></dd>
                        </dl>
                    </li> -->
                    
                         <li>
                        <h3><span onClick="show('menu6','change6')" id="change6">+</span>主页图片管理</h3>
                        <dl id="menu6" style="display:none;">
                            <dd><a href="../GoodController/selectPageGoodForFeatured.do?currentPage=1" target="mainFrame">特色商品管理</a></dd>
                            <dd><a href="../AdsController/selectAds.do" target="mainFrame">顶部广告管理</a></dd>
                            <dd><a href="addAds.jsp" target="mainFrame">添加广告图片</a></dd>
                        </dl>
                    </li>
                    <li>
                        <h3><span onClick="show('menu7','change7')" id="change7">+</span>统计</h3>
                        <dl id="menu7" style="display:none;">
                            <dd><a href="../OrderController/selectSalesByYear.do?year=2017" target="mainFrame">销售额查询</a></dd>
                        </dl>
                    </li>
                </ul>
            </div>
        </div>

    </div>
</body>
</html>