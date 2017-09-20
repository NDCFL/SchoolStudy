<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="t" uri="/myselftag" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'checklogin.jsp' starting page</title>
	<meta http-equiv="Refresh" content="3;url=checklogin.jsp">
  </head>
   <body>
   <t:FontTagDemo>欢迎<%=request.getParameter("username") %>登录</t:FontTagDemo>
   <hr color="blue" size="5px"/>
   <h2 align="center">昵称：<%=request.getParameter("username") %></h2>
   <h2 align="center">密码：<%=request.getParameter("userpassword") %></h2>
  </body>
</html>
