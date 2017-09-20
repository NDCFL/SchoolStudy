<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">   
    <title>省份城市列表</title> 
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <body>
  	<h1 align="center">省份城市列表</h1>
    <form action="" method="post">
    	<table border="0" width="800" height="40" align="center">
    		<tr height="40"align="center"><td><a href="">省份的新增</a></td></tr>
    	</table>
    	<table border="1" width="800" align="center">
    		<tr  height="40">
    			<th>省份编号</th>
	       		<th>省份名称</th>
	       		<th>城市名称</th>
    		</tr> 		
    		<c:forEach var="p" items="${list}">
    			<tr height="40">
    				<td align="middle">${p.provinceid}</td>
    				<td align="middle">${p.provinceName}</td>
    				<td align="middle">${p.cityName}</td>
    			</tr>
    		</c:forEach>
    		<tr colspan="3" height="50">
    			<td class="pagelist" colspan="3" align="center">
					<span class="current">总记录数&nbsp;&nbsp;${pager.barsum }</span>&nbsp;&nbsp;&nbsp;&nbsp;
					<span class="current">页码&nbsp;&nbsp;${pager.currentpage }/${pager.pagesum }页</span>&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="<%=basePath %>provinceservlet?order=list&currentpage=1&handle=firstpage">首   页</a>&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="<%=basePath %>provinceservlet?order=list&currentpage=${pager.currentpage }&handle=uppage">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="<%=basePath %>provinceservlet?order=list&currentpage=${pager.currentpage }&handle=downpage" >下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="<%=basePath %>provinceservlet?order=list&currentpage=${pager.pagesum }&handle=lastpage">尾  页</a>
				</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
