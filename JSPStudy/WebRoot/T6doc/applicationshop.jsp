<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'applicationshop.jsp' starting page</title>
    
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
  	<h1 align="center">欢迎来到龙龙商品店</h1>
    <hr color="blue" size="3px"/>
	<%
		int a1=300,a2=400,a3=500;
		double p1=30.2,p2=45.9,p3=86.5;
		String s1="java",s2="jsp",s3="js";
		if(application.getAttribute("a1")==null){
			a1=300;
			
		}else{
			
			a1=(Integer)application.getAttribute("a1");
		}
		if(application.getAttribute("a2")==null){
			a2=400;
			
		}else{
			a2=(Integer)application.getAttribute("a2");
		}
		if(application.getAttribute("a3")==null){
			a3=500;
			
		}else{
			a3=(Integer)application.getAttribute("a3");
		}
	%>
	<form name="form1" action="T6doc/sessionshop.jsp" method="post">
		<table border = "1" align="center">
			<tr align="center"><th>商品名称</th><th>价格(元)</th><th>库存量(本)</th><th>购买数量(本)</th></tr>
			<tr align="center"><td><%=s1 %></td><td><%=p1%></td><td><%=a1%></td><td><input type="text" name="txt" ></td></tr>
			<tr align="center"><td><%=s2%></td><td><%=p2%></td><td><%=a2%></td><td><input type="text" name="txt1" ></td></tr>
			<tr align="center"><td><%=s3%></td><td><%=p3%></td><td><%=a3%></td><td><input type="text" name="txt2" ></td></tr>
			<tr align="center"><td colspan="4" ><input type="submit" name="sub" value="  下  单  "></td></tr>
		</table>
	</form>
	<%
		application.setAttribute("a1",a1);
		application.setAttribute("a2",a2);
		application.setAttribute("a3",a3);
		application.setAttribute("p1",p1);
		application.setAttribute("p2",p2);
		application.setAttribute("p3",p3);
		String username=request.getParameter("username");
		session.setAttribute("username",username);
	%>
 
  </body>
</html>
