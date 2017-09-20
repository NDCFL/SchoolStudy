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
    
    <title>My JSP 'usebeandemo.jsp' starting page</title>
    
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
    	String hob[] = {"java","C语言","jsp"};
    %>
    <jsp:useBean id="jbd2" class="T6.JavabeamDemo">
    	<jsp:setProperty name="jbd2" property="id"/>
    	<jsp:setProperty name="jbd2" property="name" value="星空"/>
    	<jsp:setProperty name="jbd2" property="age" value="18"/>
    	<jsp:setProperty name="jbd2" property="sex" value="男"/>
    	<jsp:setProperty name="jbd2" property="classname" value="2016秋宏图一班"/>
    	<jsp:setProperty name="jbd2" property="hobit" value="<%=hob %>"/>
    	<jsp:setProperty name="jbd2" property="marry" value="false"/>
    </jsp:useBean>
    <h3 align="center">javabean的信息如下</h3>
   	 学号：<jsp:getProperty property="id" name="jbd2"/><br/>
     姓名：<jsp:getProperty property="name" name="jbd2"/><br/>
     年龄：<jsp:getProperty property="age" name ="jbd2"/><br/>
     性别：<jsp:getProperty property="sex" name="jbd2"/><br/>
     班级：<jsp:getProperty property="classname" name="jbd2"/><br/>
     <%
    	String ho = "";
    	for(int i=0;i<jbd2.getHobit().length;i++){
    		if(i==(jbd2.getHobit().length-1)){
    			ho+=hob[i];
    		}else{
	    		ho+=hob[i]+",";
    			
    		}
    	}
     %>
     兴趣爱好：<%=ho %><br/>
     婚姻状况：<jsp:getProperty property="marry" name="jbd2"/><br/>
  </body>
</html>
