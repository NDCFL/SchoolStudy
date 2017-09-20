package SQLBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import SQLBean.Privacebean;

public class Privacesqlsentenceimp implements Privacesqlsentence{

	Connection con = SQLCon.openDB();
	public void privaceadd(Privacebean privacebean) {
   		try {
   			Statement st = con.createStatement();
			st.executeUpdate("insert into privace values('"+privacebean.getPrivaceName()+"')");
			st.close();
   		} catch (SQLException e) {
			System.out.println("省份的添加语句出错了！");
		}
		
		
	}

	public void privacedel(int privaceid) {
   		Statement st;
		try {
			System.out.println("privaceid="+privaceid);
			st = con.createStatement();
			st.executeUpdate("delete city where cityid="+privaceid+";"+"delete privace where privaceid="+privaceid);
			st.close();
		} catch (SQLException e) {
			System.out.println("SQL语句中的删除语句出错了！");
		}
	}

	public List<Privacebean> privacelist() {
		List<Privacebean> list = new ArrayList<Privacebean>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from privace order by privaceid asc");
			while (rs.next()) {
				Privacebean privacebean = new Privacebean();
				privacebean.setPrivaceid(rs.getInt("privaceid"));
				privacebean.setPrivaceName(rs.getString("privaceName"));
				list.add(privacebean);
			}
		} catch (SQLException e) {
			System.out.println("查询城市语句出错！");
		}
		
		return list;
	}

	public void privaceupdate(Privacebean privacebean) {
		
  		Statement st;
		try {
			st = con.createStatement();
			String sql ="update privace set privacename='"+privacebean.getPrivaceName()+"' where privaceid="+privacebean.getPrivaceid();
	  		st.executeUpdate(sql);
	  		st.close();
		} catch (SQLException e) {
			System.out.println("省份更新数据出错了！");
		}
  		
		
	}

	public List<Privacebean> privacelist(int pagesize, int startpage) {
		List<Privacebean> list = new ArrayList<Privacebean>();
		try {
			Statement st = con.createStatement();
			String sql ="select top "+pagesize+"* from privace where privaceid not in(select top "+startpage+" privaceid from privace order by privaceid asc)order by privaceid asc"; 
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Privacebean privacebean = new Privacebean();
				privacebean.setPrivaceid(rs.getInt("privaceid"));
				privacebean.setPrivaceName(rs.getString("privaceName"));
				list.add(privacebean);
			}
		} catch (SQLException e) {
			System.out.println("查询页面省份语句出错！");
		}
		
		return list;
	}

	public int sumbar() {
		int n=0;
		try {
			Statement st = con.createStatement();
			ResultSet rs =  st.executeQuery("select count(*) cnt from privace");
			if(rs.next()){
				n = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("查询城市总计录条数出错！");
		}
		return n;
	}

	public List<Privacebean> cityalllist(String privacename) {
		List<Privacebean> list = new ArrayList<Privacebean>();
		try {
			Statement st = con.createStatement();
			String sql ="select cityname from city where privaceid = (select privaceid from privace where privacename='"+privacename+"')"; 
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Privacebean privacebean = new Privacebean();
				privacebean.setPrivaceName(rs.getString("cityname"));
				list.add(privacebean);
			}
		} catch (SQLException e) {
			System.out.println("查询对应的城市语句出错！");
		}
		
		return list;
	}

	
}
