<%@ page  contentType="text/html;charset=GB2312" %>

<html>
<head>
  <title>ResponseRedirect.jsp</title>
</head>
<%
    String s = request.getParameter("redirectType");
	if(s==null){
%>
<form action="ResponseRedirect.jsp"  method="GET">
请选择网页使用的重定向方式：<br>
<input type="radio" name="redirectType" value="0" checked> 使用response.sendRediredt<br>
<input type="radio" name="redirectType" value="1" > 使用jsp:forward<br>
<input type="submit" name="submit" value="确定">
</form>
<%
	}else{
     
	     request.setAttribute("n","50");
		 if(s.equals("0")){
		     response.sendRedirect("Redirect.jsp");
		 }else{
%>
       <jsp:forward page="Redirect.jsp"/>
<%
		 }
     }
%>
<body>
     
</body>
</html>