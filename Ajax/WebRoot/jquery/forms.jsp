<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>JQuery类库使用演示</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.1.js"></script>
  </head>
  
  <body>
    <h1 align="center">JQuery类库使用演示</h1>
    <hr/>
    <form action="" name="form1">
    	用户名称：<Input type="text" id="username" value="张三"><br/>
    	性别：<input type="radio" name="sex" value="男">男
    		<input type="radio" name="sex" value="女">女
    	
    	<input type="button" id="btnGetValue" value="取值" abc="abc"><br/>
    	<input type="button" id="btnHidden" value="隐藏"><br/>
    </form>
   	<input type="button" id = "btnDisplay" value="显示"><br/>
   	<input type="button" id = "btnsex" value="更改单选框选项"><br/>
   	
   	
   	<script type="text/javascript">
   		$("#btnGetValue").click(
   			function(){
   				var v= $("#username").val();
   				alert(v);
   				$("#username").val("李四");
   				//更改属性的值
   				$("#username").data("abc","aaaaaaaaaaaaaaa");
   				//更改CSS样式
   				$("#username").css("cursor","pointer");
   				$("#username").css("background","#00ff88");
   				
   			}
   		);
   		$("#btnHidden").click(
   			function(){
   				$("form").hide();
   			}
   		);
   		$("#btnDisplay").click(
   			function(){
   				$("form").show();
   			}
   		);
   		$("#btnsex").click(
   			function(){
   				$("input[name=sex]").each(
   					function (i,obj){
   						alert($(obj).val());
   						//设置当前控件为选中状态
   						$(obj).attr("checked",true);	
   					}
   				);
   				//获取选中的值
   				alert($("input[name=sex]:checked").val());
   			}
   		);
   	</script>
   	
   	
    
    
    
  </body>
</html>
