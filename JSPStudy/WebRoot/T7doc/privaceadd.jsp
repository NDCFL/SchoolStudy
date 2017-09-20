<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'privaceadd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function check(){
			if(form1.name.value==""){
				alert("省份名称不能为空！");
				form1.name.focus();
				return false;
			}
			return true;
		}
	</script>
  </head>
  
  <body>
  <form name="form1" method="post" action="privaceservlet?order=add" onsubmit="return check();">
  <h1 align='center'>省份信息的新增</h1>
  <%
  	request.setCharacterEncoding("utf-8");
  
  %>
  	<table border="0" align="center" >
    	<tr><th>省份名称</th><td><input type="text" name="privaceName"></td><td><font color="red" size="5">*必填内容</font></td></tr>
    	<tr><td colspan="3" align="center"><input type="submit" name="sub" value="  新  增  " ></td></tr>
    </table>
  </form>
  </body>
</html>
