<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    <script type="text/javascript">
   
    function info(){
   	 	if(forms.text1.value==""){
   	 		alert("消息不能为空");
   	 		return false;
   	 	}
   	 	forms.mess.value=forms.text1.value;
   	 	forms.text1.value="";
    }
    </script>
  </head>
  
  <body>
 	<form action="T4doc/left.jsp" method="post" target="left" name="forms">
             字体颜色:<select name="yanse">
                 <option value="black">黑色</option>
                 <option value="red" >红色</option>
                 <option value="green" >绿色</option>
                 <option value="green" >蓝色</option>
             </select>
           字体大小：<select name="daxiao">
                 <option value="1" >1</option>
                 <option value="2" >2</option>
                 <option value="3" >3</option>
                 <option value="4" >4</option>
                 <option value="5" >5</option>
                 <option value="6" >6</option>
                 <option value="7" >7</option>
                 <option value="8" >8</option>
                 <option value="9" >9</option>
                 <option value="10">10</option>
             </select>
     <hr>
	    <input name="text1" type="text" style="width:200px;height:80px;">
    	<input type="submit" name="bt" value=" 发 送 " style="width:100px;height:80px;" onclick="return info();"><input type="reset" name="bt" value=" 清 空 " style="width:100px;height:80px;">
     	<input type="hidden" name="mess">
      <hr/>
      <input type="radio" name="touxiang" value="img/1b.jpg" checked><img src="img/1b.jpg"/>
      <input type="radio" name="touxiang" value="img/2b.jpg"><img src="img/2b.jpg"/>
      <input type="radio" name="touxiang" value="img/3b.jpg"><img src="img/3b.jpg"/>
      <input type="radio" name="touxiang" value="img/4b.jpg"><img src="img/4b.jpg"/>
      <input type="radio" name="touxiang" value="img/5b.jpg"><img src="img/5b.jpg"/>
      <input type="radio" name="touxiang" value="img/6b.jpg"><img src="img/6b.jpg"/>
      <input type="radio" name="touxiang" value="img/7b.jpg"><img src="img/7b.jpg"/>
      <input type="radio" name="touxiang" value="img/8b.jpg"><img src="img/8b.jpg"/>
      <input type="radio" name="touxiang" value="img/9b.jpg"><img src="img/9b.jpg"/>
      <input type="radio" name="touxiang" value="img/10b.jpg"><img src="img/10b.jpg"/>
      <input type="radio" name="touxiang" value="img/11b.jpg"><img src="img/11b.jpg"/>
      <input type="radio" name="touxiang" value="img/12b.jpg"><img src="img/12b.jpg"/>
      <input type="radio" name="touxiang" value="img/13b.jpg"><img src="img/13b.jpg"/>
      <input type="radio" name="touxiang" value="img/14b.jpg"><img src="img/14b.jpg"/>
      <input type="radio" name="touxiang" value="img/15b.jpg"><img src="img/15b.jpg"/>
      <input type="radio" name="touxiang" value="img/20b.jpg"><img src="img/20b.jpg"/>
       <%
       		String str="";
       		for(int i=0;i<=95;i++){
       			str="img/"+i+".gif";
       %>	
       		<input type="radio" name="touxiang" value="<%=str %>"><img src="<%=str %>"/>	
       	<%		
       		}
       %>
     </form>
 	
  </body>
</html>
