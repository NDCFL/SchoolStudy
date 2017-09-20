<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
s<%
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
			if(form1.teachername.value==""){
				alert("教师名称不能为空！");
				form1.teachername.focus();
				return false;
			}
			if(form1.teachergread.value==""){
				alert("教师比重不能为空！");
				form1.teachergread.focus();
				return false;
			}
			if(isNaN(form1.teachergread.value)){
				alert("教师比重含有非法字符");
				form1.teachergread.focus();
				return false;
			}
			return true;
		}
	</script>
  </head>
  
  <body>

  <form name="form1" method="post" action="<%=basePath %>poolservlet?order=teacheradd" onsubmit="return check();">
  <h1 align='center'><font color="blue">教师信息的新增</font></h1>
  	<table border="0" align="center" >
  		<tr>
	  		<th>教师名称</th>
	  		<td><input type="text" name="teachername" style="width:150px"></td>
	  		<td><font color="red" size="5">*必填内容</font></td>
  		</tr>
  		<tr>
  			<th>教师比重</th>
	  		<td><input type="text" name="teachergread" style="width:150px"></td>
	  		<td><font color="red" size="5">*必填内容</font></td>
  		</tr>
    	<tr><td colspan="3" align="center"><input type="submit" name="sub" value="  新  增  " ></td></tr>
    </table>
  </form>
  </body>
</html>
