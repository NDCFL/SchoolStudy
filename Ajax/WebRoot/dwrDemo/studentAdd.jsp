<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>dwr转换器</title>
    <script type="text/javascript" src="dwr/engine.js"></script>
    <script type="text/javascript" src="dwr/util.js"></script>
    <script type="text/javascript" src="dwr/interface/studentService.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/prototype.js"></script>
    <script type="text/javascript">
    	function add(){
    		var id = $F("id");
    		var studno = $F("studno");
    		var studname = $F("studname");
    		var classname = $F("classname");
    		alert(classname);
    		//传递javabean到后台
    		var stud={"id":id,"studno":studno,"studname":studname,"classname":classname};
    		studentService.addStudent(stud,saveSuccess);
    		
    	}
    	function saveSuccess(data){
    		$("message").innerText = data;
    	}
    </script>
  </head>
  
  <body>
    <h1 align="center">dwr转换器-新增学生信息</h1>
    <hr/>
    <div id="message"></div>
    id:<input type="text" name="id" id="id" value="1"/><br/>
    学号:<input type="text" name="studno" value="1001"/><br/>
    姓名:<input type="text" name="studname" id="studname" value="张三"/><br/>
    班级:<input type="text" name="classname" value="宏图201601班"/><br/>
    <input type="button" value=" 保 存 " onclick="add();"/>
  </body>
</html>
