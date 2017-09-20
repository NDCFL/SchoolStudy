<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'check3.jsp' starting page</title>
    
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
   <h1>重定向和转发的测试</h1>
    <form method="post" name="form1" action="T5doc/check3.jsp">
	    <div><input type="radio" value="1" name="ra">选择重定向<br/></div>
		<div><input type="radio" value="2" name="ra">选择转发<br/></div>
		<div><input type="submit" value=" 确 定 " name="sub"></div>
	</form>
   <%
   		String num = request.getParameter("ra");
   		if(num!=null){
   			request.setAttribute("num","10");
   			if(num.equals("1")){
   				response.sendRedirect("checksum2.jsp");
   			}else{
   	%>
				<jsp:forward page="checksum2.jsp"/>
	<%			
   			}
   			
   		}
   %>
  </body>
</html>
