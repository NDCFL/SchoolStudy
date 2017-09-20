<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>request对象的使用</title>
    
  </head>
  
  <body>
	<h1 align="center">request对象的使用</h1>
	<hr color="blue" size="5px"/>
	<h2 align="center">字符类型：<%=request.getCharacterEncoding() %></h2>
	<h2 align="center">本机的地址：<%=request.getLocalAddr() %></h2>
	<h2 align="center">本机的机名：<%=request.getLocalName() %></h2>
	<h2 align="center">本机的端口：<%=request.getLocalPort() %></h2>
	<h2 align="center">本机：<%=request.getLocale() %></h2>
	<h2 align="center">真实路径：<%=request.getRealPath("/") %></h2>
	<h2 align="center">客户端的地址：<%=request.getRemoteAddr() %></h2>
	<h2 align="center">客户端的主机：<%=request.getRemoteHost() %></h2>
	<h2 align="center">客户端的端口：<%=request.getRemotePort() %></h2>
	<h2 align="center">客户端的用户名：<%=request.getRemoteUser() %></h2>
	<h2 align="center">请求得URL：<%=request.getRequestURL() %></h2>
	<h2 align="center">请求的session对象的编号：<%=request.getRequestedSessionId() %></h2>
	<h2 align="center">得到相对的地址：<%=request.getServletPath() %></h2>
	<h2 align="center">真实的URL：<%=request.getRequestURL() %></h2>
	
  </body>
</html>
