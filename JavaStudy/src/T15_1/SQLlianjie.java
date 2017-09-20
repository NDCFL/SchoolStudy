package T15_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.sun.org.apache.bcel.internal.verifier.exc.StaticCodeConstraintException;

public class SQLlianjie {
	
		public static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		public static String url = "jdbc:sqlserver://localhost\\SQL2005:1433;DatabaseName=T15";
		public static String username = "sa";
		public static String password = "123456";
		static Connection con= null;
		static{
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url,username,password); 
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	public static Connection open(){
		try {
			if (con.isClosed()) {
				con = DriverManager.getConnection(url,username,password); 
			}
		}  catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
}
