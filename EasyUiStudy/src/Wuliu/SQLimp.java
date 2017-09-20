package Wuliu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLimp {

	Connection con = SQLCon.openDB();
	public List<WuliuBean> list (){
		List<WuliuBean> wuliulist = new ArrayList<WuliuBean>();
		try {
			Statement st = con.createStatement();
			String sql = "select * from wuliu";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				WuliuBean w = new WuliuBean();
				w.setWuliu(rs.getInt("wuliu"));
				w.setDatetime(rs.getString("date"));
				w.setNum(rs.getInt("num"));
				w.setPrice(rs.getInt("price"));
				w.setProname(rs.getString("proname"));
				wuliulist.add(w);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wuliulist;
		
	}
	public void delete(String id){
		try {
			Statement st = con.createStatement();
			String sql = "delete wuliu where wuliu="+id;
			System.out.println(sql);
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void updatesave(WuliuBean wuliuBean){
		try {
			Statement st = con.createStatement();
			String sql = "update wuliu set proname='"+wuliuBean.getProname()+"',price="+wuliuBean.getPrice()+",num="+wuliuBean.getNum()+",date='"+wuliuBean.getDatetime()+"' where wuliu="+wuliuBean.getWuliu(); 
			System.out.println(sql);
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public WuliuBean findw(String id){
		WuliuBean w = new WuliuBean();
		try {
			Statement st = con.createStatement();
			String sql = "select * from wuliu where wuliu="+id;
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()){
				w.setWuliu(rs.getInt("wuliu"));
				w.setDatetime(rs.getString("date"));
				w.setNum(rs.getInt("num"));
				w.setPrice(rs.getInt("price"));
				w.setProname(rs.getString("proname"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return w;
	}
	public void addw(WuliuBean w){
		try {
			Statement st = con.createStatement();
			String sql = "insert into wuliu values('"+w.getProname()+"',"+w.getPrice()+","+w.getNum()+",'"+w.getDatetime()+"')";
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
