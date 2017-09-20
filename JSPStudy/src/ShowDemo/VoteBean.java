package ShowDemo;

import java.io.Serializable;

public class VoteBean implements Serializable{

	private String studentname;
	private int studentcount;
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public int getStudentcount() {
		return studentcount;
	}
	public void setStudentcount(int studentcount) {
		this.studentcount = studentcount;
	}
}
