<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'left.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <body>
   	<%
   		//设置编码
   		request.setCharacterEncoding("utf-8");
   		//获取字体大小
   		String fontsize=request.getParameter("daxiao");	
   		//获取字体大小
   		String yanse=request.getParameter("yanse");	
   		//获取头像
   		String head=request.getParameter("touxiang");
   		//获取IP
   		String ip=request.getRemoteAddr();
   		//获取信息
   		String info=request.getParameter("mess");
   		//获取容器的聊天信息
   		String meg = (String)application.getAttribute("meg");
   		if(info!=null){
   			//对输入的消息，过滤特殊字符
	        info = info.replaceAll("<","&lt;").replaceAll(">","&gt;");
   			if(head!=null){
   				info = ip+"发言："+"<font size='"+fontsize+"' color='"+yanse+"'>"+info+"</font><img src='"+head+"'>"+new Date().toLocaleString();
   			}else{
   				info = ip+"发言："+"<font size='"+fontsize+"' color='"+yanse+"'>"+info+"</font>"+new Date().toLocaleString();
   			}
   			if(meg==null){
   				application.setAttribute("meg",info);
   			}else{
   				meg=meg+info+"<br/>";
   				application.setAttribute("meg",meg);
   			}
   		}
   	 out.println(meg);
   	%>
   		
  </body>
</html>
