<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>软件使用意见反馈</title>
  </head>
  
  <body>
    <h1 align="center">软件使用意见反馈</h1>
    <form action="./subject" method="post">
    	<table align="center" border="0" width="400" height="400">
    		<tr><td><h1 align="center">软件使用意见反馈</h1></td></tr>
    		<tr><td>姓名：<input type="text" name="id"></td></tr>
    		<tr><td>E_mail：<input type="text" name="time"></td></tr>
    		<tr><td>软件名称：
    			<select name="se">
    				<option name="name" value="html">html</option>
    				<option name="name" value="C语言">C语言</option>
    				<option name="name" value="JSP">JSP</option>
    				<option name="name" value="JS">JS</option>
    				<option name="name" value="JAVA">JAVA</option>
    			</select>
    		</td></tr>
    		<tr><td>电话：<input type="text" name="xiangmu"></td></tr>
    		<tr><td>操作系统：
    			<select name="ex">
    				<option name="ex" value="Win7">Win7</option>
    				<option name="ex" value="Win8">Win8</option>
    				<option name="ex" value="Win10">Win10</option>
    				<option name="ex" value="XP">XP</option>
    			</select>
    		</td></tr>
    		<tr><td>回馈时间：<input type="text" name="shijian" value="<% out.println(new Date().toLocaleString()); %>"></td></tr>
    		<tr><td>回馈描述：
    		<textarea name="imfo" cols="40" rows="5">
    		
			</textarea></td></tr>
    		<tr><td><input type="submit" value="提交回馈信息" name="tijiao"><input type="reset" value="填错了清空数据重输" name="delete"></td></tr>
    	</table>
    
    </form>
  </body>
</html>
