<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>世界你好！！1</title>

  </head>
  
  <body>
    <%
    	out.println("hellow world!<br/>");
  		out.println("世界你好呀！！<br/>");
  		out.println("当前时间:toGMTString()"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+new Date().toGMTString()+"<br/>");
  		out.println("当前时间:toLocaleString()"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+new Date().toLocaleString()+"<br/>");
  		out.println("当前时间:toString()"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+new Date().toString()+"<br/>");
    %>
    
    
  </body>
</html>
