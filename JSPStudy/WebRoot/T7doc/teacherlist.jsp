<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="Pool.TeacherBean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>教师分类览表</title>
    
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
  <h1 align="center"><font color="blue">教师分类览表</font></h1>
  <table align="center">
  	<tr><td><a href="T7doc/teacheradd.jsp"> 新 增</a></td></tr>
  </table>
    <%
	out.println("<table border='1' align='center' width='500'><tr height='40'><th align='center'>教师编号</th><th align='center'>教师名称</th><th align='center'>教师比重</th><th align='center'>操作</th></tr>");
	List<TeacherBean> list = (List<TeacherBean>)request.getAttribute("teacherlist");
	TeacherBean teacherbean = null;
	for(int i=0;i<list.size();i++){
		teacherbean=list.get(i);
		out.println("<tr height='40'><td align='center'>"+teacherbean.getTeacherid()+"</td><td align='center'>"+teacherbean.getTeachername()+"</td><td align='center'>"+teacherbean.getTeachergread()+"</td>");
	%>
		<td align="center">
		<a href="<%=basePath %>poolservlet?teacherid=<%=teacherbean.getTeacherid() %>&order=update"> 修 改 </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="<%=basePath %>poolservlet?teacherid=<%=teacherbean.getTeacherid() %>&order=delete" onclick="javascript:if(confirm('删除确认')){return true;}else{return false;}"> 删 除 </a>
		</td>
	<%
		out.println("</tr>");
	}
	out.println("</table>");
    %>
  </body>
</html>
