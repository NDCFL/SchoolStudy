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
��ѡ����ҳʹ�õ��ض���ʽ��<br>
<input type="radio" name="redirectType" value="0" checked> ʹ��response.sendRediredt<br>
<input type="radio" name="redirectType" value="1" > ʹ��jsp:forward<br>
<input type="submit" name="submit" value="ȷ��">
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