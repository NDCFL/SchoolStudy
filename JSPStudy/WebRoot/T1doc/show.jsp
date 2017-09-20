<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'show.jsp' starting page</title>
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
		<h1>运行的结果是：</h1>
	<%
		int num1=Integer.parseInt(request.getParameter("num1")); 
		int num2=Integer.parseInt(request.getParameter("num2")); 
		int re = Integer.parseInt(request.getParameter("se1"));
		int result=0;
		switch(re){
			case 1:
				result = num1+num2;
				out.println(num1+"+"+num2+"="+result);
				break;
			case 2:
				result = num1-num2;
				out.println(num1+"-"+num2+"="+result);
				break;
			case 3:
				result = num1*num2;
				out.println(num1+"*"+num2+"="+result);
				break;
			case 4:
				result = num1/num2;
				out.println(num1+"/"+num2+"="+result);
				break;
		}
		
	%>
  </body>
</html>
