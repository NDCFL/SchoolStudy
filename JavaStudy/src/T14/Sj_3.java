package T14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Sj_3 {

	public static void main(String[] args) {
		
	}
	public void table(String columname){
		String str = "select top(1) * from "+columname;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQL2005:1433;databasename=T14","sa","123456");
			
		} catch (ClassNotFoundException e) {
			System.out.println("找不到该类！！");
		} catch (SQLException e) {
			System.out.println("SQL语句出现异常！！！");
		}
		
	}
}
