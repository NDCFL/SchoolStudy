<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
   <h1 align="center">图书价格览表</h1>
   <hr color="bule" size="5px">
   <jsp:useBean id="ue" class="T7.SQL"></jsp:useBean>
	<%
			Class.forName(ue.getDriver());
			Connection con = DriverManager.getConnection(ue.getUrl(),ue.getUsername(),ue.getPassword());
			Statement st = con.createStatement();
   			ResultSet rs = st.executeQuery("select * from shop");
   			out.println("<html><head><title>图书价格览表</title></head><body><table align='center'><tr><td><a href='shopadd.jsp'> 新 增</a></td></tr></table><table border='1' align='center' width='500' height='400'><tr><td colspan='6' align='center'>图书价格览表</td></tr>");
   			out.println("<tr><td align='center'>编号</td><td align='center'>书名</td><td align='center'>价格(元)</td><td align='center'>数量(本)</td><td align='center'>作者</td><td align='center'> 操 作 </td></tr>");
   			while(rs.next()){
   				out.println("<tr><th align='center'>"+rs.getInt(1)+"</th><td align='center'>"+rs.getString(2)+"</td><td align='center'>"+rs.getFloat(3)+"</td><td align='center'>"+rs.getInt(4)+"</td><td align='center'>"+rs.getString(5)+"</td>");
   	%>
   				<td align="center">
   				<a href="shopalter.jsp?id=<%=rs.getInt(1) %>"> 修 改 </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   				<a href="shopdel.jsp?id=<%=rs.getInt(1) %>" onclick="javascript:if(confirm('删除确认')){return true;}else{return false;}"> 删 除 </a>
   				</td>
   	<%
   				out.println("</tr>");
   			}
   			out.println("</table></body></html>");
   			rs.close();
   			st.close();
   			con.close();
   %>
