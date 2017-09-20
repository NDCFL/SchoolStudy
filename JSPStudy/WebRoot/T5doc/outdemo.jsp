<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'outdemo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
    <h1 align="center">out对象的使用</h1>
    <%
    	out.println("out对象的使用");
    	int sumbuffer = out.getBufferSize();//得到总的缓存
    	int srcbuffer = out.getRemaining();//得到当前剩余的缓存
    	int overplus = sumbuffer-srcbuffer;//得到使用了的缓存大小
    %>
    总缓存：<%=sumbuffer %>byte<br/>
	剩余的缓存：<%=srcbuffer %>byte<br/>
	使用的缓存：<%=overplus %>byte
  </body>
</html>
