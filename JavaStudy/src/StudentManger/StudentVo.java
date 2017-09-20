package StudentManger;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class StudentVo implements Serializable{

	private int sno;
	private String studentname;
	private int sage;
	private String ssex;
	private String shobit;
	private String szhuanye;
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	public String getShobit() {
		return shobit;
	}
	public void setShobit(String shobit) {
		this.shobit = shobit;
	}
	public String getSzhuanye() {
		return szhuanye;
	}
	public void setSzhuanye(String szhuanye) {
		this.szhuanye = szhuanye;
	}

	
	
}
