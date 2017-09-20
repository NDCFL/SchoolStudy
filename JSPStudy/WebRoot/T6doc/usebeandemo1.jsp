<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="T6.JavabeamDemo"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'usebeandemo1.jsp' starting page</title>
    
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
    <h1 align="center">javabean的使用</h1>
    <hr color="blue"/>
    <%
    	request.setCharacterEncoding("utf-8");
    %>
    <jsp:useBean id="jbd" class="T6.Entrybean">
    <!-- 取出所有的控件的值 -->
    	<jsp:setProperty name="jbd" property="*" />
    </jsp:useBean>
    <h3 align="center">报名基本信息表</h3>
    <%
     	String cl = "";
     	for(int i=0;i<jbd.getHobit().length;i++){
     		if(i==(jbd.getHobit().length-1)){
     			cl+=jbd.getHobit(i);
     		}else{
     			cl+=jbd.getHobit(i)+",";
     			
     		}
     	}
     %>
    <table align="center" width="300" height="400" border="1">
    	<tr><td>学号：</td><td><jsp:getProperty property="name" name="jbd"/></td></tr>
    	<tr><td>姓名：</td><td><jsp:getProperty property="pass1" name="jbd"/></td></tr>
    	<tr><td>受教育程度：</td><td><jsp:getProperty property="pass2" name="jbd"/></td></tr>
    	<tr><td>性别：</td><td><jsp:getProperty property="sex" name="jbd"/></td></tr>
    	<tr><td>年龄：</td><td><jsp:getProperty property="age1" name="jbd"/></td></tr>
    	<tr><td>是否及格：</td><td><jsp:getProperty property="gread" name="jbd"/></td></tr>
    	<tr><td>课程：</td><td><%=cl %></td></tr>
    	<tr><td>家庭住址：</td><td><jsp:getProperty property="province" name="jbd"/>,<jsp:getProperty property="city" name="jbd"/>,<jsp:getProperty property="county" name="jbd"/></td></tr>
    	
    </table>
  </body>
</html>
