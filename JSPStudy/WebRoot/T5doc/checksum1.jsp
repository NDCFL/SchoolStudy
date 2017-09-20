<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

   <%
   		String  num = (String)request.getAttribute("num");
   		out.println(num);
   		int sum=0;
   		if(num!=null){
   			int n = Integer.parseInt(num);
   			for(int i=1;i<=n;i++){
				sum+=i;
			}
			out.println("1~"+num+"的和为："+sum+"<br/>");
   		}else{
   	%>
			<h1>欢迎选择重定向！！！</h1>
	<%
   			
   		}
   %>
 