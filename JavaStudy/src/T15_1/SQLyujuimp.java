package T15_1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.sun.java_cup.internal.version;

public class SQLyujuimp implements SQLyuju{

	
	public void add(SQLBean sqlbean) {
		//静态的无需再new实例
		Connection con = SQLlianjie.open();
		String SQL = "insert into QQcard values(?,?,?,?,?,?,?)";

		try {
			int n=1;
			PreparedStatement pst = con.prepareStatement(SQL);
			pst.setString(n++, sqlbean.getName().trim());
			pst.setString(n++, sqlbean.getCard().trim());
			pst.setString(n++, sqlbean.getPassword().trim());
			pst.setInt(n++, sqlbean.getSex());
			pst.setInt(n++, sqlbean.getAge());
			pst.setString(n++, sqlbean.getEmail().trim());
			pst.setString(n++, sqlbean.getShuoming().trim());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	public void find(int id) {
		// TODO Auto-generated method stub
		
	}

	public void findAll(SQLBean sqlbean) {
		// TODO Auto-generated method stub
		
	}

	public Vector findlike(String name ,String card) {
		Connection con = SQLlianjie.open();
		String SQL = "select * from QQcard where 1=1";
		if (!name.equals("")) {
			SQL+=" and name like '%"+name+"%'";
		}
		if (!card.equals("")) {
			SQL+=" and card = '"+card+"'";
		}
		SQL+=" order by name";
		System.out.println(SQL);
		Statement sta;
		Vector rowdata = new Vector ();
		try {
		
			sta = con.createStatement();
			ResultSet rs = sta.executeQuery(SQL);
			while (rs.next()) {
				Vector row = new Vector();
				row.addElement(rs.getInt("id"));
				row.addElement(rs.getString("name").trim());
				row.addElement(rs.getString("card").trim());
				row.addElement(rs.getString("password").trim());
				row.addElement(rs.getString("sex".trim()));
				row.addElement(rs.getInt("age"));
				row.addElement(rs.getString("email").trim());
				row.addElement(rs.getString("shuoming").trim());
				rowdata.addElement(row);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowdata;
	}

	public void update(SQLBean sqlbean) {
		// TODO Auto-generated method stub
		
	}
	public boolean isExit(String name){
		boolean exit=false;
		Connection con = SQLlianjie.open();
		String SQL = "select * from QQcard where name='"+name+"'";
		try {
			Statement sta = con.createStatement();
			ResultSet re = sta.executeQuery(SQL);
			if (re.next()) {
				exit = true;
			}
			re.close();
			sta.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exit;
	}
	
}
