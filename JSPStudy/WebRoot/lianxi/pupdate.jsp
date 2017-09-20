<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'pupdate.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <body>
  <h1 align="center">省份的更新</h1>
  <form name="form1" action="<%=basePath %>pservlet?order=update" method="post">
  <input type="hidden" name="pid" value="<%=request.getParameter("pid") %>">
  	<table border="1" align="center" width="400">
  		<tr height="40"><th>省份名称</th><td><input type="text" name="pname" value="<%=new String(request.getParameter("pname").getBytes("iso-8859-1"),"utf-8") %>"></td><td><font size="5" color="red" >*必填</font></td></tr>
  		<tr><td colspan="3" align="center"><input type="submit" name="sub" value="  修  改 "></td></tr>
  	</table>
  </form>
  </body>
</html>
