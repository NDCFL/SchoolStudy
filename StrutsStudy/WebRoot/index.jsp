<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="html"  uri="http://struts.apache.org/tags-html"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html>
  <head>
    <base href="<%=basePath%>">
    <title>struts登录</title>
  </head>
  <body>
    <h1 align="center">struts框架登录事例</h1>
    <hr/>
    <html:form action="/strtusaction.do" method="post">
    	用户名：<html:text  name="strutsformForm" property="username"/><br/><br/>
    	密码：<html:password  name="strutsformForm" property="password"/><br/><br/>
    	<input  name="bt" type="submit" value="登录"/><br/><br/>
    </html:form>
  </body>
</html:html>
