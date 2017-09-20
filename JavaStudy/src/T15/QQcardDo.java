package T15;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class QQcardDo implements QQcardDAO{

	//实现接口类
	//新增函数
	public void add(QQcard card) {
		Connection conn = SQLConection.openDB();
		String SQL = "insert into QQcard values(?,?,?,?,?,?,?)";
		try {
			int n=1;
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(n++, card.getName());
			ps.setString(n++, card.getQQ());
			ps.setString(n++, card.getPassword());
			ps.setString(n++, card.getSex());
			ps.setString(n++, card.getTel());
			ps.setString(n++, card.getEmail());
			ps.setString(n++, card.getQiangming());
			//保存数据
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	//删除函数
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	//查询函数
	public void find(int id) {
		// TODO Auto-generated method stub
		
	}
	//查询所有数据
	public void findAll() {
		// TODO Auto-generated method stub
		
	}
	//条件查询
	public List findlike(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	//更新数据
	public void update(QQcard card) {
		// TODO Auto-generated method stub
		
	}

}
