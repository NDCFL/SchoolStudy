<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%
	String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url = "jdbc:sqlserver://localhost:1433;databasename=jsp";
	String username="sa";
	String password="123456";
	Class.forName(driver);
	Connection con = DriverManager.getConnection(url,username,password);
	Statement st = con.createStatement();
%>