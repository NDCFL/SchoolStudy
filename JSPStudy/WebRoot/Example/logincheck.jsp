<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'logincheck.jsp' starting page</title>
  </head>
  <body>
	<%
		String name=request.getParameter("username");
		String pass=request.getParameter("pass");
		if(name.equals("cfl") && pass.equals("cfl,1997")){
			//response.sendRedirect("sess.jsp?name="+name);
			//<jsp:forward page="sess.jsp">
				//<jsp:param name="use" value="1"/>
				//<jsp:param name="use2" value="2"/>
			//</jsp:forward>
	%>
			
	<%
			try{
				
				Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}
	
	%>
			<jsp:include page="./index.jsp"></jsp:include>
	<% 
			
			
		}else{
			//response.sendRedirect("filed.jsp");
			//<jsp:forward page="filed.jsp"></jsp:forward>
	%>
			<jsp:include page="filed.jsp"></jsp:include>
	<%
			try{
				Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}
	%>
			<jsp:include page="login.jsp"></jsp:include>
	<%		
			
		}
	%>
  </body>
</html>
