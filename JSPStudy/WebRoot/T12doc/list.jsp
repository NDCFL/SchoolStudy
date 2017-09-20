<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'list.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function del(){
			var item = document.getElementById("item1");
			removeChild(item);
			alert(item);
			return false;
		}
	</script>
  </head>
  <body>
  <h1 align="center">我的购物车</h1>
  <hr color="blue" size="5px"/>
  <form action="T12doc/list.jsp" method="post" name="form1" >
    	<table border="1" width="500" align="center">
	    <tr><th align="center">选择</th><th align="center">商品名称</th><th align="center">价格(元)</th></tr>
    <%
    	double money=0.0;
    	String str[] = request.getParameterValues("z");
    	for(int i=0;i<str.length;i++){
    		switch(i){
				case 0:
		%>
				<tr  id="item1"><td  align="center"><input type="checkbox" name="z" value="1"></td><td  align="center">《水浒传》</td><td id="item_1">45元</td></tr>
		<%	
					money+=45;
					break;
				case 1:
		%>
	    			<tr id="item1"><td  align="center" ><input type="checkbox" name="z" value="1"></td><td  align="center">《水浒传》</td><td id="item_1">40元</td></tr>
		<%	
					money+=40;
					break;
				case 2:
		%>
	    			<tr  id="item1"><td  align="center"><input type="checkbox" name="z" value="3"></td><td  align="center">《jsp详解》</td><td id="item_1">60元</td></tr>
		<%	
					money+=60;
					break;
				case 3:
		%>
	    			<tr id="item1"><td  align="center"><input type="checkbox" name="z" value="4"></td><td  align="center">《C语言大全》</td><td id="item_1">40元</td></tr>
		<%	
					money+=40;
					break;
			}
    	}
    %>
    <tr><td colspan="3" align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="删 除" style="width:90px;" onclick="del();"></td></tr>
    	</table>
    </form>
    <div style="text-align:center">一共花费：<%=money %>元</div>
  </body>
</html>
