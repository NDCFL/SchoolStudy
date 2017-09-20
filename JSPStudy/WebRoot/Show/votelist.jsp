<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'votelist.jsp' starting page</title>
    
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
    <h1 align="center">学生成绩表</h1>
    <hr color="blue" size="5px">
	<form action="<%=basePath %>voteservlet?order=list">
		<table align="center" border="1">
			<tr height="40"><th align="center">学生姓名</th><th align="center">学生分数</th></tr>
			<c:forEach items="${votelist}" var="v"> 
				<tr height="40"><td align="center">${v.studentname}</td><td align="center">${v.studentcount}</td></tr>
			</c:forEach>
		</table>
		<div style="text-align:center">
			<b>总记录数：${pager.barsum}条</b>&nbsp;&nbsp;&nbsp;&nbsp;
			<b>页    码：${pager.currentpage}/${pager.pagesum}页</b>
			<a href="<%=basePath %>voteservlet?order=list&handle=firstpage&currentpage=1">首   页</a>
			<a href="<%=basePath %>voteservlet?order=list&handle=uppage&currentpage=${pager.currentpage}">上 一 页</a>
			<a href="<%=basePath %>voteservlet?order=list&handle=downpage&currentpage=${pager.currentpage}">下 一 页</a>
			<a href="<%=basePath %>voteservlet?order=list&handle=lastpage&currentpage=${pager.pagesum}">尾   页</a>
		</div>
	</form>
  </body>
</html>
