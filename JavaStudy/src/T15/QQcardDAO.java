package T15;

import java.util.List;


public interface QQcardDAO {

	//新增操作
	public void add(QQcard card);
	//删除
	public void delete(int id);
	//修改
	public void update(QQcard card);
	//查询
	public void find(int id);
	//查询全部
	public void findAll();
	//
	public List findlike(String name);
}
