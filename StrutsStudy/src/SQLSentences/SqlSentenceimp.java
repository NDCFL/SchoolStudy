package SQLSentences;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import SQLConn.SQLCon;

import struts.form.StudentForm;

public class SqlSentenceimp {

	Connection conn = SQLCon.openDB();
	public void addstud(StudentForm  student){
		try {
			Statement st = conn.createStatement();
			String sql = "insert into stud values(";
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
	public List<StudentForm> studentlist(){
		List<StudentForm> list = new ArrayList<StudentForm>();
		try { 
			Statement st = conn.createStatement();
			String sql = "select * from stud";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				StudentForm student = new StudentForm();
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
	public StudentForm findstudent(String sno){
		StudentForm student = new StudentForm();
		try { 
			Statement st = conn.createStatement();
			String sql = "select * from stud where sno='"+sno+"'";
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
	public void delstudent(String sno){
		try {
			Statement st = conn.createStatement();
			String sql = "delete stud where sno='"+sno+"'";
			System.out.println(sql);
			st.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println("删除失败！");
			e.printStackTrace();
		}
	}
	public void updatestudent(StudentForm student){
		try {
			Statement st = conn.createStatement();
			String sql="update stud set ";
			sql+="studentname='"+student.getStudentname()+"',";
			sql+="sage='"+student.getSage()+"',";
			sql+="shobit='"+student.getShobit()+"',";
			sql+="ssex='"+student.getSsex()+"',";
			sql+="szhuanye='"+student.getSzhuanye()+"' where sno='"+student.getSno()+"'";
			System.err.println(sql);
			st.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println("更新数据失败");
			e.printStackTrace();
		}
	}
	public List<StudentForm> studentlist(int pagesize,int startpage){
		List<StudentForm> list = new ArrayList<StudentForm>();
		try { 
			Statement st = conn.createStatement();
			String sql = "select top("+pagesize+")* from stud where sno not in (select top("+startpage+") sno from stud)";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				StudentForm student = new StudentForm();
				student.setShobit(rs.getString("shobit"));
				student.setSzhuanye(rs.getString("szhuanye"));
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
	public int sum(String sql){
		int n = 0;
		try {
			Statement st = conn.createStatement();
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()){
				n = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("查询记录出错！");
			e.printStackTrace();
		}
		return n;
	}
}
