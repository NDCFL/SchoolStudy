<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="Listener.SessionListener"%>
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
   <%
   	String username = request.getParameter("username");
   %>
  <h1 align="center">欢迎来到本网站<font color="blue" face="华文行楷" size="7">当前在线人数为：<%=SessionListener.count%> 人</font></h1>
  <%
  	session.setAttribute("昵称",username);
  out.println(username);
  %>
  <a href="T9doc/Exit.jsp">安全退出</a>
  </body>
</html>
