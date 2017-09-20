package OracleConn;

import java.util.List;

public interface OracleSentence {

	public List<StudentBean> studentlist();
	public void studadd(StudentBean studentBean);
	public void studdel(String studid);
	public void studupdate(StudentBean studentBean);
	public List<StudentBean> studentlist(int pagesize,int startpage);
}
