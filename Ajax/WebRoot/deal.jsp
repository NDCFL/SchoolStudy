<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.io.PrintWriter"%>
<%
	String num = request.getParameter("num");
	//PrintWriter out = response.getWriter();
	System.out.println("num="+num);
	out.print("收到num的值为"+num);
	out.flush();

%>