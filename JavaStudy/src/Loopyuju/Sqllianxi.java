package Loopyuju;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Sqllianxi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String driverString="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://localhost\\sql2005:1433;database=school";
		String user="sa";
		String password="123456";
		try {
			Class.forName(driverString);
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("连接成功");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from SC");
			while (rs.next()) {
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t");
				
			}
			int rs2=st.executeUpdate("delete SC where  学号='2'");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
