<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="java.net.URLEncoder"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'cookiesave.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%
    	request.setCharacterEncoding("utf-8");
    	String name=request.getParameter("login");
    	String pwd=request.getParameter("pwd");
    	Cookie cookie[]=request.getCookies();
    	String num = request.getParameter("ck");
    	if(num!=null && num.equals("1")){
    		Cookie coo = new Cookie("name",URLEncoder.encode(name));
    		Cookie coo1 = new Cookie("pwd",URLEncoder.encode(pwd));
    		response.addCookie(coo);
    		response.addCookie(coo1);
    	}
    %>
  </body>
</html>
