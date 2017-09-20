<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'meniu.jsp' starting page</title>
  </head>
  <body>
    <table width="600" height="80" align="center">
    	<tr>
    		<td>ppt展示</td>
    		<td>html网页</td>
    		<td>C语言</td>
    		<td>Java</td>
    		<td>JavaScript</td>
    		<td>Java server page</td>
    	</tr>
    </table>
    <hr color="blue" size="5px"/>
  </body>
</html>
