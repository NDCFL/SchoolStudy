<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="struts.form.StrutsformForm"%>
<%@ taglib prefix="html"  uri="http://struts.apache.org/tags-html"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>登录成功</title>
  </head>
  <body>
  <%
  	StrutsformForm form = (StrutsformForm)request.getAttribute("strutsformForm");
  %>
    <h1 align="center">登录成功！欢迎你！<font color="blue"><%=form.getUsername() %></font>来到本站</h1>
  </body>
</html>
