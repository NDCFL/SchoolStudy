<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'privacealter.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <body>
  <h1 align="center">修改省份资料</h1>
   		<form action="<%=basePath %>privaceservlet?order=update" method="post">
		   	<table border="1" align="center">
		   	<input type="hidden" name="saveid" value="<%=request.getParameter("id")%>">
		    	<tr height="50"><th width="150">省份名称</th><td align="center"><input type="text" name="privacename" value="<%=new String(request.getParameter("privacename").getBytes("iso-8859-1"),"utf-8") %>"></td><td align="center" width="150"><font color="red" size="5">*修改省份</font></td></tr>	
		    	<tr><td colspan="3" align="center"><input type="submit" name="sub" value="  修  改  "></td></tr>
		    </table>
	    </form>
  </body>
</html>
