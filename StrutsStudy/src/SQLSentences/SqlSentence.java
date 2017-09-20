package SQLSentences;

import java.util.List;

import struts.form.StudentForm;

public interface SqlSentence {
	
	public abstract void addstud(StudentForm  student);
	public abstract List<StudentForm> studentlist();
	public abstract StudentForm findstudent(String sno);
	public abstract void delstudent(String sno);
	public abstract void updatestudent(StudentForm student);
	public abstract List<StudentForm> studentlist(int pagesize,int startpage);
	public abstract int sum(String sql);
}
