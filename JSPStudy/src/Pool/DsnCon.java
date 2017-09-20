package Pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DsnCon {

	private static String driver = "sun.jdbc.odbc.JdbcOdbcDriver"; //驱动
	private static String url = "jdbc:odbc:jsp";
	private static String username="sa";
	private static String password="123456";
	private static Connection conn=null;
	static{
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection openDB(){
		try {
			if(conn.isClosed()){
				conn = DriverManager.getConnection(url,username,password);
			}
		}catch (SQLException e) {
			System.out.println("数据库处于关闭状态");
		}
		return conn;
	}
	
}
