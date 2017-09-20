package Pool;

import java.util.List;

public interface Teachersql {

	public List<TeacherBean> list ();
	public void teacheradd(TeacherBean bean);
	public void teacherdel(String teacherid);
	public void teacherupdate(TeacherBean bean);
	public TeacherBean bean (String teacherid);
}
