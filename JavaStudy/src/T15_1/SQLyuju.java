package T15_1;

import java.util.Vector;

public interface SQLyuju {

	//新增操作
	public void add(SQLBean sqlbean);
	//删除
	public void delete(int id);
	//修改
	public void update(SQLBean sqlbean);
	//查询
	public void find(int id);
	//查询全部
	public void findAll(SQLBean sqlbean);
	//
	public Vector findlike(String name , String card);
	
	public boolean isExit(String name);
}
