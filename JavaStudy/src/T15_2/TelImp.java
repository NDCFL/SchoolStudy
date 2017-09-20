package T15_2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import T15_1.SQLlianjie;

public class TelImp implements TelSQL{

	public void add(Telbean telbean) {
		Connection con = SQLlianjie.open();
		String SQL = "insert into Telnumber values(?,?)";
		try {
			int i=1;
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setString(i++, telbean.getName());
			ps.setString(i++, telbean.getTelnumber());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean isExit(String telnumber){
		boolean isexit = false;
		Connection con = SQLlianjie.open();
		String SQL = "select * from Telnumber where telnumber='"+telnumber+"'";
		try {
			Statement sta = con.createStatement();
			ResultSet re  = sta.executeQuery(SQL);
			if (re.next()) {
				isexit=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isexit;
	}
	public void Up(Telbean tb) {
		Connection con = SQLlianjie.open();
		String SQL = "select * from ";
		try {
			CallableStatement cs = con.prepareCall("{call GetPhoneNumber(?,?)}");
			Statement sta = con.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
