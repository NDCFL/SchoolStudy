<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>权限的控制</title>
  </head>
  
  <body>
    <h1 align="center">权限的控制</h1>
    <hr/>
	<a href="FunctionAction!init.action"><h1 align="center">执行init函数</h1></a>
	<a href="FunctionAction!init1.action"><h1 align="center">执行init1函数</h1></a>
	<a href="FunctionAction!init2.action"><h1 align="center">执行init2函数</h1></a>
	<a href="FunctionAction!init3.action"><h1 align="center">执行init3函数</h1></a>
	<a href="FunctionAction!init4.action"><h1 align="center">执行init4函数</h1></a>
  </body>
</html>
