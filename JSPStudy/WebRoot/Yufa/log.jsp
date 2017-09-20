<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'log.jsp' starting page</title>
  </head>
  <body>
    <%
	    String str = "";
	    Object obj = session.getAttribute("name");
	    if(obj != null){ 
	    	str = obj.toString();    
	    	out.println(str + "已经成功登陆");
	    }else{   
	    	out.println("会话超时，请重新登录。");
	    }
   %>
  </body>
</html>
