<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'huihua.jsp' starting page</title>
  </head>
  <body>
   <% 
	   	String name = new String( request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
	    session.setAttribute("name", name); out.println(name + "成功登陆");
   %>
   <a href="./Yufa/log.jsp"><br>跳转</a>
  </body>
</html>
