package MySqlConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MysqlConnDemo {

	public static void main(String args[]){
		new MysqlConnDemo();
	}
	public MysqlConnDemo(){
	    try{
	    	Class.forName("com.mysql.jdbc.Driver");
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqlstudy?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","cfl,1997");
			Statement st = conn.createStatement();
			String sql = "select * from stud";
			ResultSet rs = st.executeQuery(sql);
			System.out.println("学号\t姓名");
			while(rs.next()){
				System.out.println(rs.getString(1)+"\t"+rs.getString(2));
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
