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
	<a href="Quanxian!init.action">执行init函数</a>
	<a href="Quanxian!init1.action">执行init1函数</a>
	<a href="Quanxian!init2.action">执行init2函数</a>
	<a href="Quanxian!init3.action">执行init3函数</a>
	<a href="Quanxian!init4.action">执行init4函数</a>
  </body>
</html>
