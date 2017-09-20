<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'sess.jsp' starting page</title>
  </head>
  <body>
  <%
  		String str = request.getParameter("username");
  %>
    <h1 align="center">恭喜你!<%=str %>登录成功！</h1>
  </body>
</html>
