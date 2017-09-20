<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>servletAction的交汇</title>
  </head>
  <body>
    <h1 align="center">servletAction的交汇</h1>
    <hr/>
    request取值为：${name}<br/>
    session取值为：${username}<br/>
    application取值为：${user}<br/>
  </body>
</html>
