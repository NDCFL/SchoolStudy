package Pool;

import java.io.Serializable;

public class TeacherBean implements Serializable{

	private int teacherid;
	private String teachername;
	private Float teachergread;
	public int getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}
	public String getTeachername() {
		return teachername;
	}
	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
	public Float getTeachergread() {
		return teachergread;
	}
	public void setTeachergread(Float teachergread) {
		this.teachergread = teachergread;
	}
	
}
