package Pool;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class SQLPool {

	public static Connection getconsqlpool(){
		Connection con = null;
		try {
			Context init = new InitialContext(); 
			Context context = (Context)init.lookup("java:comp/env");
			DataSource ds = (DataSource)context.lookup("conpool");
			con = ds.getConnection();
		} catch (Exception e) {
			System.out.println("连接池出现问题！");
		}
		return con;
	}
	
}
