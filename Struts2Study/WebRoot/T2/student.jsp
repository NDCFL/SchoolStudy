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
    <title>学生的录入</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.1.min.js"></script>
  </head>
  <body>
    <h1 align="center">学生信息的录入</h1>
    <hr/>
    <s:form action="StudentAction?order=add" method="post" theme="simple" namespace="/Action">
    	<table border="0" width="1300" height="300" align="center">
    		<tr>
    			<td>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：<s:textfield name="stud.sno" style="width:200px;height:40px" id="sno"/></td>
    			<td>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<s:textfield name="stud.studentname" style="width:200px;height:40px" id="studentname"/></td>
    			<td>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：<s:radio name="stud.ssex" list="#{'男':'男','女':'女'}" listKey="key" listValue="value" id="ssex"/></td>
    			<td>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄：<s:textfield name="stud.sage" style="width:200px;height:40px"/></td>
    		</tr>
    		<tr>
    			<td>家庭住址：<s:textfield name="stud.shobit" style="width:200px;height:40px" id="shobit"/></td>
    			<td>所选专业：<s:textfield name="stud.szhuanye" style="width:200px;height:40px" id="szhuanye"/></td>
    			<td>班级名称：<s:select  name="stud.classid" list="#request.classlist" id="classid" listKey="classid" listValue="classname" style="width:200px;height:40px"/></td>
    			<td>所属民族：<s:select  name="stud.nationid" list="#request.nationlist" id="nationid" listKey="nationid" listValue="nationname" style="width:200px;height:40px"/></td>
    		</tr>
    		<tr>
    			<td colspan="4" align="center"><s:submit id="sub1" value="新  增/修  改" style="width:200px;height:40px;"/></td>
    		</tr>
    	</table>
    </s:form>
    <h1 align="center" id="info">学生列表</h1>
    <table border="1" width="1000" align="center">
    	<tr height="40">
    		<th>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号</th>
	    	<th>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</th>
	    	<th>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄</th>
	    	<th>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别</th>
	    	<th>所在地址</th>
	    	<th>家庭住址</th>
	    	<th>所属班级</th>
	    	<th>所属民族</th>
	    	<th>相关操作</th>
    	</tr>
    	<s:iterator var="l" value="#request.studentList">
    		<tr height="40px">
    			<td align="center">${l.sno}</td>
    			<td align="center">${l.studentname}</td>
    			<td align="center">${l.sage}</td>
    			<td align="center">${l.ssex}</td>
    			<td align="center">${l.shobit}</td>
    			<td align="center">${l.szhuanye}</td>
    			<td align="center">${l.classname}</td>
    			<td align="center">${l.nationname}</td>
    			<td align="center"><a href="<%=basePath %>StudentAction.action?order=delete&sno=${l.sno}">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=basePath %>StudentAction.action?order=update&sno=${l.sno}" id="update">修改</a></td>
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
