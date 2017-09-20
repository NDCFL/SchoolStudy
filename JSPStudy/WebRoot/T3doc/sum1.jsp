<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>1~N的和</title>
  <body>
   	<%
   		String N = request.getParameter("text1");
   		if(N==null){
   			N="0";
   		}
   		int n = Integer.parseInt(N);
   		int sum=0;
   		out.println("1~"+n+"的和为"+"<br/>");
		for(int i=1;i<=n;i++){
			sum+=i;
		}  
		out.println(sum);
   	%>
  </body>
</html>
