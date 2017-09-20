<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>DWR类库使用</title>
    <script type="text/javascript" src="dwr/engine.js"></script>
    <script type="text/javascript" src="dwr/util.js"></script>
    <script type="text/javascript" src="dwr/interface/.js"></script>
  </head>
  
  <body>
    <h1 align="center">DWR类库使用</h1>
    <hr/>
    <div id="msg">显示服务器端传给客户端的值</div>
    <input type="text" name="username" id="username" value="张三">
    <Input type="button" value="测试">
  </body>
</html>
