<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>过滤非法字符</title>
  </head>
  <body>
    <h1 align="center">过滤非法字符</h1>
    <hr/>
    <s:form action="LuntanAction.action" method="post">
    	<s:textfield name="title" style="width:400px" label="标题"></s:textfield>
    	<s:textarea name="content" style="width:400px;height:200px" label="内容"></s:textarea>
    	<s:submit value="发布博客"></s:submit>
    </s:form>
  </body>
</html>
