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
    
    <title>pay</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="js/jquery-1.11.3.min.js"></script>
    <style>
        body{
            font:normal 100% Helvetica, Arial, sans-serif;
            background-color: #F5F5F5;
        }
        #express{
            margin-top: 20px;
            text-align: center;
        }
        b{
            font-size: 1.5em;
        }
        #shzd{
            width:100%;
            height: 40px;
            background-color: #fff;
            line-height: 40px;
            border-bottom: 1px solid #E3E3E3;
            border-top: 1px solid #E3E3E3;

        }
        #shzd>span{
            color:#8B8B8B;
            margin-left: 10px;
        }
        #shzd>p{
            display: inline;
            padding-left: 25px;
        }
        #btn{
            font-size: 1.3em;
            width:90%;
            margin-left:5%;
            margin-top: 40px;
            border-radius: 3px;
            background:#1AAD19;
            color: #fff;
            height: 40px;
            border: none;
        }
        #money{
            font-size: 2em;
            text-align: center;
        }
    </style>
    <script type="text/javascript">
    function callpay(id){
    	window.location="OrderController/payOrder.do?id="+id;
    }
    </script>
  </head>
  
  <body>
<div id="main">
    <div id="express">
        <b>支付</b>
    </div>
    <div id="money">
        <p>${requestScope.cart.realTotal }￥<span id="amount"></span></p>
    </div>
    <div id="shzd">
        <span>收款方</span>
        <p>XXXXXX店铺</p>
    </div>
    <div >
        <button type="button" id="btn" onClick="callpay(${requestScope.cart.orderId })" >立即支付</button>
    </div>
</div>
</body>
</html>
