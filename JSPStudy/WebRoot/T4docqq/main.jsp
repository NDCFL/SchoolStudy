<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>龙龙聊天室主页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
    <frameset rows="64%,36%" border="0">
      <frameset cols="65%,35%"  border="0"> 
          <frame src="T4docqq/left.jsp" name="left" />
          <frame src="T4docqq/right.jsp" name="right" />
      </frameset>
      <frameset  border="0">
          <frame src="T4docqq/button.jsp" name="bottom" />
      </frameset>
    </frameset>
</html>
