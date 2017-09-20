<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'Shijian.jsp' starting page</title>
  </head>
  
  <body>
    <h1>星期天的学习计划</h1>
    <%
    	out.println("<html><head><title>星期天的学习计划</title></head><body>");
    	out.println("(上午)&nbsp;&nbsp;&nbsp;&nbsp;<a href=''>7:00~8:00</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href=''>8:30~10:30</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href=''>11:00~12:30</a>");
    	out.println("<br/>");
    	out.println("(下午)&nbsp;&nbsp;&nbsp;&nbsp;<a href=''>2:00~4:00&nbsp;&nbsp;&nbsp;&nbsp</a>;<a href=''>5:30~6:30</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href=''>其他时间</a>");
   		out.println("</body></html>");
    %>
  </body>
</html>
