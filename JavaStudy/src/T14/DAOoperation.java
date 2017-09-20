package T14;

import java.sql.*;
import java.util.Vector;

public class DAOoperation {
	Statement st;
	Vector data = new Vector();

	public DAOoperation(String serverName, String dataBase, String userName,String passWord) {
		this.connect(serverName, dataBase, userName, passWord);
	}

	public void connect(String serverName, String dataBase, String userName,String passWord) {
		try {
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			Connection cn = DriverManager.getConnection(
					"jdbc:microsoft:sqlserver://" + serverName
							+ ":1433;databasename=" + dataBase, userName,
					passWord);
			st = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = st.executeQuery("select name,number from roots");
			ResultSetMetaData rsmd = rs.getMetaData();
			int num = rsmd.getColumnCount();
			while (rs.next()) {
				Vector row = new Vector();
				for (int i = 1; i < num + 1; i++) {
					String s = rs.getString(i);
					row.add(s);
				}
				data.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Vector getData() {
		return data;
	}

	public void addData(String name, String number) {
		try {
			st.executeUpdate("insert into roots values('" + name + "','"
					+ number + "')");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
