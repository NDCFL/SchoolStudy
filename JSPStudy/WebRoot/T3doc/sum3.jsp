<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>1~N之间的阶层值</title>
  </head>
  
  <body>
    <%
    	String N = request.getParameter("text1");
		if(N==null){
			N="0";
		}
		int n = Integer.parseInt(N);
    	out.println("1~"+n+"之间的阶层值为"+"<br/>");
    	long sum = 1;
    	for(int i=1;i<=n;i++){
    		sum*=i;
    	}
    	out.println(sum);
    %>
  </body>
</html>
