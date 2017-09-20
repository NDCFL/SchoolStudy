<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="T7.NumBean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>猜数字游戏</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
 	<jsp:useBean id="bean" class="T7.NumBean"></jsp:useBean>
     <form  name="form1" method="post">
		请输入数字(1-100):<input type="text" name="number" size="5"/> 
		<input type="submit" name="submit" value=" 确 定 "/>
	</form>
	<form  name="form2" method="post">
		<input type="hidden" name="reset" value="reset">
		<input type="submit" name="submit" value="新游戏"/>
	</form>
	<c:if test="${not empty param.reset}">
		<%bean.reset(); %>
	</c:if>
	<c:if test="${not empty param.number}">
		<c:if test="${param.number gt bean.value}">
			<%bean.src(); %>
			大了！
		</c:if>
		<c:if test="${param.number lt bean.value}">
			<%bean.src(); %>
			小了！
		</c:if>
		<c:if test="${param.number eq bean.value}">
			恭喜你！猜对了！
		</c:if>
	</c:if>
	
	
	
  </body>
</html>
