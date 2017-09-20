package T7;

public class StudentBean {

	private int studentid;
	private String[] studentname;
	private String studentinf;
	private int studentcount;
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String[] getStudentname() {
		return studentname;
	}
	public void setStudentname(String[] studentname) {
		this.studentname = studentname;
	}
	public int getStudentcount() {
		return studentcount;
	}
	public void setStudentcount(int studentcount) {
		this.studentcount = studentcount;
	}
	public String getStudentname(int index){
		return studentname[index];
	}
	public void SetStudentname(int index,String ho){
		studentname[index]=ho;
	}
	public String getStudentinf() {
		return studentinf;
	}
	public void setStudentinf(String studentinf) {
		this.studentinf = studentinf;
	}
	
}
