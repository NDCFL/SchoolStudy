package T14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Sj_1 {

	public static void main(String[] args) {
		
		try {	
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQL2005:1433;databasename=T14","sa","123456"); 
			Statement sta = con.createStatement();
			ResultSet re = sta.executeQuery("select * from zuoye");
			while (re.next()) {
				System.out.println(re.getString("id")+"\t"+re.getString("name")+"\t"+re.getString("age")+"\t"+re.getString("sex"));
			}
			re.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
