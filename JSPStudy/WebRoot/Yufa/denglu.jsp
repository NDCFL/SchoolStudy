<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'denglu.jsp' starting page</title>
  </head>
  <body>
   <form action="./Yufa/huihua.jsp" method="post"> 
		<table width="300" height="300" border="0" align="center">
		   <tr height="80" align="center">
		       <td colspan="2"><font size="24">QQ登录</font></td></tr>
		   <tr height="30">
		       <td width="80" align="right">用户名：</td>                          
		       <td><input type="text" name="name"></td></tr>
		   <tr height="30">
		       <td width="80" align="right"> 密&nbsp;&nbsp;码：</td>
		       <td> <input type="password" name="password"></td></tr>
		       <tr><td height="40" align="center" colspan="2">
		       <input type="submit" value="登录"></td></tr>
		 </table>
	</form>	 
  </body>
</html>
