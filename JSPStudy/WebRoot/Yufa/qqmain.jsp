<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    <script type="text/javascript">
    var read="";
    read=document.getElementById("area1").value;
    function info(){
   	 	var write = document.getElementById("area2").value+"---"+new Date().toLocaleString();
    	read+=write+"<br/>";
    	document.getElementById("area1").value=read;
    	document.getElementById("area2").value="";
    	alert(read);
    }
    </script>
  </head>
  
  <body>
  <h1 align="center">简单的聊天室</h1>
  <hr color="blue">
  
 	<%
 		
    	request.setCharacterEncoding("utf-8");
 		//String name = request.getParameter("username");
 		pageContext.setAttribute("name",request.getParameter("area2")+new Date().toLocaleString());
    	
    %>
  <form name="form1" action="T4doc/main.jsp" method="post">
    <table border="1" align="center">
    	<tr><td><h1 align="center">简单的聊天室</h1></td></tr>
    	<tr><td><textarea name="area1" rows="20" cols="50" isEnable="false"><%=application.getAttribute("name") %></textarea></td></tr>
    	<tr><td><textarea name="area2" rows="5" cols="50"></textarea></td></tr>
    	<tr><td align="right"><input type="submit" name="bt" value=" 发 送 " ><input type="reset" name="bt" value=" 清 空 "></td></tr>
    </table>
    </form>
    
    
  </body>
</html>
