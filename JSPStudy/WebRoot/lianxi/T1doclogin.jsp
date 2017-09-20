<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
  	request.setCharacterEncoding("utf-8");
  	if(request.getParameter("sub")!=null){
  		application.setAttribute("name",request.getParameter("login"));
    	application.setAttribute("pwd",request.getParameter("pwd"));
    	session.setAttribute("name",request.getParameter("login"));
    	session.setAttribute("pwd",request.getParameter("pwd"));
    	
  		response.sendRedirect("T1docchecklogin.jsp");
  	}
    %>
    <form name="form1" action="lianxi/T1doclogin.jsp" method="post">
    	<table border="0" align="center" width="200" height="100">
    		<tr><td align="center">昵称：</td><td height="50" align="center"><input type="text" name="login"></td></tr>
    		<tr><td align="center">密码：</td><td height="50" align="center"><input type="password" name="pwd"></td></tr>
    		<tr><td align="center"><input type="submit" name="sub" value=" 登 录 "></td><td align="center"><input type="reset" name="re" value=" 重 置 "></td></tr>
    	</table>
    </form>
  </body>
</html>
