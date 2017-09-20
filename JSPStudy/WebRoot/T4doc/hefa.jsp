<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'hefa.jsp' starting page</title>
  </head>
  <body>
  <%
  	request.setCharacterEncoding("utf-8");
  %>
		getpatameter("username")=<%=request.getParameter("username") %>
		getpatameter("pass")=<%=request.getParameter("pass") %>   
	<hr color="blue" size="5px"/>
    	getAttibute("username")=<%=request.getAttribute("username") %>
		getpatameter("pass")=<%=request.getAttribute("pass") %>   
    <hr color="blue" size="5px"/>	
    	getAttributeNames("username")=<%=request.getAttributeNames().toString() %>
		getAttributeNames("pass")=<%=request.getAttributeNames().toString() %>   
  </body>
</html>
