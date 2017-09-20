<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>软件使用意见反馈</title>
    
  </head>
  
  <body>
   <table border="0" align="center" bgColor="pink" width="500" height="400">
		   <tr><td><h1 align="center">软件使用意见反馈</h1></td></tr>
	<tr><td >
	<%
   		request.setCharacterEncoding("utf-8");
	%>
	</td></tr>
	
	<tr><td>
	<%
   		out.println("姓名："+request.getParameter("username")+"<br/>");
	%>
	</td></tr>
	
	<tr><td>
	<%
   		out.println("E_mail："+request.getParameter("email")+"<br/>");
	%>
	</td></tr>
	
	<tr><td>
	<%
   		out.println("软件名称："+request.getParameter("mingcheng")+"<br/>");
	%>
	</td></tr>
	
	<tr><td>
	<%
   		out.println("电话："+request.getParameter("tel")+"<br/>");
	%>
	</td></tr>
	
	<tr><td>
	<%
   		out.println("操作系统："+request.getParameter("xt")+"<br/>");
	%>
	</td></tr>
	
	<tr><td>
	<%
   		out.println("回馈时间："+request.getParameter("shijian")+"<br/>");
	%>
	</td></tr>
	
	<tr><td>
   	<%
   		out.println("回馈描述："+request.getParameter("imfo")+"<br/>");
   %>
 </td></tr>
   </table>
  </body>
</html>
