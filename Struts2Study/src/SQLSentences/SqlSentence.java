package SQLSentences;

import java.util.List;

import Vo.ClassVo;
import Vo.NationVo;
import Vo.StudentVo;

public interface SqlSentence {
	
	public abstract void addstud(StudentVo  student);
	public abstract List<StudentVo> studentlist();
	public abstract StudentVo findstudent(String sno);
	public abstract void delstudent(String sno);
	public abstract void updatestudent(StudentVo student);
	public abstract List<StudentVo> studentlist(int pagesize,int startpage);
	public abstract int sum(String sql);
	public abstract List<ClassVo> classlist();
	public abstract List<NationVo> nationlist();
	
}
