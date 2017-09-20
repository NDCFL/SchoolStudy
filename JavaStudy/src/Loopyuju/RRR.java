package Loopyuju;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class RRR {

	public static void main(String[] args) {
		int n=0;
		for (int i = 2; i < 100; i++) {
			n=0;
			for (int j=1; j <i; j++) {
				if (i%j==0) {
					n=1;
					break;
				}
			}
			if (n==0) {
				System.out.println(i);
			}
		}
		
	}
	public void lianjie(){
		
		
		try {
			String driver="com.microsofe.sqlsever.jdbc.SQLSeverDriver";
			String url="jdbc:sqlsever://lochost\\SQL2005:1433;databasename=T12";
			String password="123456";
			String name="sa";
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,name,password);
			Statement st = con.createStatement();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
