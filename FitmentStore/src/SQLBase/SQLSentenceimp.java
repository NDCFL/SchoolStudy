package SQLBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import SQLBean.ProvinceBean;
import SQLBean.UserBean;
import SQLCon.SQLCon;

public class SQLSentenceimp implements SQLSentence{

	Connection con = SQLCon.openDB();
	public void addprovince(ProvinceBean provincebean) {
		// TODO Auto-generated method stub
		
	}

	public void delprovince(int provinceid) {
		// TODO Auto-generated method stub
		
	}

	public List<ProvinceBean> provincelist() {
		// TODO Auto-generated method stub
		return null;
	}

	public void updataeprovince(ProvinceBean provincebean) {
		// TODO Auto-generated method stub
		
	}

	public List<ProvinceBean> provincelist(int pagesize, int startpage) {
		List<ProvinceBean> list = new ArrayList<ProvinceBean>();
		try {
			Statement st = con.createStatement();
			String sql = "select top("+pagesize+") p.*,c.* from province p,city c where p.provinceid=c.provinceid and cityid not in (select top("+startpage+") cityid from city) order by cityid asc";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				ProvinceBean provincebean = new ProvinceBean();
				provincebean.setCityName(rs.getString("cityName"));
				provincebean.setProvinceName(rs.getString("provinceName"));
				provincebean.setProvinceid(rs.getInt("provinceid"));
				list.add(provincebean);
			}
		} catch (Exception e) {
			System.out.println("查询省份城市列表出错！");
			e.printStackTrace();
		}
		return list;
	}

	public int sumbar(String sql) {
		int sumbar=0;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()){
				sumbar = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("查询总记录条数出错！");
			e.printStackTrace();
		}
		return sumbar;
	}

	public void adduser(UserBean userbean) {
		try {
			Statement st = con.createStatement();
			String sql = "insert into users values(";
			sql+="'"+userbean.getUsermobile()+"',";
			sql+="'"+userbean.getUserpassword()+"',";
			sql+="'"+userbean.getUsername()+"',";
			sql+="'"+userbean.getUserface()+"',";
			sql+="'"+userbean.getUsersex()+"',";
			sql+="'"+userbean.getUserhomeaddress()+"',";
			sql+="'"+userbean.getUseremail()+"',";
			sql+="getdate(),";
			sql+="'"+userbean.getProvinceid()+"',";
			sql+="'"+userbean.getCityid()+"',";
			sql+="'"+userbean.getLeibie()+"'";
			sql+=")";
			System.out.println(sql);
			st.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println("用户的新增出错！");
			e.printStackTrace();
		}
		
	}

	public void deluser(int userid) {
		// TODO Auto-generated method stub
		
	}

	public void updateuserbean(UserBean userbean) {
		// TODO Auto-generated method stub
		
	}

	public List<UserBean> userlist() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UserBean> userlist(int pagesize, int startpage) {
		// TODO Auto-generated method stub
		return null;
	}
	public int finduser(String mobilephone){
		int m=0;
		try {
			Statement st = con.createStatement();
			String sql = "select count(*) from users where usermobile='"+mobilephone+"'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()){
				m = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("查找用户失败");
			e.printStackTrace();
		}
		return m;
	}
	public UserBean logincheck(String name){
		UserBean userbean = new UserBean();
		try {
			Statement st = con.createStatement();
			String sql = "select *  from users where usermobile='"+name+"'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()){
				userbean.setUsermobile(rs.getString("usermobile"));
				userbean.setUserpassword(rs.getString("userpassword"));
				userbean.setUsername(rs.getString("username"));
				userbean.setUserface(rs.getString("userface"));
				userbean.setUsersex(rs.getInt("usersex"));
				userbean.setUserhomeaddress(rs.getString("userpassword"));
				userbean.setUseremail(rs.getString("userpassword"));
				userbean.setProvinceid(rs.getInt("provinceid"));
				userbean.setCityid(rs.getInt("cityid"));
				userbean.setLeibie(rs.getInt("leibie"));
				userbean.setUserregisterdate(rs.getString("userpassword"));
			}
		} catch (Exception e) {
			System.out.println("用户登录控制失败");
			e.printStackTrace();
		}
		return userbean;
	
	}
}
