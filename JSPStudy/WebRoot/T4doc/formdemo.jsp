<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'formdemo.jsp' starting page</title>

  </head>
  
  <body>
  <h1 align="center">控件的使用</h1>
  <hr color="blue"/>
    <form action="T4doc/formsave.jsp" method="post" name="form1"> 
     	性别：<input type="radio" name="sex" value="男">男<input type="radio" name="sex" value="女">女<br/>
     	婚姻：<input type="radio" name="marry" value="未婚">未婚<input type="radio" name="marry" value="已婚">已婚<br/>
   		爱好：<input type="checkbox" name="hobby" value="吃饭">吃饭<input type="checkbox" name="hobby" value="睡觉">睡觉<input type="checkbox" name="hobby" value="追剧">追剧<br/>
    	<input type="submit" name="sub" value=" 提 交 ">
    </form>
  </body>
</html>
