<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'juxing.jsp' starting page</title>
    
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
	  <table border="1" width="210" height="150" align="center"> 
	    <%
	    	out.println("<tr><td>1</td><td>2</td><td>3</td></tr>");
		    out.println("<tr><td>4</td><td>5</td><td>6</td></tr>");
		    out.println("<tr><td>7</td><td>8</td><td>9</td></tr>");
		    out.println("现在时间："+new Date().toLocaleString());
	    	
	    %>
	   </table>
  </body>
</html>
