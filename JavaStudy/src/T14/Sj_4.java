package T14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Sj_4 {
		
		public static void main(String[] a) {
			String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			String url = "jdbc:sqlserver://localhost\\SQL2005:1433;databasename=T14";
			String username = "sa";
			String password = "123456";
			try {
				Class.forName(driver);
				Connection co = DriverManager.getConnection(url, username, password);
				PreparedStatement ps = co.prepareStatement("select * from zuoye where id=?");
				ps.setInt(1,1);
				ResultSet rs=ps.executeQuery();
				while (rs.next()) {
					System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
				}
			} catch (Exception e) {
				e.printStackTrace(); 
			} 
		}

}


