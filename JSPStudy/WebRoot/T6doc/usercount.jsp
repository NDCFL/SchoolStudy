<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="T6.Countbean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'usercount.jsp' starting page</title>
  </head>
  <body>
	<h1 align="center">访问本网站人数统计</h1>
	<hr color="blue" size="5"/>
	<jsp:useBean id="use" class="T6.Countbean" scope="request">
		<jsp:setProperty name="use" property="*"/>
	</jsp:useBean>
	<jsp:useBean id="use1" class="T6.Countbean" scope="application">
		<jsp:setProperty name="use1" property="*"/>
	</jsp:useBean>
	<h2 align="center">尊敬的<font size="7" face="华文行楷" color="blue"><%=new String(use.getName().getBytes("iso-8859-1"),"utf-8") %></font>你好!欢迎来到本网站，你是第<font size="7" face="华文行楷" color="blue"><jsp:getProperty  name="use1" property="count"/></font>位访问本网站的人！！
  </body>
</html>
