package StudentManger;

import java.util.List;

import T11.list_2;

public interface BaseDAO {

	//学生的新增函数
	public void addstudent(StudentVo student);
	//删除学生函数
	public void deletestudent(String sno);
	//查询列表函数
	public List<StudentVo> studentlist();
	//更新学生资料函数
	public void updatestudent(StudentVo studentVo);
	//查询单个学生资料
	public StudentVo findStudentVo(String sno);
	
	public List<StudentVo> find(String sql);
}
