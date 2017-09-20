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
    <title>登录控制</title>
  </head>
  <body>
    <s:form action="TokenAction.action" method="post">
    	<input type="hidden" name="index" value="<%=new Random().nextInt(1000) %>">
    	<s:textfield name="username" label="用户名称"/>
    	<s:textfield name="password" label="用户密码"/>
    	<s:doubleselect name="province" label="省市联动" doubleList="top == '江西省'?{'章贡区','赣县'}:top == '湖南省'?{'襄阳'}:{'北京'}" list="{'江西省','湖南省','河北省'}" doubleName="city"></s:doubleselect>
    	<s:submit value="登录"></s:submit>
    </s:form>
  </body>
</html>
