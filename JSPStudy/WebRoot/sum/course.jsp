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
    <title>宏图教育在线学习平台</title>
    <script type="text/javascript">
    	function check(){
    		if(form1.evalContent.value==""){
    			alert("您对课程满意吗？请献出您宝贵的意见");
    			form1.evalContent.focus();
    			return false;
    		}
    		return true;
    	}
    </script>
  </head>
  
  <body>
	<form name="form1" action="<%=basePath %>loginservlet?order=add" method="post">
  	<table  align="center" border="1" cellpadding="1" cellspacing="1" width="100%" >
				<tr >
 					<td align="right">类别</td>
 					<td>
 						<select name="evalLevel" id="evalLevel" style="width:155px">
							<option value="1">好评</option>
							<option value="2">中评</option>
							<option value="3">差评</option>
						</select>
 					</td>
 				</tr> 				
 				<tr>
 					<td align="center">我的评价</td>
 					<td>
 						
 						<input  name="pingjia" type="text"/>
 					
 					</td>
 				</tr>
 			<tr >
			<td colspan="3" align="center"><input type="submit" value=" 保 存 "/></td>
		</tr>							
 	</table>
 	</form>
  </body>
</html>
