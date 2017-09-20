package OracleConn;

import java.sql.*;

public class OracleConDemo{

	public static void main(String args[]){
		new OracleConDemo();
	}
	
	public OracleConDemo(){
	    try{
	    	Class.forName("oracle.jdbc.driver.OracleDriver");
	        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","scott","a123456");
			Statement st = conn.createStatement();
			String sql = "insert into stud values(4,'小红',0)";
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			st.close();
			conn.close();
		 }catch (Exception e) {
		 	System.out.println("连接失败");
		 	e.printStackTrace();
		 }
	}
}
