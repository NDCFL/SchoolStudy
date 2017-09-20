<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
	  <form name="form1" method='post' action="">
	    <table border='1' align='center' width='100%' height='600'>
	    	<tr><td colspan="2" height='80'><%@ include file="sess.jsp" %></td></tr>
	    	<tr>
		    	<td width='100'>
			    		<table width="150" align="center">
		    			<tr height='120'><td><a href="">注册界面</a></td></tr>
		    			<tr height='120'><td><a href="">登录界面</a></td></tr>
		    			<tr height='120'><td><a href="">图书馆界面</a></td></tr>
		    			<tr height='120'><td><a href="">运算界面</a></td></tr>
		    		</table>
		    	</td>
		    	<td><%@ include file="SQLcon.jsp" %>
		    	</td>
		    	</tr>
	    	<tr><td colspan="2"><marquee>版权所有不得盗版</marquee></td></tr>
	    </table>
	  </form>
  </body>
</html>
