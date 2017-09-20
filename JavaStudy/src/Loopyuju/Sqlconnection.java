package Loopyuju;

import java.sql.Connection;
import java.sql.DriverManager;

public class Sqlconnection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://localhost\\sql2005:1433;databasename=school";
		String user = "sa";
		String password = "123456";
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,user,password);
			System.out.println("连接成功！！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
