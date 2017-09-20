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
    <script type="text/javascript">
    	$(function(){
	    	alert("ok1");
	    	$("#btnTest2").bind("click",function(){
	    			alert("btnTest2");
	   		});
	   		
	   		
   		});
    </script>
  </head>
  
  <body>
    <h1 align="center">JQuery类库使用演示</h1>
    <hr/>
    <ul>
    	<li id="li1">11111111111111</li>
    	<li name="li2">222222222222</li>
    	<li class="li3">333333333333333333</li>
    	<li aaa="li4">44444444444444444444</li>
    	<li bbb="li5">555555555555555555</li>
    	<li>66666666666666666</li>
    	<li>777777777777777777</li>
    </ul>
    <input type="button" id="btnTest" value="测试">
    <input type="button" id="btnTest2" value="测试2">
    
    
    
  <script type="text/javascript">
		$("#btnTest").click(
			function(){
				/*
				$("ul li").each(
					function(i,v){
						alert(i+":"+$(v).text());
					}
				);
				*/
				
				//alert($("ul li:first").text());
				//alert($("ul li:last").text());
				//取索引为偶数的行
				$("ul li:even").each(
					function(i,v){
						alert($(v).text());
						$(v).css("background","#00ff00");
					}
				);
				//取索引为奇数的行
				$("ul>li:odd").each(
					function(i,v){
						$(v).text($(v).text()+"8888888888888");
						$(v).css("background","#0088ff");
						$(v).css("cursor","pointer");
						
					}
				);
				$("li:contains('444')").css("background","#ff2888");
			}
		);
		//在jquery中，获取标签的值用text()函数
		/*
			获取id属性的值 $("#id");
			获取class属性的值 $(".id");
			获取其他属性的值 $("[xxx=yyyy]");
		
		*/
		$("#li1").click(
			function(){
				//取值
				alert($("#li1").text());
				//更改值
				$("#li1").text("li1更改后的值");
			}
		);
		$("[name=li2]").click(
			function(){
				alert($("[name=li2]").text());
			}
		);
		$(".li3").click(
			function(){
				alert($(".li3").text());
			}
		);
		$("[bbb=li5]").click(
			function(){
				alert($("[bbb=li5]").text());
			}
		);
	</script>  
  </body>
</html>
