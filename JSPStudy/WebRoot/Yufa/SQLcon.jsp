<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
   <h1 align="center">图书价格览表</h1>
   <hr color="bule" size="5px">
   <%
   		String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
   		String url = "jdbc:sqlserver://localhost:1433;databasename=jsp";
   		String username="sa";
   		String password="123456";
   		try{
   			Class.forName(driver);
   			Connection con = DriverManager.getConnection(url,username,password);
   			Statement st = con.createStatement();
   			ResultSet rs = st.executeQuery("select * from shop");
   			out.println("<html><head>图书价格览表</head><body><table border='1' align='center' width='300' height='400'><tr><td colspan='3' align='center'>图书价格览表</td></tr>");
   			out.println("<tr><td align='center'>编号</td><td align='center'>书名</td><td align='center'>价格(元)</td></tr>");
   			while(rs.next()){
   				out.println("<tr><th align='center'>"+rs.getInt(1)+"</th><td align='center'>"+rs.getString(2)+"</td><td align='center'>"+rs.getFloat(3)+"</td></tr>");
   			}
   			out.println("</table></body></html>");
   			rs.close();
   			st.close();
   			con.close();
   		}catch(Exception e){
   			e.printStackTrace();
   			
   		}
   %>
