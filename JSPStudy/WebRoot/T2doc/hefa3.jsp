<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'hefa.jsp' starting page</title>
  </head>
  <body>
    <%
    	String name=request.getParameter("username").toString();
    	String password=request.getParameter("pass");
    	if(name.equals("cfl") && password.equals("cfl,1997")){
			response.sendRedirect("sess.jsp?username="+name);
    	}else{
    		response.sendRedirect("filed.jsp");
    	}
    %>
    	
  </body>
</html>
