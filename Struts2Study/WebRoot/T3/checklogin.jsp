<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'checklogin.jsp' starting page</title>
    
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
  	<h1>xml的合法性的验证</h1>
    <s:form action="Login" method="post" namespace="/Action">
    	<s:textfield name="username" label="用户名称"/>
    	<s:password name="password" label="用户密码"/>
    	<s:textfield name="age" label="用户年龄"/>
    	<s:textfield name="date" label="纪念日期"/>
    	<s:textfield name="cardid" label="身份证号"/>
    	<s:textfield name="email" label="邮箱地址"/>
    	<s:submit value="校对"></s:submit>
    </s:form>
  </body>
</html>
