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
    <title>javabean的使用</title>
  </head>
  <body>
    <h1 align="center">javabean的使用</h1>
    <hr color="blue"/>
    <%
    	JavabeamDemo jbd = new JavabeamDemo();
    	String hob[] = {"java","C语言","jsp"};
    	jbd.setId(101);
    	jbd.setName("絮落锦乡");
    	jbd.setAge(19);
    	jbd.setSex("男");
    	jbd.setHobit(hob);
    	jbd.setClassname("宏图2016秋一班");
    	jbd.setMarry(true);
    %>
    <h3 align="center">javabean的信息如下</h3>
    学号：<%=jbd.getId() %><br/>
    姓名：<%=jbd.getName() %><br/>
    年龄：<%=jbd.getAge() %><br/>
    性别：<%=jbd.getSex() %><br/>
    <%
    	String ho = "";
    	for(int i=0;i<jbd.getHobit().length;i++){
    		ho+=hob[i]+",";
    	}
    %>
    爱好：<%=ho %><br/>
    班级：<%=jbd.getClassname() %><br/>
    婚姻：<%=jbd.isMarry() %><br/>
  </body>
</html>
