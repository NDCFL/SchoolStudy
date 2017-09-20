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
    <title>登录</title>
  </head>
  <body>
    <form action="LoginAction.action" method="post">
    	用户名：<s:textfield name="username"/><br/><br/>
    	密码：<s:textfield name="password"/><br/><br/>
    	<!-- struts2的标签库可以自动返回相应的值 -->
    	家庭住址：<s:textfield name="address"/><br/><br/>
    	爱好：<s:checkboxlist name="hobit" list="#{'篮球':'篮球','足球':'足球','乒乓球':'乒乓球','排球':'排球'}" listKey="key" listValue="value" /><br/><br/>
    	<input type="submit" value="登录"/>
    </form>
  </body>
</html>
