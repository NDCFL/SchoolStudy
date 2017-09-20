<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'c_choose.jsp' starting page</title>
    
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
    <h1 align="center">标准便签函数库的choose使用</h1>
    <hr/>
    <c:forEach begin="0" end="8" var="index" step="2">
    	<c:choose>
    		<c:when test="${index == 1}">
    			one!<br/>
    		</c:when>
    		<c:when test="${index == 2}">
    			two!<br/>
    		</c:when>
    		<c:when test="${index == 3}">
    			three!<br/>
    		</c:when>
    		<c:when test="${index == 4}">
    			for!<br/>
    		</c:when>
    		<c:otherwise>
    			Hellow!<br/>
    		</c:otherwise>
    	</c:choose>
    </c:forEach>
  </body>
</html>
