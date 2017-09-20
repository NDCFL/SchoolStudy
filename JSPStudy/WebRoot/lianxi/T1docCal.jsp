<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'T1docCal.jsp' starting page</title>
    
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
  <h1 align="center">计算器</h1>
  <hr />
  <%
  		int num3=0;
  		int num1=0;
  		int num2=0;
  		int s =0;
		if(request.getParameter("sub")!=null){
			num1=Integer.parseInt(request.getParameter("num1"));
			num2=Integer.parseInt(request.getParameter("num2"));
			s =Integer.parseInt((request.getParameter("se")));
			switch(s){
				case 1:
					num3=num1+num2;	
					break;
				case 2:
					num3=num1-num2;	
					break;
				case 3:
					num3=num1*num2;	
					break;
				case 4:
					num3=num1/num2;	
					break;
				case 5:
					num3=num1%num2;	
					break;
			}
		}
	%>
	<form action="./lianxi/T1docCal.jsp">
		<div>
		<input type="text" name="num1" value="<%=num1 %>">
		<select name="se" value="<%=s %>">
			<option value="1" name="op">+</option>
			<option value="2" name="op">-</option>
			<option value="3" name="op">*</option>
			<option value="4" name="op">/</option>
			<option value="5" name="op">%</option>
		</select>
		<input type="text" name="num2"value="<%=num2 %>">
		<input type="submit" name="sub" value="=">
		<input type="text" name="num3"value="<%=num3 %>">
		</div>
	</form>
	
  </body>
</html>
