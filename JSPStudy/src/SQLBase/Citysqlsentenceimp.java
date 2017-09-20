package SQLBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import SQLBean.Citybean;
import SQLBean.Privacebean;

public class Citysqlsentenceimp implements Citysqlsentence {

	Connection con = SQLCon.openDB();
	public void cityadd(Citybean citybean) {
		try {
			Statement st = con.createStatement();
			String sql = "insert into city values('" + citybean.getCityname()
					+ "'," + citybean.getPrivaceid() + ")";
			st.executeUpdate(sql);
			st.close();
		} catch (SQLException e) {
			System.out.println("城市的添加语句出错了！");
		}
	}

	public void citydel(int cityid) {
		Statement st;
		try {
			System.out.println("cityid=" + cityid);
			st = con.createStatement();
			st.executeUpdate("delete city where cityid=" + cityid);
			st.close();
		} catch (SQLException e) {
			System.out.println("SQL语句中的删除语句出错了！");
		}
	}

	public List<Citybean> citylist() {
		List<Citybean> list = new ArrayList<Citybean>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st
					.executeQuery("select c.*,p.privaceName from city c inner join privace p on c.privaceid=p.privaceid order by p.privaceid,c.cityid");
			while (rs.next()) {
				// 最关键的一步
				Citybean citybean = new Citybean();
				citybean.setCityid(rs.getInt("cityid"));
				citybean.setCityname(rs.getString("cityname"));
				citybean.setPrivaceid(rs.getInt("privaceid"));
				citybean.setPrivacename(rs.getString("privacename"));
				list.add(citybean);
			}
			rs.close();
			st.close();
		} catch (Exception e) {
			System.out.println("sql语句的实现类中的sql查询语句出错！");
		}
		return list;
	}

	public void cityupdate(Citybean citybean) {
		try {
			Statement st = con.createStatement();
			String sql = "update city set cityName='" + citybean.getCityname()
					+ "',privaceid=" + citybean.getPrivaceid()
					+ " where cityid=" + citybean.getCityid();
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
		} catch (SQLException e) {
			System.out.println("城市的更新语句出错了！");
		}

	}

	public List<Privacebean> privacelist() {
		List<Privacebean> list = new ArrayList<Privacebean>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st
					.executeQuery("select * from privace order by privaceid asc");
			while (rs.next()) {
				Privacebean privacebean = new Privacebean();
				privacebean.setPrivaceid(rs.getInt("privaceid"));
				privacebean.setPrivaceName(rs.getString("privaceName"));
				list.add(privacebean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Citybean findcity(String cityid) {
		Citybean city = null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from city where cityid="
					+ cityid);
			if (rs.next()) {
				city = new Citybean();
				city.setCityid(rs.getInt("cityid"));
				city.setCityname(rs.getString("cityname"));
				city.setPrivaceid(rs.getInt("privaceid"));
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return city;

	}

	public int pagebarsum() {
		int barsum=0;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select count(*) cnt from city");
			if(rs.next()){
				barsum = rs.getInt(1);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			System.out.println("查询城市的记录总数出错！");
		}
		return barsum;
	}

	public List<Citybean> citylist(int pagebarsize, int startlocal) {
		List<Citybean> list = new ArrayList<Citybean>();
		try {
			Statement st = con.createStatement();
			String sql = "select top "+pagebarsize+" c.*,p.privaceName from city c inner join privace p on c.privaceid=p.privaceid where cityid not in (select top "+startlocal+" cityid from city order by privaceid) order by p.privaceid ";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				// 最关键的一步
				Citybean citybean = new Citybean();
				citybean.setCityid(rs.getInt("cityid"));
				citybean.setCityname(rs.getString("cityname"));
				citybean.setPrivaceid(rs.getInt("privaceid"));
				citybean.setPrivacename(rs.getString("privacename"));
				list.add(citybean);
			}
			rs.close();
			st.close();
		} catch (Exception e) {
			System.out.println("分页查询城市语句出错！");
		}
		return list;
	}
}
