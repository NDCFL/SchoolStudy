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
		<title>第一个自定义的标签使用</title>
	</head>
	<body>
		<h1 align="center">第一个自定义的标签使用</h1>
		<hr color="blue" size="5px"/>
			<t:HellowTag/>
		<hr color="blue" size="5px"/>
		<t:FontTagDemo>今天天气挺好呀！</t:FontTagDemo>
		<hr color="blue" size="5px"/>
		<t:HellowTag/>
		<hr color="blue" size="5px"/>
		<h1 align="center">九九乘法表</h1>
		<hr color="blue" size="5px"/>
		<t:MathTagDemo count="9">
		
		</t:MathTagDemo>
		<hr/>
	</body>
</html>
