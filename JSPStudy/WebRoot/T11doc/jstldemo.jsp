<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>标准标签函数库</title>
		<meta http-equiv="Refresh" content="1;url=jstldemo.jsp">
	</head>
	<body> 
	<h1 align="center">标准便签函数库</h1>
	<hr/>
		<table style="width:800px;height:500px;text-align:center;margin:0 auto;">
			<c:forEach begin="1" end="9" step="1" var="i" varStatus="cf">
				<tr>
				<c:forEach begin="1" end="${i}" var="j" step="1">
					<td style="border:1px solid #000;color:#6600ff;vertical-align:middle;" bgcolor="#<%=new Random().nextInt(699999)%>">${j}*${i}=${j*i }</td>
				</c:forEach>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>
