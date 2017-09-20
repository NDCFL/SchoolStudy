<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>1~N之间的素数的个数</title>
  </head>
  <body>
    <%
    	String N = request.getParameter("text1");
		if(N==null){
			N="0";
		}
		int n = Integer.parseInt(N);
		out.println("1~"+n+"之间的素数个数如下："+"<br/>");
		int sum=0,count=0;
    	for(int i=2;i<=n;i++){
    		sum=0;
    		for(int j=2;j<i;j++){
    			if(i%j==0){
    				sum=1;
    				break;
    			}
    		}
    		if(sum==0){
    			if(i<10){
    				out.println(i+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
    				count++;
    			}else{
    				out.println(i+"&nbsp;&nbsp;&nbsp;&nbsp;");
    				count++;
    				if(count%5==0){
    					out.println("<br/>");
    				}
    			}
    		}
    	}
    %>
  </body>
</html>
