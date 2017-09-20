<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录信息的录入</title>
  </head>
  <body>
	  <%
	  	request.setCharacterEncoding("utf-8");
	  %>
		昵称：<%out.println(request.getParameter("login"));%><br/>   
		密码：<%out.println(request.getParameter("pwd"));%><br/>
		session对象昵称:<%=session.getAttribute("name") %><br/>  
		session对象密码:<%=session.getAttribute("pwd") %> <br/> 
		application对象昵称:<%=application.getAttribute("name") %> <br/> 
		application对象密码:<%=application.getAttribute("pwd") %> <br/> 
  </body>
</html>
