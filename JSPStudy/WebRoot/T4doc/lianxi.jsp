<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'lianxi.jsp' starting page</title>
  </head>
  
  <body>
    <%
    	String name = request.getParameter("username");
    	String pass = request.getParameter("pass");
    	ArrayList list = new ArrayList();
    	if(application.getAttribute("count")==null){
    		list.add(name);
    		application.setAttribute("count",list);
    		response.sendRedirect("show.jsp");
    	}else{
    		list=(ArrayList)application.getAttribute("count");
    		list.add(name);
    		application.setAttribute("count",list);
    		response.sendRedirect("show.jsp");
    	}
    %>
   
  </body>
</html>
