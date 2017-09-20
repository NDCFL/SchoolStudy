package Pool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Teachersqlimp implements Teachersql{

	Connection con = SQLPool.getconsqlpool();
	public List<TeacherBean> list() {
		List<TeacherBean> list = new ArrayList<TeacherBean>();
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from teacher");
			while (rs.next()) {
				TeacherBean bean = new TeacherBean();
				bean.setTeacherid(rs.getInt("teacherid"));
				bean.setTeachername(rs.getString("teachername"));
				bean.setTeachergread(rs.getFloat("teachergread"));
				list.add(bean);
			}
		} catch (SQLException e) {
			System.out.println("查询教师等级出错！");
		}
		return list;
	}

	public void teacheradd(TeacherBean bean) {
		try {
			Statement st = con.createStatement();
			String sql = "insert into teacher values('"+bean.getTeachername()+"',"+bean.getTeachergread()+")";
			st.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("添加教师语句出错！");
		}
	}
	public void teacherdel(String teacherid) {
		try {
			Statement st = con.createStatement();
			st.executeUpdate("delete teacher where teacherid="+teacherid);
		} catch (SQLException e) {
			System.out.println("删除教师语句出错！");
		}
		
		
	}

	public void teacherupdate(TeacherBean bean) {
		try {
			Statement st = con.createStatement();
			String sql = "update teacher set teachername='"+bean.getTeachername()+"',teachergread="+bean.getTeachergread()+" where teacherid="+bean.getTeacherid();
			System.out.println(sql);
			st.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("更新教师语句出错！");
		}
		
		
	}

	public TeacherBean bean(String teacherid) {
		TeacherBean bean = null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from teacher where teacherid="+teacherid);
			if(rs.next()){
				bean = new TeacherBean();
				bean.setTeacherid(rs.getInt("teacherid"));
				bean.setTeachergread(rs.getFloat("teachergread"));
				bean.setTeachername(rs.getString("teachername"));
			}
		} catch (SQLException e) {
			System.out.println("教师单个查询语句出错！");
		}
		return bean;
	}

}
