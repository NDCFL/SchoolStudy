package T14;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Sql {

	/**
	 * 设access数据库中有student表，表中存放学生学号，姓名两个字段，
	 * 请编写程序输出表中所有记录信息。假定
		username=sa , 
		password=””，
		driver=“com.microsoft.jdbc.sqlserver.SQLServerDriver”,
		url=“jdbc:Microsoft:sqlserver://localhost:1433;DatabaseName=access”

	 * 
	 * */
	public static void main(String[] args) {
		
		try {
			Properties pp = new Properties();
			pp.load(new FileReader(".\\SystemFile"));
			String driver = pp.getProperty("driver");
			String url = pp.getProperty("url");
			String username = pp.getProperty("username");
			String password = pp.getProperty("password");
			Class.forName(driver);
			Connection ct = DriverManager.getConnection(url,username,password);
			Statement st = ct.createStatement();
			ResultSet rs = st.executeQuery("select * from student");
			while (rs.next()) {
				System.out.println("id="+rs.getString(1)+"\tname="+rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
