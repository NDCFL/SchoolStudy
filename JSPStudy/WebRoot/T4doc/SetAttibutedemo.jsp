<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>setAttibute对象的作用域</title>
    
  </head>
  
  <body>
    <h1>setAttibute对象的作用域</h1>
    <%
    	pageContext.setAttribute("username","絮落锦乡");
	    request.setAttribute("username","絮落锦乡1");
	    session.setAttribute("username","絮落锦乡2");
	    application.setAttribute("username","絮落锦乡3");
    %>
    <hr color="blue"/>
     <%
    	pageContext.setAttribute("username","絮落锦乡",1);
	    request.setAttribute("username","絮落锦乡1");
	    session.setAttribute("username","絮落锦乡2");
	    application.setAttribute("username","絮落锦乡3");
    %>
    <jsp:forward page="getAttibutedemo.jsp"/>
  </body>
</html>
