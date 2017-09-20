<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<jsp:useBean	id="buffer"	scope="page"	type="java.lang.StringBuffer"/>
	<%	
		buffer.append("ABC");
	%>
	buffer is <%=buffer%> 
	</html>

