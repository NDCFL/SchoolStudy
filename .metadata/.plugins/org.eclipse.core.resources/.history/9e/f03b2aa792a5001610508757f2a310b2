package edu.ht.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import edu.ht.bean.QqHistory;
import edu.ht.bean.Qquser;
import edu.ht.common.DBConnection;
import edu.ht.service.QquserService;

public class QquserServiceImpl implements QquserService {

	public boolean addUSer(Qquser quser) {
		Connection conn = DBConnection.getConnection();
		String sql = "insert into qquser values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement prst = conn.prepareStatement(sql);
			prst.setString(1, quser.getQqnum());
			prst.setString(2, quser.getPwd());
			prst.setString(3, quser.getUname());
			prst.setString(4, quser.getSex());
			prst.setInt(5, quser.getAge());
			prst.setString(6, quser.getFace());
			prst.setInt(7, quser.getState());
			prst.setString(8, quser.getNation());
			prst.setString(9, quser.getTxt());
			prst.setString(10, quser.getStar());
			prst.setInt(11, quser.getLevels());
			prst.setString(12, quser.getTel());
			
			prst.setString(13, quser.getIpadd());
			prst.setInt(14, quser.getPort());
			int i = prst.executeUpdate();
			if (i > 0) {
				return true;
			}
			prst.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean selUser(String qqnum) {
		Connection con = DBConnection.getConnection();
		String sql = "select * from qq  where qqnum=?";
		try {
			PreparedStatement prst = con.prepareStatement(sql);
			prst.setString(1, qqnum);
			ResultSet rs = prst.executeQuery();
			if (rs.next()) {
				// 存在返回true
				return true;
			}
			rs.close();
			prst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Qquser chkUser(Qquser quser) {
		Connection con = DBConnection.getConnection();
		String sql = "select * from qquser where qqnum=? and pwd=?";
		try {
			PreparedStatement prst = con.prepareStatement(sql);
			prst.setString(1, quser.getQqnum());
			prst.setString(2, quser.getPwd());
			ResultSet rs = prst.executeQuery();
			if (rs.next()) {
				// 用户存在 返回这个用户
				quser.setId(rs.getInt("id"));
				quser.setFace(rs.getString("face"));
				quser.setLevels(rs.getInt("levels"));
				quser.setTxt(rs.getString("txt"));
				quser.setState(rs.getInt("state"));
				quser.setUname(rs.getString("uname"));
				quser.setSex(rs.getString("sex"));
				quser.setStar(rs.getString("star"));
				quser.setNation(rs.getString("nation"));
				quser.setTel(rs.getString("tel"));
				quser.setIpadd(rs.getString("ipadd"));
				quser.setPort(rs.getInt("port"));
				return quser;
			}
			rs.close();
			prst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public boolean updUserState(Qquser quser) {
		Connection conn = DBConnection.getConnection();
		String sql = "update qquser set state=? where qqnum=?";
		try {
			PreparedStatement prst = conn.prepareStatement(sql);
			prst.setInt(1, quser.getState());
			prst.setString(2, quser.getQqnum());
			int i = prst.executeUpdate();
			if (i > 0) {
				return true;
			}
			prst.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean saveHistory(Qquser quser) {
		Connection conn = DBConnection.getConnection();
		String sqldel = "delete from qqhistory where qqnum='"
				+ quser.getQqnum() + "';";
		sqldel += "insert into qqhistory values('" + quser.getQqnum() + "','"
				+ quser.getPwd() + "'," + quser.getAge() + ",'"
				+ quser.getFace() + "')";
		try {
			PreparedStatement prst = conn.prepareStatement(sqldel);

			int i = prst.executeUpdate();
			if (i > 0) {
				return true;
			}
			prst.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public List selHistory() {
		List list = new ArrayList();
		Connection con = DBConnection.getConnection();
		String sql = "select * from qqhistory";
		try {
			PreparedStatement prst = con.prepareStatement(sql);

			ResultSet rs = prst.executeQuery();
			while (rs.next()) {
				QqHistory qh = new QqHistory();
				qh.setId(rs.getInt("id"));
				qh.setQqnum(rs.getString("qqnum"));
				qh.setPwd(rs.getString("pwd"));
				qh.setAutologin(rs.getInt("autologin"));
				qh.setFace(rs.getString("face"));
				list.add(qh);
			}
			rs.close();
			prst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Vector<Qquser> selFriendByGroup(String qqnum, String groupname) {
		Vector<Qquser> users = new Vector<Qquser>();
		Connection con = DBConnection.getConnection();
		String sql = "select * from  qquser where qqnum in ( select friendqq from qqfriend where myqq=? and groupname=?)";
		try {
			PreparedStatement prst = con.prepareStatement(sql);
			prst.setString(1, qqnum);
			prst.setString(2, groupname);
			ResultSet rs = prst.executeQuery();
			while (rs.next()) {
				Qquser quser = new Qquser();
				quser.setId(rs.getInt("id"));
				quser.setFace(rs.getString("face"));
				quser.setLevels(rs.getInt("levels"));
				quser.setTxt(rs.getString("txt"));
				quser.setState(rs.getInt("state"));
				quser.setUname(rs.getString("uname"));
				quser.setQqnum(rs.getString("qqnum"));
				quser.setSex(rs.getString("sex"));
				quser.setTel(rs.getString("tel"));
				quser.setStar(rs.getString("star"));
				quser.setNation(rs.getString("nation"));
				quser.setIpadd(rs.getString("ipadd"));
				quser.setPort(rs.getInt("port"));
				users.add(quser);
			}
			rs.close();
			prst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public Vector selectFriend(Qquser quser) {
		Vector vv = new Vector();
		Connection con = DBConnection.getConnection();
		String sql = "select * from qquser where 1=1 ";
		if (!quser.getQqnum().equals("")) {// 如果QQ号不为空
			sql += " and qqnum like '%" + quser.getQqnum() + "%'";
		}
		if (!quser.getUname().equals("")) {
			sql += " and uname like '%" + quser.getUname() + "%'";
		}
		if (quser.getAge() != 0) {
			sql += " and age=" + quser.getAge();
		}
		if (!quser.getSex().equals("")) {
			sql += " and sex='" + quser.getSex() + "'";
		}
		System.out.println(sql);
		try {
			PreparedStatement prst = con.prepareStatement(sql);
			ResultSet rs = prst.executeQuery();
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("qqnum"));
				v.add(rs.getString("uname"));
				v.add(rs.getInt("age"));
				v.add(rs.getString("sex"));
				v.add(rs.getString("nation"));
				v.add(rs.getString("star"));
				v.add(rs.getString("tel"));
				v.add(rs.getInt("levels"));
				v.add(rs.getString("txt"));

				vv.add(v);
			}
			rs.close();
			prst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vv;
	}

	public Qquser selUserByQQnum(String qqnum) {
		Qquser quser = new Qquser();
		Connection con = DBConnection.getConnection();
		String sql = "select * from  qquser where qqnum =?";
		try {
			PreparedStatement prst = con.prepareStatement(sql);
			prst.setString(1, qqnum);
			ResultSet rs = prst.executeQuery();
			if (rs.next()) {

				quser.setId(rs.getInt("id"));
				quser.setFace(rs.getString("face"));
				quser.setLevels(rs.getInt("levels"));
				quser.setTxt(rs.getString("txt"));
				quser.setState(rs.getInt("state"));
				quser.setUname(rs.getString("uname"));
				quser.setQqnum(rs.getString("qqnum"));
				quser.setSex(rs.getString("sex"));
				quser.setTel(rs.getString("tel"));
				quser.setStar(rs.getString("star"));
				quser.setNation(rs.getString("nation"));
				quser.setIpadd(rs.getString("ipadd"));
				quser.setPort(rs.getInt("port"));

			}
			rs.close();
			prst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return quser;
	}

	//添加好友
	public boolean addFriend(Qquser myuser, Qquser fruser,String groupname) {
		Connection conn = DBConnection.getConnection();
		String sql = "insert into qqfriend values ('"+myuser.getQqnum()+"','"+fruser.getQqnum()+"','"+groupname+"');" +
				"insert into qqfriend values ('"+fruser.getQqnum()+"','"+myuser.getQqnum()+"','"+groupname+"')";
		try {
			PreparedStatement prst = conn.prepareStatement(sql);
			int i = prst.executeUpdate();
			if (i > 0) {
				return true;
			}
			prst.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean selFF(String mynum,String frnum) {
		Connection con = DBConnection.getConnection();
		String sql = "select * from qqfriend  where myqq=? and friendqq=?";
		try {
			PreparedStatement prst = con.prepareStatement(sql);
			prst.setString(1, mynum);
			prst.setString(2, frnum);
			ResultSet rs = prst.executeQuery();
			if (rs.next()) {
				// 存在返回true
				return true;
			}
			rs.close();
			prst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delFF(Qquser myqq, Qquser frqq) {
		Connection conn = DBConnection.getConnection();
		String sql = "delete from qqfriend where myqq='"+myqq.getQqnum()+"' and friendqq='"+frqq.getQqnum()+"';" +
				"delete from qqfriend where myqq='"+frqq.getQqnum()+"' and friendqq='"+myqq.getQqnum()+"'";
		try {
			PreparedStatement prst = conn.prepareStatement(sql);
			int i = prst.executeUpdate();
			if (i > 0) {
				return true;
			}
			prst.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean moveFF(Qquser myqq, Qquser frqq, String groupname) {
		Connection conn = DBConnection.getConnection();
		String sql = "update qqfriend set groupname='"+groupname+"' where myqq='"+myqq.getQqnum()+"' and friendqq='"+frqq.getQqnum()+"'";
		try {
			PreparedStatement prst = conn.prepareStatement(sql);
			int i = prst.executeUpdate();
			if (i > 0) {
				return true;
			}
			prst.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updInfo(Qquser quser) {
		Connection conn = DBConnection.getConnection();
		String sql = "update qquser set pwd=? ,uname=?,sex=?,face=?,nation=?,txt=?,star=?,tel=? where qqnum=?";
		try {
			PreparedStatement prst = conn.prepareStatement(sql);
			prst.setString(1, quser.getPwd());
			prst.setString(2, quser.getUname());
			prst.setString(3, quser.getSex());
			prst.setString(4, quser.getFace());
			prst.setString(5, quser.getNation());
			prst.setString(6, quser.getTxt());
			prst.setString(7, quser.getStar());
			prst.setString(8, quser.getTel());
			prst.setString(9, quser.getQqnum());
			int i = prst.executeUpdate();
			if (i > 0) {
				return true;
			}
			prst.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
}
