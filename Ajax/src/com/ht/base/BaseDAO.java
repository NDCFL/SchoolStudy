package com.ht.base;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ht.bean.StudVo;

public class BaseDAO {

	public void add(StudVo stud){
		Connection conn = DBConn.openDB();
		try{
			String sql = "insert into student values(";
			sql += stud.getStudid() +",'";
			sql += stud.getStudname() +"','";
			sql += stud.getSex() +"','";
			sql += stud.getCardid() +"',";
			sql += stud.getAge() +",'";
			sql += stud.getClassname() +"')";
			System.out.println(sql);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public List<StudVo> studList(){
		List<StudVo> list = new ArrayList<StudVo>();
		Connection conn = DBConn.openDB();
		try{
			String sql  = "select * from student";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				StudVo s = new StudVo();
				s.setStudid(rs.getInt("studid"));
				s.setStudname(rs.getString("studname"));
				s.setSex(rs.getString("sex"));
				s.setCardid(rs.getString("cardid"));
				s.setAge(rs.getInt("age"));
				s.setClassname(rs.getString("classname"));
				list.add(s);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	public void del(String studid){
		Connection conn = DBConn.openDB();
		try{
			String sql = "delete student where studid="+studid;
			System.out.println(sql);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public StudVo findStudById(String studid){
		StudVo s = new StudVo();
		Connection conn = DBConn.openDB();
		try{
			String sql  = "select * from student where studid="+studid;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				s.setStudid(rs.getInt("studid"));
				s.setStudname(rs.getString("studname"));
				s.setSex(rs.getString("sex"));
				s.setCardid(rs.getString("cardid"));
				s.setAge(rs.getInt("age"));
				s.setClassname(rs.getString("classname"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return s;
	}
	public void update(StudVo stud){
		Connection conn = DBConn.openDB();
		try{
			String sql = "update student set studname='";
			sql += stud.getStudname() +"',sex='";
			sql += stud.getSex() +"',cardid='";
			sql += stud.getCardid() +"',age=";
			sql += stud.getAge() +",classname='";
			sql += stud.getClassname() +"' where studid=";
			sql += stud.getStudid();
			System.out.println(sql);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
