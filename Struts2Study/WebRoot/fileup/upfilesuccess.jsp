<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>图片上传</title>
  </head>
  <body> 	
    <img align="top" src="<s:property value="'upfile/'+fileupinfo.filename"/>" style="width:200px;height:100px margin:3px auto;border-radius:50%"/><br/>
    <a href="fileup/upfile.jsp">我要上传图片</a>
    <a href="FileDownAction.action?inputpath=<s:property value="fileupinfo.filepath"/>&filename=<s:property value="'upfile/'+fileupinfo.filename"/>">我要下载图片</a>
  </body>
</html>
