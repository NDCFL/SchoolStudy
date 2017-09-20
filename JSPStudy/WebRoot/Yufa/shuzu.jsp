<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'shuzu.jsp' starting page</title>
  </head>
  
  <body>
  <h1>1到100的值</h1>
   <%
   	//int n[]={3,4,1,2,23,45,56,565};
   	int sum=0;
   	for(int i=1;i<=100;i++){
   		sum+=i;
   	}
   	out.println("1到100的值为："+sum);
   %>
   <hr/>
   <br/>
   <h1>&lt%运算符的区别%></h1>
   <br/>
   <%
   	int count=0;
   
   %>
   <%
	 count++;
   	 out.println("count一共访问了："+count+"次！");
   %>
   该运算符刷新不会自增！！！！
   <hr/>
   <br/>
   <h1>&lt%!运算符的区别%></h1>
   <br/>
   <%!
   	int count1=0;
   
   %>
   <%
	 count1++;
   	 out.println("count1一共访问了："+count1+"次！");
   %>
   该运算符刷新会自增！！！！数据是共享的相当于Java的静态变量
   
    <hr/>
   <br/>
   <h1>&lt%=运算符的区别%></h1>
   <br/>
   <%!
   	int count2=0;
   %>
   count2的值<%=++count2%>
   当前时间：<%=new Date().toLocaleString()%>
   该运算符刷新会自增！！！！数据是共享的相当于Java的静态变量
   
    <hr/>
   <br/>
   <h1>&lt九九乘法表></h1>
   <br/>
   <%
   		for(int i=1;i<=9;i++){
   			for(int j=1;j<=i;j++){
   				out.println(j+"*"+i+"="+i*j+"&nbsp;&nbsp;&nbsp;&nbsp;");
   			}
   			out.println("<br/>");
   		}
   %>
   <hr/>
   <br/>
   <h1>&lt%九九乘法表%></h1>
   <br/>
	<%
			for(int i=1;i<=9;i++){
				for(int j=1;j<=i;j++){
	%>
					<%=j%>*<%=i%>=<%=i*j%>&nbsp;&nbsp;&nbsp;&nbsp;
	<%
				}
	%>
	<br/>
	<% 
			}
	%>
	
	<hr/>
   <br/>
   <h1>&lt%菱形%></h1>
   <br/>
	<%
		int hang=9,xinhao,kongge;
		int zhongjian=hang/2+1;
		for(int i=1;i<=zhongjian;i++){
	  		xinhao=i*2-1;
	  		kongge=(hang-xinhao)/2;
	  		for(int j=0;j<kongge;j++)
	  		{
	  			out.println("&nbsp;&nbsp;");
	  		}
	  		for(int j=1;j<=xinhao;j++)
	  		{
	  			out.println("*");
	  				
	  		}
	  		out.println("<br/>");
		}
		for(int i=zhongjian-1;i>0;i--){
	  		xinhao=i*2-1;
	  		kongge=(hang-xinhao)/2;
	  		for(int j=0;j<kongge;j++)
	  		{
	  			out.println("&nbsp;&nbsp;");
	  		}
	  		for(int j=1;j<=xinhao;j++)
	  		{
	  			out.println("*");
	  				
	  		}
	  		out.println("<br/>");
		}
		
		
	%>
	<hr/>
	<br/>
		<h1>&lt%平行四边形%></h1>
	<br/>
	<%
		int hang1=6;
		for(int i=1;i<hang1;i++){
			for(int j=0;j<=i;j++){
				out.println("&nbsp;");
			}
			for(int k=1;k<=6;k++){
				out.println("*");
			}
			out.println("<br/>");
		}
	%>	   
  </body>
</html>
