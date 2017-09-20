<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'logincount.jsp' starting page</title>
  </head>
  <body>
    <h1>计算登录用户的人数个数</h1>
    <hr color="blue" size="5px">
    <%
    	int count=1;
    	if(application.getAttribute("count")==null){
    		application.setAttribute("count",1);
    	}else{
    		count = Integer.parseInt(application.getAttribute("count").toString());
    		count++;
    		application.setAttribute("count",count);
    	}
    %>
    访问网站人数:<%=count %>
  </body>
</html>
