<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="java.net.URLDecoder"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'logincookie.jsp' starting page</title>
    
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
  <h1 align="center">cookie对象的使用</h1>
  <hr color="blue" size="3px"/>
  	<%
  		Cookie coo[] = request.getCookies();
  		String name = "";
  		String pwd = "";
  		if(coo!=null){
  			for(int i=0;i<coo.length;i++){
  				Cookie c = coo[i];
  				if(c.getName().equals("user")){
  	  				name=URLDecoder.decode(c.getValue());
  	  				out.println("昵称："+name);
  	  			}
  				if(c.getName().equals("password")){
  					//pwd="";
  					pwd = c.getValue();
  					out.println("pwd:"+pwd);
  				}
  			}
  		}
  	%>
  	<form action="T5doc/cookiecheck.jsp" method="post" name="form1">
  		<table width="220" border="0" align="center">
  			<tr><td>昵称：</td><td><input type="text" name="username" value="<%=name %>" size="19"></td></tr>
  			<tr><td>密码：</td><td><input type="text" name="password" value="<%=pwd %>"></td></tr>
  			<tr><td align="center"><input type="checkbox" name="ck" value="1">记住密码&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="ck" value="2">自动登录</td></tr>
  			<tr><td colspan="2" align="center"><input type="submit" name="sub" value=" 登 录 ">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" name="re" value=" 清 空 "></td></tr>
  		</table>
  	</form>
  </body>
</html>
