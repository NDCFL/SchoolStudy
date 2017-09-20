<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'checksum.jsp' starting page</title>
    
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
			int  num = (Integer)session.getAttribute("num");
			int sum=0;
			if(num!=0){
		%>
			<h1>欢迎选择重定向！！！1</h1>
		<%
				for(int i=1;i<=num;i++){
					sum+=i;
				}
				out.println("1~"+num+"的和为："+sum+"<br/>");
				
			}else{
		%>
				<h1>欢迎选择转发！！！1</h1>
		<%
				
			}
		%>
  </body>
</html>
