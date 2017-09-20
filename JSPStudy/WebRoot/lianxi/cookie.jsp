<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>登录</title>
  </head>
  <body>
  <h1 align="center">登录界面</h1>
  <hr/>
  	<%
  		Cookie c[] = request.getCookies();
  		String name="";
  		String pwd="";
  		if(c!=null){
  			for(int i=0;i<c.length;i++){
  				if(c[i].getName().equals("name")){
  					name=URLDecoder.decode(c[i].getValue());
  				}
  				if(c[i].getName().equals("pwd")){
  					pwd=URLDecoder.decode(c[i].getValue());
  				}
  			}
  			
  		}
  	%>
    <form name="form1" action="lianxi/cookiesave.jsp" method="post">
    	<table border="0" align="center" width="300" height="100">
    		<tr><td align="center">昵称：</td><td height="60" align="center"><input type="text" name="login" value="<%=name %>"></td></tr>
    		<tr><td align="center">密码：</td><td height="60" align="center"><input type="password" name="pwd" value="<%=pwd %>"></td></tr>
    		<tr><td align="center" colspan="2"><input type="checkbox" name="ck" value="1">记住密码&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="ck" value="2">自动登录</td></tr>
    		<tr><td align="center"  colspan="2" ><input type="submit" name="sub" value=" 登 录 ">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" name="re" value=" 重 置 "></td></tr>
    	</table>
    </form>
  </body>
</html>
