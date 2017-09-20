package OracleConn;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OracleSentenceimp implements OracleSentence{

	Connection con = OracleConnection.open();
	public void studadd(StudentBean studentBean) {
		try {
			Statement st = con.createStatement();
			String sql = "insert into stud values(";
			sql+= "'"+studentBean.getStudid()+"',";
			sql+= "'"+studentBean.getStudname()+"',";
			sql+= "'"+studentBean.getSex()+"')";
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
		} catch (Exception e) {
			System.out.println("新增学生出错！");
			e.printStackTrace();
		}
		
	}

	public void studdel(String studid) {
		try {
			Statement st = con.createStatement();
			String sql = "delete stud where studid="+studid;
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
		} catch (Exception e) {
			System.out.println("删除学生出错！");
			e.printStackTrace();
		}
	}

	public List<StudentBean> studentlist() {
		List<StudentBean> list = new ArrayList<StudentBean>();
		try {
			
		} catch (Exception e) {
			System.out.println("查询学生列表出错！");
		}
		return null;
	}

	public List<StudentBean> studentlist(int pagesize, int startpage) {
		// TODO Auto-generated method stub
		return null;
	}

	public void studupdate(StudentBean studentBean) {
		// TODO Auto-generated method stub
		
	}

}
