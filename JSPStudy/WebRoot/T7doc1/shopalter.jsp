<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>、
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'privacealter.jsp' starting page</title>
    
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
  <h1 align="center">修改商店资料</h1>
   		<form action="shopaltersave.jsp" method="post">
		   <jsp:useBean id="ue" class="T7.SQL"></jsp:useBean>
	<%
			Class.forName(ue.getDriver());
			Connection con = DriverManager.getConnection(ue.getUrl(),ue.getUsername(),ue.getPassword());
			Statement st = con.createStatement();
   			ResultSet rs = st.executeQuery("select * from shop where id="+request.getParameter("id"));
   			out.println("<html><head><title>图书信息览表</title></head><body><table border='0' align='center'><tr></tr>");
	   			out.println("<tr height='40'><td align='center'>书名</td><td align='center'>价格(元)</td><td align='center'>数量(本)</td><td align='center'>作者</td></tr>");
   			while(rs.next()){
   				out.println("<tr height='40'><td align='center'><input type='text' name='name' value='"+rs.getString(2)+"'></td><td align='center'><input type='text' name='price' value='"+rs.getFloat(3)+"'></td><td align='center'><input type='text' name='num' value='"+rs.getInt(4)+"'></td><td align='center'><input type='text' name='writer' value='"+rs.getString(5)+"'></td>");
   				out.println("</tr>");
   				out.println("<tr><td colspan='5' align='center'><input type='submit' name='sub' value='  确  认  修  改  '></td></tr>");
   			}
   	%>
   				<tr><td colspan="5"><input type="hidden" name="saveid" value="<%=request.getParameter("id")%>"></td></tr>
   	<%
   			out.println("</table></body></html>");
   			rs.close();
   			st.close();
   			con.close();
   %>
	    </form>
  </body>
</html>
