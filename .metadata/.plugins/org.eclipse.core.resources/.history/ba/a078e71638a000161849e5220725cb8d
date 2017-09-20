package edu.ht.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static String url="jdbc:sqlserver://localhost:1433;databasename=MyQQ";
	private static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String uname="sa";
	private static String pwd="123456";
	
	private static Connection conn=null;
	
	static{//静态语句块(复合语句)
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//获取数据连接
	public static Connection getConnection(){
		try {
			//如果数据库链接是null或者关闭的
			if(conn==null||conn.isClosed()){
				conn=DriverManager.getConnection(url,uname,pwd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void main(String[] args) {
		System.out.println(DBConnection.getConnection());
	}
}
