<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="SQLBean.Citybean"%>
<%@page import="SQLBean.PagingBean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>城市列表查询</title>
    
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
  <h1 align="center">城市信息览表</h1>
  <table align="center">
  	<tr><td><a href="<%=basePath%>cityservlet?order=add"> 新 增</a></td><td>&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=basePath %>privaceservlet?order=list">显示省份列表</a></td></tr>
  </table>
    <%
    PagingBean pager = (PagingBean)request.getAttribute("page");
	out.println("<table border='1' align='center' width='740'><tr height='40'><th align='center'>城市编号</th><th align='center'>省份名称</th><th align='center'>城市名称</th><th align='center'>操作</th></tr>");
	List<Citybean> list = (List<Citybean>)request.getAttribute("citylist");
	Citybean citybean = null;
	for(int i=0;i<list.size();i++){
		citybean=list.get(i);
		out.println("<tr height='40'><td align='center'>"+citybean.getCityid()+"</td><td align='center'>"+citybean.getPrivacename()+"</td><td align='center'>"+citybean.getCityname()+"</td>");
	%>
		<td align="center">
		<a href="<%=basePath %>cityservlet?cityid=<%=citybean.getCityid() %>&order=update"> 修 改 </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="<%=basePath %>cityservlet?cityid=<%=citybean.getCityid() %>&order=delete" onclick="javascript:if(confirm('删除确认')){return true;}else{return false;}"> 删 除 </a>
		</td>
	<%
		out.println("</tr>");
	}
	
	out.println("</table>");
    %>
    <div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
    <div align="center" style="font-size:18px">
	    <b>总记录数&nbsp;&nbsp;<%=pager.getPagebarsum() %></b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    <b>总 页 数&nbsp;&nbsp;<%=pager.getSumpage() %>页</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    <b>当前页数&nbsp;&nbsp;<%=pager.getCurrentpage() %></b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    <a href="<%=basePath %>cityservlet?order=list&currenpage=1&handle=firstpage">首    页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    <a href="<%=basePath %>cityservlet?order=list&currenpage=<%=pager.getCurrentpage() %>&handle=uppage">上 一 页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    <a href="<%=basePath %>cityservlet?order=list&currenpage=<%=pager.getCurrentpage() %>&handle=downpage">下 一 页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    <a href="<%=basePath %>cityservlet?order=list&currenpage=<%=pager.getSumpage() %>&handle=lastpage">尾    页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    </div>
  </body>
</html>
