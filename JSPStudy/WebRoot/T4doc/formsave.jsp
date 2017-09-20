<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'formsave.jsp' starting page</title>
  </head>

  <body>
  <%
  	request.setCharacterEncoding("utf-8");
  
  %>
    性别：<%=request.getParameter("sex") %><br/>
    婚姻：<%=request.getParameter("marry") %><br/>
    <%
    	String hobbys[] = request.getParameterValues("hobby");
    	String str = "";
    	if(hobbys!=null){
    		for(int i=0;i<hobbys.length;i++){
    			str+=hobbys[i]+" ";
    		}
    	}
    		
    %>
    爱好：<%=str %>
  </body>
</html>
