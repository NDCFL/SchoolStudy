package T3.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class test {
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url="jdbc:sqlserver://localhost:1433;databasename=access";
	String username="sa";
	String password="123456";
	public static void main(String[] args) {
		test s = new test();
		s.pre();
	}
	public void pre(){
		try {
			Class.forName(driver);
			Connection co = DriverManager.getConnection(url,username,password);
			PreparedStatement ps = co.prepareStatement("select * from student");
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
