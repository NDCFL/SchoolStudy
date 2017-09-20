<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'sum2.jsp' starting page</title>
    
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
   
	    String s = request.getParameter("inp");
		if(s==null)
			s="1";
		int p = Integer.parseInt(s);
		int sum=0,count=0;
		out.println("1~"+p+"之间的素数有"+"<br/>");
		for(int i=2;i<=p;i++){
			sum=0;
			for(int j=2;j<i;j++){
				if(i%j==0){
					sum=1;
					break;
				}
				
			}
			if(sum==0){
				out.println(i+"&nbsp;&nbsp;&nbsp;&nbsp;");
				count++;
				if(count%5==0){
					out.println("<br/>");
					
				}
			}
		}
		
   
   %>
  </body>
</html>
