<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'SQL.jsp' starting page</title>
  </head>
  <body>
  <h1>数据库的连接</h1>
  <%
	  	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url="jdbc:sqlserver://localhost:1433;databasename=access";
		String username="sa";
		String password="123456";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection co = DriverManager.getConnection(url,username,password);
			PreparedStatement ps = co.prepareStatement("select * from student");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				out.println(rs.getInt(1)+"\t"+rs.getString(2)+"<br/>");
			}
			ps.close();
			co.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
  %>
  </body>
</html>
