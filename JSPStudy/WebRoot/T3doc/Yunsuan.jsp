<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Yunsuan.jsp' starting page</title>

  </head>
  
  <body>
    <h1>各种运算列表&ltinclude动作元素的使用></h1>
    <form action="./Lianxi/Yunsuan.jsp" method="post" name="form1">
    	<div><input type="radio" name="sum" value="1">运算1~N之间的和</div><br/>
    	<div><input type="radio" name="sum" value="2">运算1~N之间的素数的个数</div><br/>
    	<div><input type="radio" name="sum" value="3">运算1~N的阶层值</div><br/>
    	<div><input type="text" name="text1" >请输入N的值<br/><input type="submit" name="sub" value=" 提 交 "><input type="reset" name="ret" value=" 清 空 "></div>
    </form>
    <%
    	String s = request.getParameter("sum");
	    if(s==null){
	    	s="1";
	    }
	    int n = Integer.parseInt(s);
	    switch(n){
	    	case 1:
	%>
			<jsp:include page="sum1.jsp"></jsp:include>
	
	<% 
			break;
		   	case 2:
	%>
			<jsp:include page="sum2.jsp"></jsp:include>
	
	<% 
			break;
		   	case 3:
	%>
			<jsp:include page="sum3.jsp"></jsp:include>
	
	<% 
			break;
	    }
    
    %>
  </body>
</html>
