package T1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLlanjie {

	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url="jdbc:sqlserver://localhost:1433;databasename=access";
	String username="sa";
	String password="123456";
	public static void main(String[] args) {
		SQLlanjie s = new SQLlanjie();
//		s.state();
		s.pre();
	}
	public void state(){
		
		try {
			//加载驱动
			
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("连接成功！");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select top 5 * from student");
			while (rs.next()) {

				System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
			}
			rs.close();
			st.close();
			conn.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void pre(){
		try {
			Connection co = DriverManager.getConnection(url,username,password);
			PreparedStatement ps = co.prepareStatement("select * from student");
//			ps.setInt(1, 11);
//			ps.setString(2, "小玲");
//			int n=ps.executeUpdate();
//			System.out.println(n+"记录更新成功！！");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
			}
			ps.close();
			co.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
