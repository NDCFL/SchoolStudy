<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="t" uri="/myselftag" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>登录信息</title>
	</head>
	<body>
		<t:FontTagDemo>登录界面</t:FontTagDemo>
		<t:LoginTagDemo></t:LoginTagDemo>
	</body>
</html>
