<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title><s:text name="title"></s:text></title>
  </head>
  <body>
    <h1 align="center"><s:text name="title"></s:text></h1>
    <s:form action="LoginAction.action" method="post">
    	<s:textfield name="username" key="username" />
    	<s:textfield name="password" key="password"/>
    	<s:textfield name="address" key="address"/>
    	<s:checkboxlist name="hobit" key="hobit" list="#{'篮球':'篮球','足球':'足球','乒乓球':'乒乓球','排球':'排球'}" listKey="key" listValue="value" /><br/><br/>
    	<s:submit key="login"/>
    </s:form>
    <a href="<%=basePath %>LoginAction!say" >调用函数</a>
  </body>
</html>
