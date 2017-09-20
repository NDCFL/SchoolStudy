<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="struts.form.StudentForm"%>
<%@ taglib prefix="html"  uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean"  uri="http://struts.apache.org/tags-bean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html>
  <head>
    <base href="<%=basePath%>">
    <title>学生列表</title>
  </head>
  <body>
  <%
  	StudentForm student = (StudentForm)request.getAttribute("studentForm");
  %>
  	<h1 align="center">学生列表</h1>
  		<div id="msg"></div>
		<html:errors/>
		<html:messages id="message" message="true">
			<bean:write name="message"/>
		</html:messages>
   		<html:form action="/stud.do" method="post" >
   			<table border="0" align="center" width="800">
	    		<tr height="50">
	    			<td>
			    		<bean:message key="lab.sno"/><html:text  name="studForm" property="sno"  style="height:40px;width:200px;ime-mode: disabled"/>
	    			</td>
	    			<td>
	    				<bean:message key="lab.studentname"/><html:text  property="studentname" name="studForm"  style="height:40px;width:200px"/>
	    			</td>
	    		</tr>
			    <tr height="50">
	    			<td>
			    		年龄：<html:text property="sage" name="studForm"  style="height:40px;width:200px"/>
			    	</td>
	    			<td>
			    		性别：&nbsp;&nbsp;<html:radio property="ssex" name="studForm"  value="男" />男&nbsp;&nbsp;<html:radio property="ssex" name="studForm"   value="女" />女
			    	</td>
	    		</tr>
			    <tr height="50">
			    	<td>
			    		籍贯：<html:text property="shobit" name="studForm"  style="height:40px;width:200px"/>
			    	</td>
			    	<td>
			    		专业：<html:text property="szhuanye" name="studForm"  style="height:40px;width:200px"/>
			    	</td>
			    </tr>
			    <tr height="50">
			    	<td colspan="2">
			    		爱好：
			    		<html:checkbox property="hobit" name="studForm"  style="height:10px;width:30px" value="篮球"/>篮球
			    		<html:checkbox property="hobit" name="studForm"  style="height:10px;width:30px" value="足球"/>足球
			    		<html:checkbox property="hobit" name="studForm"  style="height:10px;width:30px" value="排球"/>排球
			    		<html:checkbox property="hobit" name="studForm"  style="height:10px;width:30px" value="乒乓球"/>乒乓球
			    		<html:checkbox property="hobit" name="studForm"  style="height:10px;width:30px" value="保龄球"/>保龄球
			    	</td>
			    </tr>
			   <tr align="center" height="100">
				   <td align="center" colspan="2" height="40">
				   		<html:submit value="新增" style="height:40px;width:200px;display:block;float:left;margin-left:60px" onclick="check();" accesskey="x"/>
				   		<html:reset value="复位" style="height:40px;width:200px;display:block;float:left;margin-left:30px" accesskey="r"/>
				   		<html:submit value="显示列表" style="height:40px;width:200px;display:block;float:left;margin-left:30px" accesskey="l"/>
				   </td>
			   </tr>
    	</table>
    </html:form>
   	<h1 align="center" id="info">学生基本信息</h1>
  		<table align="center" border="1" width="800px" >
	   		<tr height="40px">
	   			<th>学号</th>
	   			<th>姓名</th>
	   			<th>年龄</th>
	   			<th>性别</th>
	   			<th>籍贯</th>
	   			<th>专业</th>
	   			<th>操作</th>
	   		</tr>
	   		<tbody id="data"></tbody>
   		</table>
  </body>
</html:html>
