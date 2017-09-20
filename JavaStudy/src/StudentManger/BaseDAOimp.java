package StudentManger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class  BaseDAOimp implements BaseDAO{

	Connection conn = SQLConection.openDB();
	@Override
	public void addstudent(StudentVo student) {
		try {
			Statement st = conn.createStatement();
			String sql = "insert into studentmanager values(";
			sql+="'"+student.getSno()+"',";
			sql+="'"+student.getStudentname()+"',";
			sql+="'"+student.getSsex()+"',";
			sql+="'"+student.getSage()+"',";
			sql+="'"+student.getShobit()+"',";
			sql+="'"+student.getSzhuanye()+"')";
			System.out.println(sql);
			st.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println("新增失败");
			e.printStackTrace();
		}
		
	}

	@Override
	public void deletestudent(String sno) {
		try {
			Statement st = conn.createStatement();
			String sql = "delete studentmanager where sno='"+sno+"'";
			System.out.println(sql);
			st.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println("删除失败！");
			e.printStackTrace();
		}
	}

	@Override
	public StudentVo findStudentVo(String sno) {
		StudentVo student = new StudentVo();
		try { 
			Statement st = conn.createStatement();
			String sql = "select * from studentmanager  s  where  sno='"+sno+"'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				student.setSzhuanye(rs.getString("szhuanye"));
				student.setShobit(rs.getString("shobit"));
				student.setSage(rs.getInt("sage"));
				student.setStudentname(rs.getString("studentname"));
				student.setSno(rs.getInt("sno"));
				student.setSsex(rs.getString("ssex"));
			}
		} catch (Exception e) {
			System.out.println("查询失败");
			e.printStackTrace();
		}
		return student;
		
	}

	@Override
	public List<StudentVo> studentlist() {
		List<StudentVo> list = new ArrayList<StudentVo>();
		try { 
			Statement st = conn.createStatement();
			String sql = "select * from studentmanager s ";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				StudentVo student = new StudentVo();
				student.setSzhuanye(rs.getString("Szhuanye"));
				student.setShobit(rs.getString("shobit"));
				student.setSage(rs.getInt("sage"));
				student.setStudentname(rs.getString("studentname"));
				student.setSno(rs.getInt("sno"));
				student.setSsex(rs.getString("ssex"));
				list.add(student);
			}
		} catch (Exception e) {
			System.out.println("查询失败");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void updatestudent(StudentVo studentVo) {
		try {
			Statement st = conn.createStatement();
			String sql="update studentmanager set ";
			sql+="studentname='"+studentVo.getStudentname()+"',";
			sql+="sage='"+studentVo.getSage()+"',";
			sql+="shobit='"+studentVo.getShobit()+"',";
			sql+="ssex='"+studentVo.getSsex()+"',";
			sql+="szhuanye='"+studentVo.getSzhuanye()+"'";
			sql+=" where sno='"+studentVo.getSno()+"'";
			System.err.println(sql);
			st.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println("更新数据失败");
			e.printStackTrace();
		}
		
	}

	@Override
	public List<StudentVo> find(String sql) {
		List<StudentVo> list = new ArrayList<StudentVo>();
		try { 
			Statement st = conn.createStatement();
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				StudentVo student = new StudentVo();
				student.setSzhuanye(rs.getString("Szhuanye"));
				student.setShobit(rs.getString("shobit"));
				student.setSage(rs.getInt("sage"));
				student.setStudentname(rs.getString("studentname"));
				student.setSno(rs.getInt("sno"));
				student.setSsex(rs.getString("ssex"));
				list.add(student);
			}
		} catch (Exception e) {
			System.out.println("查询失败");
			e.printStackTrace();
		}
		return list;
	}

	
}
