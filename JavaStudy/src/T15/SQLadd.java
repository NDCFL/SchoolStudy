package T15;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Random;

public class SQLadd {

	public static void main(String[] args) {
		Connection con = SQLConection.openDB();
		try {
			Statement st = con.createStatement();
			for (int i = 100000; i <200000; i++) {
				String sql = "insert into course values("+i+",'sql"+i+"')";
				System.out.println(sql);
				st.executeUpdate(sql);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("添加记录出错！");
		}
		
	}

}
