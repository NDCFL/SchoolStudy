<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'shopprice.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  </head>
  
  <body>
 	<form action="T12/shopprice.jsp" method="post" name="form1">
 		 <table>
	    	<%
	    	
	    		ArrayList<String> list = new ArrayList<String>();
    	String str[] = request.getParameterValues("z");
    	for(int i=0;i<str.length;i++){
    		switch(i){
    			case 0:
	    			list.add("<input type='checkbox' name='z' value='1' style='width:80px;'>《水浒传》 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价格为：48元");
    				break;
    			case 1:
    				list.add("<input type='checkbox' name='z' value='1' style='width:80px;'>《三国演义》 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价格为：50元");
    				break;
    			case 2:
    				list.add("<input type='checkbox' name='z' value='1' style='width:80px;'>《jsp参考大全》 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价格为：35元");
    				break;
    			case 3:
    				list.add("<input type='checkbox' name='z' value='1' style='width:80px;'>《java使用手册》 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价格为：40元");
    				break;
    		}
    	}
    	
    	Iterator<String> it = list.iterator();
    	out.println("<h1>我的购物车</h1>");
    	out.println("<table border='0' width='340'><tr><th align='center'>选择</th><th align='center'>商品名称</th><th align='center'>价格(元)</th></tr></table>");
		while (it.hasNext()) {
			out.println(it.next()+"<br/>");
		}
		request.setAttribute("name", "fdsgd");
		request.setAttribute("list", list);
	    	%>
 	
    	</table>
 	</form>
  </body>
</html>
