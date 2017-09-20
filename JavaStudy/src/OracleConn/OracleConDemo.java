package OracleConn;
import java.sql.*;
public class OracleConDemo{
	public static void main(String args[]){
		new OracleConDemo();
	}
	public OracleConDemo(){
	    try{
	    	Class.forName("oracle.jdbc.driver.OracleDriver");
	        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.22:1521:orcl","sys as sysdba","lsh");
			Statement st = conn.createStatement();
			String sql = "select * from stud";
			ResultSet rs = st.executeQuery(sql);
			System.out.println("学号\t姓名");
			while(rs.next()){
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
			}
			rs.close();
			st.close();
			conn.close();
		 }catch (Exception e) {
		 	System.out.println("连接失败");
		 	e.printStackTrace();
		 }
	}
}
