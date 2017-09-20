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
				alert("书名名称不能为空！");
				form1.name.focus();
				return false;
			}
			if(form1.price.value==""){
				alert("价格不能为空！");
				form1.price.focus();
				return false;
			}
			if(isNaN(form1.price.value)){
				alert("价格只能输入数字！");
				form1.price.focus();
				form1.price.value="";
				return false;
			}
			if(form1.num.value==""){
				alert("数量不能为空！");
				form1.num.focus();
				return false;
			}
			if(isNaN(form1.num.value)){
				alert("数量只能输入数字！");
				form1.num.focus();
				form1.num.value="";
				return false;
			}
			if(form1.writer.value==""){
				alert("作者不能为空！");
				form1.writer.focus();
				return false;
			}
			return true;
		}
	</script>
  </head>
  
  <body>
  <form name="form1" method="post" action="T7doc1/addsave.jsp" onsubmit="return check();">
  <h1 align='center'>书架信息的新增</h1>
  <%
  	request.setCharacterEncoding("utf-8");
  
  %>
  	<table border="0" align="center" >
  		<tr><th align='center'>书名</th><th align='center'>价格(元)</th><th align='center'>数量(本)</th><th align='center'>作者</th><th align="center">要求</th></tr>
    	<tr><td><input type="text" name="name"></td><td><input type="text" name="price"></td><td><input type="text" name="num"></td><td><input type="text" name="writer"></td><td><font color="red" size="5">*必填内容</font></td></tr>
    	<tr><td colspan="5" align="center"><input type="submit" name="sub" value="  新  增  " ></td></tr>
    </table>
  </form>
  </body>
</html>
