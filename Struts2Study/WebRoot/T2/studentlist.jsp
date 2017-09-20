<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>学生列表</title>
  </head>
  <body>
    <h1 align="center">学生列表</h1>
    <table border="0" width="1200px" align="center">
    	<tr height="40">
    		<th>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号</th>
	    	<th>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</th>
	    	<th>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄</th>
	    	<th>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别</th>
	    	<th>所属民族</th>
	    	<th>家庭住址</th>
	    	<th>所选专业</th>
	    	<th>班级名称</th>
	    	<th>相关操作</th>
    	</tr>
    	<s:iterator var="l" value="${studentList}">
    		<tr height="40px">
    			<td align="center">${l.sno}</td>
    			<td align="center">${l.studentname}</td>
    			<td align="center">${l.sage}</td>
    			<td align="center">${l.ssex}</td>
    			<td align="center">${l.shobit}</td>
    			<td align="center">${l.szhuanye}</td>
    			<td align="center">${l.classname}</td>
    			<td align="center">${l.nationname}</td>
    			<td align="center"><a href="<%=basePath %>StudentAction.action?order=delete&sno=${l.sno}">删除</a><a href="<%=basePath %>StudentAction.action?order=update&sno=${l.sno}">修改</a></td>
    		</tr>
    	</s:iterator>
    	<tr >
			<td  colspan="9" align="center">
				<span class="current">总记录数&nbsp;&nbsp;${pager.pagebarsum }</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span class="current">页码&nbsp;&nbsp;${pager.currentpage }/${pager.sumpage }页</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="<%=basePath %>StudentAction.action?order=list&currenpage=1&handle=firstpage">首   页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="<%=basePath %>StudentAction.action?order=list&currenpage=${pager.currentpage }&handle=uppage">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="<%=basePath %>StudentAction.action?order=list&currenpage=${pager.currentpage }&handle=downpage" >下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="<%=basePath %>StudentAction.action?order=list&currenpage=${pager.sumpage }&handle=lastpage">尾  页</a> 
			</td>
      </tr>
    </table>
  </body>
</html>
