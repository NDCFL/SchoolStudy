package StudentManger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConection {

	private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; //驱动
	private static String url = "jdbc:sqlserver://localhost\\SQL2005:1433;databasename=study";
	private static String username="sa";
	private static String password="123456";
	private static Connection conn=null;
	//静态语句块
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
	
	//连接数据库
	public static Connection openDB(){
		try {
			//如果连接已经关闭
			if(conn.isClosed()){
				conn = DriverManager.getConnection(url,username,password);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
