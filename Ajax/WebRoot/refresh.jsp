<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>自动刷新界面</title>
    
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/ajax.js"></script>
    <script type="text/javascript">
    	var vdepid="depid1";
    	function recedata(){
			if(xmlhttp.status==200){
				if(xmlhttp.readyState==4){
					//responseXML：服务器发送给客户端的xml文件格式的数据
					var data=xmlhttp.responseXML;
					//取数据getElementsByTagName
					var listData = data.getElementsByTagName("member");
					var row="";
					for(var i=0;i<listData.length;i++)
					{
						var studid = listData[i].firstChild.nodeValue;
						row+="<li>"+studid+"</li>";
					}
					var content = document.getElementById("msg");
					//把读取的内容放在id中
					content.innerHTML = row;
				}
			}
		}
		
		function refresh(){
			var param="";
			var url = "${pageContext.request.contextPath}/refreshServlet";
			send('post',url,param,true);
		}
		setInterval("refresh()",1000);
    </script>

  </head>
  
  <body>
    <h1 align="center">自动刷新界面</h1>
    <hr/>
    <ul id="msg">
    	<li>张三</li>
    	<li>李四</li>
    </ul>
  </body>
</html>
