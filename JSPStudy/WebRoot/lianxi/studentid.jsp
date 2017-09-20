<%@ page language="java" import="java.util.*" pageEncoding="utf-8" errorPage="iserror.jsp"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'studentid.jsp' starting page</title>
    
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
  <%
  	request.setCharacterEncoding("utf-8");
  
  %>
    <jsp:useBean id="bean" class="T6.Entrybean">
    	<jsp:setProperty name="bean" property="*"/>
    	
    </jsp:useBean>
    <jsp:useBean id="sql" class="T7.SQL"></jsp:useBean>
    <%
    	Class.forName(sql.getDriver());
    	Connection con = DriverManager.getConnection(sql.getUrl(),sql.getUsername(),sql.getPassword());
    	Statement st = con.createStatement();
    	String string = "";
    	for(int i=0;i<bean.getHobit().length;i++){
    		if(i==bean.getHobit().length-1){
    			string+=bean.getHobit(i);
    		}else{
    			string+=bean.getHobit(i)+",";
    		}
    	}
    	String str = "insert into entry values ('"+request.getParameter("name")+"','";
    	str+=request.getParameter("pass1")+"','";
    	str+=request.getParameter("pass2")+"','";
    	str+=request.getParameter("sex")+"','";
    	str+=request.getParameter("age1")+"','";
    	str+=request.getParameter("gread")+"','";
    	str+=string+"','";
    	str+=request.getParameter("province")+request.getParameter("city")+request.getParameter("county")+"')";
    	st.executeUpdate(str);
    	out.println("<h1 align='center'><font face='华文行楷' color='blue'>恭喜你！报名成功！</font></h1>");
    %>
    
  </body>
</html>
