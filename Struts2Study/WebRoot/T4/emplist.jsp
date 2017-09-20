<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'emplist.jsp' starting page</title>
  </head>
  <body>
    <s:bean name="Vo.EmpVo" var="e">
    	<s:param name="jobDate" value="'2016-12-20'"></s:param>
    </s:bean>
    <s:date name="#e.jobDate"></s:date>
  </body>
</html>
