<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'T1docCal.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function hefa(){
			if(form1.num2.value==0 && form1.num4.value==4){
				alert("相除时分母不得为0");
				form1.num2.focus();
				return false;
				
			}
			return true;
		}
	</script>
  </head>
  
  <body>
  <h1 align="center">计算器</h1>
  <hr />
  
  <jsp:useBean id="num" class="T6.Numbean">
  		<jsp:setProperty  name="num" property="num1"/>
  		<jsp:setProperty  name="num" property="num2"/>
  		<jsp:setProperty  name="num" property="num4"/>
  </jsp:useBean>
	<%
		int num1 = num.getNum1();
		int num2 = num.getNum1();
		int num3 = num.getNum3();
		int num4 = num.getNum4();
		String re=null;
		double result=num.result(num.getNum1(),num.getNum2(),num.getNum4());
		if(num4==1){
			re=num1+"+"+num2+"="+result;
		}else if(num4==2){
			re=num1+"-"+num2+"="+result;
		}else if(num4==3){
			re=num1+"*"+num2+"="+result;
		}else if(num4==4){
			re=num1+"/"+num2+"="+result;
		}else if(num4==5){
			re=num1+"%"+num2+"="+result;
		}
	%>	
	<form action="T6doc/Cal.jsp" name="form1" onsubmit="return hefa();">
		<div>
		<input type="text" name="num1">
		<select name="num4">
			<option value="1">+</option>
			<option value="2">-</option>
			<option value="3">*</option>
			<option value="4">/</option>
			<option value="5">%</option>
		</select>
		<input type="text" name="num2">
		<input type="submit" name="sub" value="=">
		<input type="text" name="tex" value="<%=re %>">
		</div>
	</form>
	
  </body>
</html>
