<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body>
<%!int i=1;%>
<%!int getNumber(){
      return i;
}
%>
<%   i=10;
     out.println("first i="+i);
%>
<% out.println("second i="+i);%>
<% out.println("third i="+getNumber());%>
</body>
</html>