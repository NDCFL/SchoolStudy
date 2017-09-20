package T7;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Studentsqlimp implements Studentsql{

	Connection con = SQLCon.openDB();
	public List<StudentBean> list() {
		List<StudentBean> list = new ArrayList<StudentBean>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select studentname,studentcount from vote order by studentcount desc");
			while (rs.next()) {
				StudentBean bean = new StudentBean();
				bean.setStudentinf(rs.getString("studentname"));
				bean.setStudentcount(rs.getInt("studentcount"));
				list.add(bean);
			}
		} catch (SQLException e) {
			System.out.println("查询学生语句出错！");
		}
		
		return list;
	}   

	public void addcount(StudentBean bean) {
		try {
			Statement st = con.createStatement();
			for(int j=0;j<bean.getStudentname().length;j++){
				String sql = "update vote set studentcount=(select studentcount from vote where studentname='"+bean.getStudentname(j)+"')+1 where studentname='"+bean.getStudentname(j)+"'";
				System.out.println(sql);
				st.executeUpdate(sql);
			}
		} catch (SQLException e) {
			System.out.println("学生票数增加出错！");
		}
	}
	public List<StudentBean> studentlist() {
		List<StudentBean> list = new ArrayList<StudentBean>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from vote");
			while (rs.next()) {
				StudentBean bean = new StudentBean();
				bean.setStudentinf(rs.getString("studentname"));
				list.add(bean);
			}
		} catch (SQLException e) {
			System.out.println("查询学生列表出错！");
		}
		return list;
	}

	public void addstudent(String studentname) {
		try {
			Statement st = con.createStatement();
			st.executeUpdate("insert into vote values('"+studentname+"',0)");
		} catch (SQLException e) {
			System.out.println("新增学员出错！");
		}
		
		
	}
	

}
