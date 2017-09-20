<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'cal.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function yanzheng(){
			var nu1=form1.num1.value;
			var nu2=form1.num2.value;
			if(nu1==""){
				alert("num1不能为空！");
				form1.num1.focus();
				return;
			}
			if(isNaN(nu1)){
				alert("num1含有非法字符！！");
				form1.num1.focus();
				nu1="";
				return;
			}
			if(nu2==""){
				alert("num2不能为空！");
				form1.num2.focus();
				return;
			}
			
			if(isNaN(nu2)){
				alert("num2含有非法字符！！");
				form1.num2.focus();
				nu2="";
				return;
			}
		}
		var src1=document.getElementById("num1").value;
		var src2=document.getElementById("num2").value;
	</script>
  </head>
  
  <body>
   <!-- http://localhost:8080/JSPT1/cal.jsp -->
    <h1>计算器应用</h1>
	<form action="show.jsp" method="post" name="form1" id="form1">
    	<input type="text" name="num1" id="num1">
    	<select name="se1" id="se1">
    		<option value="1">+</option>
    		<option value="2">-</option>
    		<option value="3">*</option>
    		<option value="4">/</option>
    	</select>
    	<input type="text" name="num2" id="num2">
    	<input type="submit" name="sub1" value="计算" onclick="yanzheng();">
    	<input type="reset" name="re1" value="清空" onclick="alert('数据将被清空？');">
    </form>
  </body>
</html>
