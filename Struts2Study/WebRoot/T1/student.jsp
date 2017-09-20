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
  	<script type="text/javascript">
  		$(function(){
  			$("#info").bind("click",function(){
  				$.post(
  					"${pageContext.request.contextPath}/StudentAction.action",
  					{
						"order":"list"
					},
					play,
					"text"
  				);
  			});
  		});
  		function play(in){
				alert(in);
			}	
  	</script>
  </head>
  <body>
    <h1 align="center">学生信息的录入</h1>
    <hr/>
    <s:form action="StudentAction" method="post" theme="simple" namespace="/Action">
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
    			<td colspan="4" align="center"><s:submit value="新增" style="width:200px;height:40px"/></td>
    		</tr>
    	</table>
    </s:form>
    <h1 align="center" id="info">学生列表</h1>
    <table border="1" width="800" align="center">
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
    	<tbody id="data"></tbody>
    </table>
  </body>
</html>
