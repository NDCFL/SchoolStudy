<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'studentadd.jsp' starting page</title>
  </head>
  <body>
  	<h1 align="center">学员的新增</h1>
  	<form action="<%=basePath %>studentservlet?order=add" method="post">
  		<table border="1" align="center">
  			<tr><th align="center">学员名字</th><td><input type="text" name="studentname"></td><td align="center"><font color="red" size="5">*必填名字</font></td></tr>
  			<tr><td align="center" colspan="3"><input type="submit" name="sub" value=" 确 认 新 增 "></td></tr>
  		</table>
  	</form>
  </body>
</html>
