<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'button.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
        function fs(){
            if(forms.message.value ==""){
                alert("不能发送空消息");
                return false;
            }
            //把文本域message的值赋给mess文本域
            forms.mess.value = forms.message.value
            forms.message.value = ""; 
        }
    </script>
  </head>
  <body background="img/555.gif">
    <form action="T4docqq/left.jsp" method="post" target="left" name="forms">
             字体颜色:<select name="yanse">
                 <option value="black">黑色</option>
                 <option value="red" >红色</option>
                 <option value="green" >绿色</option>
                 <option value="green" >蓝色</option>
                  <option value="pink" >粉色</option>
             </select>
           字体大小：<select name="daxiao">
                 <option value="4" >4</option>
                 <option value="1" >1</option>
                 <option value="2" >2</option>
                 <option value="3" >3</option>
                 <option value="5" >5</option>
                 <option value="6" >6</option>
                 <option value="7" >7</option>
             </select>
     <hr>
		<input type="text" name="message" style="width:200px;height:80px;"/>
		<input type="submit" value="发送" style="width:80px;height:80px;" onclick="return fs()">
		<input type="hidden" name="mess">
		<input type="radio" name="touxiang" value="img/1b.jpg" checked><img src="img/1b.jpg"/>
		 <%
			String str="";
			for(int i=0;i<=95;i++){
				str="img/"+i+".gif";
		%>	
			<input type="radio" name="touxiang" value="<%=str %>"><img src="<%=str %>"/>	
		<%		
			}
		%>
     <hr/>
		
     </form>
      </body>
</html>
