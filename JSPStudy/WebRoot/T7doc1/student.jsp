<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="T7.StudentBean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'student.jsp' starting page</title>
    
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
    <h1 align="center">优秀学员得票信息</h1>
    <%
    	List<StudentBean> list = (List<StudentBean>)request.getAttribute("list");
		StudentBean bean = null;
	%>
    <table border="1" align="center" width="300">
    	<tr><th align="center">优秀学员名称</th><th align="center">所得票数</th></tr>
    	<%
    		for(int i=0;i<list.size();i++){
    			bean = list.get(i);
    			out.println("<tr height='40'><td align='center'>"+bean.getStudentinf()+"</td><td align='center'>"+bean.getStudentcount()+"</td></tr>");
    		}
    	%>
    	<tr height="40"><td align="center" colspan="2"><a href="<%=basePath %>studentservlet?order=list">继续投票</a></td></tr>
    </table>
  </body>
</html>
