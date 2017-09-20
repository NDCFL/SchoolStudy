package ShowDemo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLyujuimp implements SQLyuju{

	Connection con = SQLCon.openDB();
	public int barsum() {
		int barsum=0;
		try {
			Statement st = con.createStatement();
			String sql = "select count(*)  from vote";
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()){
				barsum = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("查询记录总数出错！");
		}
		return barsum;
	}
	public List<VoteBean> votelist(int pagesize, int startpage) {
		List<VoteBean> votelist = new ArrayList<VoteBean>();
		try {
			Statement st = con.createStatement();
			String sql = "select top("+pagesize+") studentname,studentcount from vote where studentid not in (select top ("+startpage+") studentid from vote order by studentid)";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				VoteBean votebean = new VoteBean();
				votebean.setStudentname(rs.getString("studentname"));
				votebean.setStudentcount(rs.getInt("studentcount"));
				votelist.add(votebean);
			}
		} catch (Exception e) {
			System.out.println("查询分页出错！");
		}
		return votelist;
	}

}
