<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'getAttibutedemo.jsp' starting page</title>
  </head>
  <body>
     <h1>getAttibute对象的作用域</h1>
    <%
    	String name1=(String)pageContext.getAttribute("username");
    	String name2=(String)request.getAttribute("username");
   	 	String name3=(String)session.getAttribute("username");
    	String name4=(String)application.getAttribute("username");
    %>
    <hr color="blue"/>
     <%
	     String name_1=(String)pageContext.getAttribute("username",1);
	     String name_2=(String)request.getAttribute("username");
	     String name_3=(String) session.getAttribute("username");
	     String name_4=(String)application.getAttribute("username");
    %>
     <hr color="blue"/>
     <h1>getAttibute对象的结果</h1>
    <%
    	out.println(name1);
    
    %>
    <br/>
    <%
    	out.println(name2);
    
    %>
    <br/>
    <%
    	out.println(name3);
    
    %>
    <br/>
     <%
    	out.println(name4);
    
    %>
    <br/>
     <hr color="blue"/>
     <%
    	out.println(name_1);
    
    %>
    <br/>
    <%
    	out.println(name_2);
    
    %>
    <br/>
    <%
    	out.println(name_3);
    
    %>
    <br/>
     <%
    	out.println(name_4);
    
    %>
  </body>
</html>
