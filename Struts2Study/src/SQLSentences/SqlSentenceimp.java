package SQLSentences;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import SQLConn.SQLCon;
import Vo.ClassVo;
import Vo.NationVo;
import Vo.StudentVo;

public class SqlSentenceimp implements SqlSentence{

	Connection conn = SQLCon.openDB();
	public void addstud(StudentVo  student){
		try {
			Statement st = conn.createStatement();
			String sql = "insert into stud values(";
			sql+="'"+student.getSno()+"',";
			sql+="'"+student.getStudentname()+"',";
			sql+="'"+student.getSsex()+"',";
			sql+="'"+student.getSage()+"',";
			sql+="'"+student.getShobit()+"',";
			sql+="'"+student.getSzhuanye()+"',";
			sql+="'"+student.getClassid()+"',";
			sql+="'"+student.getNationid()+"')";
			System.out.println(sql);
			st.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println("新增失败");
			e.printStackTrace();
		}
		
	}
	public List<StudentVo> studentlist(){
		List<StudentVo> list = new ArrayList<StudentVo>();
		try { 
			Statement st = conn.createStatement();
			String sql = "select s.*,c.classname,n.nationname from stud  s ,class c,nation n where s.classid=c.classid and s.nationid=n.nationid";
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
				student.setClassname(rs.getString("classname"));
				student.setNationname(rs.getString("nationname"));
				list.add(student);
			}
		} catch (Exception e) {
			System.out.println("查询失败");
			e.printStackTrace();
		}
		return list;
		
	}
	public StudentVo findstudent(String sno){
		StudentVo student = new StudentVo();
		try { 
			Statement st = conn.createStatement();
			String sql = "select s.*,c.classid,n.nationid from stud  s ,class c,nation n where s.classid=c.classid and s.nationid=n.nationid and sno='"+sno+"'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				student.setSzhuanye(rs.getString("szhuanye"));
				student.setShobit(rs.getString("shobit"));
				student.setSage(rs.getInt("sage"));
				student.setStudentname(rs.getString("studentname"));
				student.setSno(rs.getInt("sno"));
				student.setSsex(rs.getString("ssex"));
				student.setClassid(rs.getInt("classid"));
				student.setNationid(rs.getInt("nationid"));
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
	public void updatestudent(StudentVo student){
		try {
			Statement st = conn.createStatement();
			String sql="update stud set ";
			sql+="studentname='"+student.getStudentname()+"',";
			sql+="sage='"+student.getSage()+"',";
			sql+="shobit='"+student.getShobit()+"',";
			sql+="ssex='"+student.getSsex()+"',";
			sql+="szhuanye='"+student.getSzhuanye()+"',";
			sql+="classid="+student.getClassid()+",";
			sql+="nationid="+student.getNationid()+"  where sno='"+student.getSno()+"'";
			System.err.println(sql);
			st.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println("更新数据失败");
			e.printStackTrace();
		}
	}
	public List<StudentVo> studentlist(int pagesize,int startpage){
		List<StudentVo> list = new ArrayList<StudentVo>();
		try { 
			Statement st = conn.createStatement();
			String sql = "select top("+pagesize+") s.*,c.classname,n.nationname from  stud  s ,class c,nation n where s.classid=c.classid and s.nationid=n.nationid and sno not in(select top("+startpage+") sno from stud )";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				StudentVo student = new StudentVo();
				student.setShobit(rs.getString("shobit"));
				student.setSzhuanye(rs.getString("szhuanye"));
				student.setSage(rs.getInt("sage"));
				student.setStudentname(rs.getString("studentname"));
				student.setSno(rs.getInt("sno"));
				student.setSsex(rs.getString("ssex"));
				student.setClassname(rs.getString("classname"));
				student.setNationname(rs.getString("nationname"));
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
	public List<ClassVo> classlist() {
		List<ClassVo> classlist = new ArrayList<ClassVo>();
		try {
			Statement st = conn.createStatement();
			String sql = "select * from class";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				ClassVo classvo = new ClassVo();
				classvo.setClassid(rs.getInt("classid"));
				classvo.setClassname(rs.getString("classname"));
				classlist.add(classvo);
			}
		} catch (Exception e) {
			System.out.println("班级列表出错！");
			e.printStackTrace();
		}
		return classlist;
	}
	public List<NationVo> nationlist() {
		List<NationVo> nationlist = new ArrayList<NationVo>();
		try {
			Statement st = conn.createStatement();
			String sql = "select * from nation";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				NationVo nationvo = new NationVo();
				nationvo.setNationid(rs.getInt("nationid"));
				nationvo.setNationname(rs.getString("nationname"));
				nationlist.add(nationvo);
			}
		} catch (Exception e) {
			System.out.println("班级列表出错！");
			e.printStackTrace();
		}
		return nationlist;
	}
}
