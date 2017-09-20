<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="java.net.URLEncoder"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'cookiecheck.jsp' starting page</title>
    
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
    	String name=request.getParameter("username");
   		String pass=request.getParameter("password");
   		String num = request.getParameter("ck");
   		if(num!=null && num.equals("1")){
   			Cookie ck1 = new Cookie("user",URLEncoder.encode(name));
   			Cookie ck2 = new Cookie("password",URLEncoder.encode(pass));
   			response.addCookie(ck1);
   			response.addCookie(ck2);
   		}
   		out.println("name="+name+"<br/>");
   		out.println("pass="+pass+"<br/>");
   		out.println("ck="+num+"<br/>");
    %>
    
  </body>
</html>
