<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'shoplist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function del1(){
			var num1 = document.getElementById("item1");
			var num_1 = document.getElementById("item_1");
			num1.innerHTML="";
			num_1.innerHTML="";
		}
		function del2(){
			var num2 = document.getElementById("item2");
			var num_2 = document.getElementById("item_2");
			num2.innerHTML="";
			num_2.innerHTML="";
		}
		function del3(){
			var num3 = document.getElementById("item3");
			var num_3 = document.getElementById("item_3");
			num3.innerHTML="";
			num_3.innerHTML="";
		}
		function del4(){
			var num4 = document.getElementById("item4");
			var num_4 = document.getElementById("item_4");
			num4.innerHTML="";
			num_4.innerHTML="";
		}
	</script>
  </head>
  
  <body style="">
    <h1 align="center">购物车</h1>
    <h3>请选择商品属性</h3>
    <hr/>
    <form action="T12doc/list.jsp" method="post" name="form1">
    	<table border="1" width="500">
    		<tr><th align="center">选择</th><th align="center">商品名称</th><th align="center">价格(元)</th></tr>
    		<tr><td  align="center" id="item1"><input type="checkbox" name="z" value="1"></td><td  align="center">《水浒传》</td><td id="item_1">45元</td></tr>
    		<tr><td  align="center" id="item1"><input type="checkbox" name="z" value="2"></td><td  align="center">《java使用手册》</td><td id="item_1">30元</td></tr>
    		<tr><td  align="center" id="item1"><input type="checkbox" name="z" value="3"></td><td  align="center">《jsp详解》</td><td id="item_1">60元</td></tr>
    		<tr><td  align="center" id="item1"><input type="checkbox" name="z" value="4"></td><td  align="center">《C语言大全》</td><td id="item_1">40元</td></tr>
    		<tr><td colspan="3" align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="加入购物车"style="width:90px;"></td></tr>
    	</table>
    </form>
  </body>
</html>
