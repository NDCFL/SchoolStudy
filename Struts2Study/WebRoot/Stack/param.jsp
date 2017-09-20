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
    <title>别名的传参</title>
  </head>
  
  <body>
    <s:form action="FirstRenameAction.action" method="post">
    	<s:textfield name="srcname" label="参数"></s:textfield>
    	<s:submit value="提交"></s:submit>
    </s:form>
  </body>
</html>
