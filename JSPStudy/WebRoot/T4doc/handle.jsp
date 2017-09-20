<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'handle.jsp' starting page</title>
  </head>
  
  <body>
  <%! 
  	int i=0;
  %>
   <%
   		request.setCharacterEncoding("utf-8");
   		String name=request.getParameter("username");
   		String pass=request.getParameter("pass");
   		session.setAttribute("name",name);
   		session.setAttribute("pass",pass);
   		out.println("昵称："+name+"<br/>");	
   		out.println("密码："+pass+"<br/>");	
   		ArrayList list = new ArrayList();
   		if(application.getAttribute("list")==null){
	   		list.add(name);
   			application.setAttribute("list",list);
   	    	response.sendRedirect("show.jsp");
   		}else{
   			list = (ArrayList)application.getAttribute("list");
   			list.add(name);
   			response.sendRedirect("show.jsp");
   		}
   		
   %>
   
  </body>
</html>
