<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'privacedel.jsp' starting page</title>
    
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
  <jsp:useBean id="ue" class="T7.SQL"></jsp:useBean>
    <%
    	request.setCharacterEncoding("utf-8");
   		Class.forName(ue.getDriver());
   		Connection con = DriverManager.getConnection(ue.getUrl(),ue.getUsername(),ue.getPassword());
   		Statement st = con.createStatement();
   		st.executeUpdate("delete shop where id="+request.getParameter("id"));
   		st.close();
		con.close();
   		response.sendRedirect("shopselect.jsp");
   	%>
  </body>
</html>
