package SQLBase;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Vector;

import javax.swing.ImageIcon;

import QQSQL.QQminlin;
import QQSQL.SQLconnection;
import QQbean.QQidtable;

public class QQbase implements Serializable{

	//随机得到一个六到八位数的QQ
	public int getMQQid() {
		boolean QQidexit=false;
		Random rd = new Random();
		int QQid=0;
		try {
			String sql="select QQid from IDtable where QQid=?";
			while (!QQidexit) {
				
				//随机产生一个六到八位数的QQ号码
				QQid = rd.nextInt(88888888)+100000;
				//连接数据库
				Connection con = SQLconnection.openDB();
				//操作数据库的语句，执行SQL语句
				PreparedStatement ps = con.prepareStatement(sql);
				//给数据库的字段名赋值
				ps.setInt(1, QQid);
				//返回一个结果集
				ResultSet rs = ps.executeQuery();
				//查询有无相同的号码
				if (!rs.next()) {
					QQidexit=true;
					break;
				}
			}
			
		} catch (SQLException e) {
			System.out.println("SQL语句出现错误");
			e.printStackTrace();
		}
		//返回一个QQ号码
		return QQid;
	}
	//随机得到一个端口
	public int getPort() {
		boolean QQportexit=false;
		//随机产生一个端口
		Random rd = new Random();
		int port=0;
		try {
			//数据库语句，查询数据库的值是否会与产生的值相互冲突
			String sql="select QQid from IDtable where zhuangtai<>? and port=?";
			while (!QQportexit) {
				//端口的范围0到65535，值为连个整型值
				port = rd.nextInt(64000)+1023;
				//连接数据库
				Connection con = SQLconnection.openDB();
				//创建操作数据库的环境变量
				PreparedStatement ps = con.prepareStatement(sql);
				//给数据库的值赋值
				ps.setString(1, QQminlin.STATUS[1]);
				ps.setInt(2, port);
				//返回结果集
				ResultSet rs = ps.executeQuery();
				//进行判断是否有重复的值
				if (!rs.next()) {
					QQportexit=true;
					break;
				}
			}
			
		} catch (SQLException e) {
			System.out.println("SQL语句出现错误");
			e.printStackTrace();
		}
		return port;
	}
	public QQidtable saveAccount(QQidtable qqtable){
		//将前面的QQ号码的值赋值到QQid字段里存储
		int QQid = getMQQid();
		//设置QQ号码
		qqtable.setQQid(QQid);
		//设置端口值来自于获取到的端口值
		int port=getPort();
		//设置默认的端口
		qqtable.setPort(0);
		//从QQminlin制中的数组变量取值到数据库的状态中，一般默认为离线状态
		qqtable.setZhuangtai(QQminlin.STATUS[1]);
		String SQL="insert into IDtable values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		//连接数据库
		Connection con = SQLconnection.openDB();
		try {
		
			int i=1;
			//执行数据库语句
			PreparedStatement ps = con.prepareStatement(SQL);
			//逐一设值，通过不同的数据类型来设置
			ps.setInt(i++, qqtable.getQQid());
			ps.setString(i++, qqtable.getQQname());
			ps.setString(i++, qqtable.getQQpassword());
			ps.setString(i++, qqtable.getQQhead());
			ps.setInt(i++, qqtable.getAge());
			ps.setString(i++, qqtable.getSex());
			ps.setString(i++, qqtable.getStart());
			ps.setString(i++, qqtable.getBlood());
			ps.setString(i++, qqtable.getNation());
			ps.setString(i++, qqtable.getHobit());
			ps.setString(i++, qqtable.getIpdizhi());
			ps.setInt(i++, qqtable.getPort());
			ps.setString(i++, qqtable.getZhuangtai());
			ps.setString(i++, qqtable.getRemark());
			//保存数据
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qqtable;
	}
	//登录
	/*1.获取一个合法的端口
	 *2.登录成功后把所有字段的值设置到account对象中，返回给登录界面
	 *3.更新端口和状态
	 * 
	 * */
	public QQidtable login(QQidtable qqidtable){
		Connection conn = SQLconnection.openDB();
		String sql = "select * from IDtable where QQid=? and QQpassword=?";
		int qqcode = 0;
		try{
			int port =getPort();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qqidtable.getQQid());
			pstmt.setString(2, qqidtable.getQQpassword());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				qqidtable.setQQname(rs.getString("QQname").trim());
				qqidtable.setQQhead(rs.getString("QQhead").trim());
				qqidtable.setAge(rs.getInt("age"));
				qqidtable.setSex(rs.getString("sex").trim());
				qqidtable.setStart(rs.getString("start").trim());
				qqidtable.setBlood(rs.getString("blood").trim());
				qqidtable.setNation(rs.getString("nation").trim());
				qqidtable.setHobit(rs.getString("hobit").trim());
				InetAddress addr=null;
				try {
					addr = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				String ip = addr.getHostAddress();
				qqidtable.setIpdizhi(ip);
				qqidtable.setPort(port);
				qqidtable.setZhuangtai(QQminlin.STATUS[0]);//在线
				qqidtable.setRemark(rs.getString("remark"));
				//更改端口和状态
				sql = "update IDtable set ipdizhi='"+ip+"' ,port="+port +",zhuangtai='" + QQminlin.STATUS[0] + "' where QQid="+qqidtable.getQQid();
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(sql);
				pstmt.close();
				stmt.close();
			}else{
				//登录失败
				qqidtable=null;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return qqidtable;
	}
	public Vector<QQidtable> getmyfriend(int myqqcode){
		Connection conn = SQLconnection.openDB();
		String sql = "select i.*,f.groupName from idtable i inner join friendtable f on i.QQid=f.fqqid where mqqid=?";
		int qqcode = 0;
		Vector<QQidtable> vfriend = new Vector<QQidtable>();
		try{
			int port =getPort();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, myqqcode);
			System.out.println(myqqcode);
			System.out.println(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				QQidtable qqidtable = new QQidtable();
				qqidtable.setQQid(rs.getInt("QQid"));
				qqidtable.setQQname(rs.getString("QQname").trim());
				qqidtable.setQQhead(rs.getString("QQhead").trim());
				qqidtable.setAge(rs.getInt("age"));
				qqidtable.setSex(rs.getString("sex").trim());
				qqidtable.setStart(rs.getString("start").trim());
				qqidtable.setBlood(rs.getString("blood").trim());
				qqidtable.setNation(rs.getString("nation").trim());
				qqidtable.setHobit(rs.getString("hobit").trim());
				qqidtable.setIpdizhi(rs.getString("ipdizhi"));
				qqidtable.setPort(rs.getInt("port"));
				qqidtable.setZhuangtai(rs.getString("zhuangtai"));//在线
				qqidtable.setRemark(rs.getString("remark"));
				qqidtable.setGroupname(rs.getString("groupname"));
				vfriend.add(qqidtable);
			}
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return vfriend;
	}
	
	//修改信息
	public QQidtable UpdateAccount(QQidtable idtable){
		String SQL="update IDtable set qqname=?,qqhead=?,age=?,sex=?,start=?,blood=?,nation=?,hobit=?,remark=? where qqid=?";
		//连接数据库
		Connection con = SQLconnection.openDB();
		try {
			int i=1;
			//执行数据库语句
			PreparedStatement ps = con.prepareStatement(SQL);
			//逐一设值，通过不同的数据类型来设置
			ps.setString(i++, idtable.getQQname());
			ps.setString(i++, idtable.getQQhead());
			ps.setInt(i++, idtable.getAge());
			ps.setString(i++, idtable.getSex());
			ps.setString(i++, idtable.getStart());
			ps.setString(i++, idtable.getBlood());
			ps.setString(i++, idtable.getNation());
			ps.setString(i++, idtable.getHobit());
			ps.setString(i++, idtable.getRemark());
			ps.setInt(i++, idtable.getQQid());
			//保存数据
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idtable;
	}
	public void MoveGroupName(int mqqid,int fqqid,String groupname ){
		String sql = "update friendtable set groupname=? where fqqid=? and mqqid=?";
		Connection conn = SQLconnection.openDB();
		try {
			PreparedStatement ps = conn.prepareCall(sql);
			int i=1;
			ps.setString(i++, groupname);
			ps.setInt(i++, fqqid);
			ps.setInt(i++, mqqid);
			ps.executeUpdate();
			System.out.println("groupname="+groupname);
			System.out.println("mqqid"+mqqid);
			System.out.println("fqqid"+fqqid);
			System.out.println("数据库的值更改成功！！！");
			System.out.println(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Vector<Vector> look(String sql){
		
		Vector<Vector> vdata = new Vector<Vector>();
		Connection conn = SQLconnection.openDB();
		try{
			Statement stmt = conn.createStatement();
			System.out.println("sql=="+sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				Vector rowdata = new Vector();
				rowdata.addElement(new ImageIcon(rs.getString("QQhead").trim()));
				rowdata.addElement(rs.getString("QQid").trim());
				rowdata.addElement(rs.getString("QQname").trim());
				rowdata.addElement(rs.getString("age").trim());
				rowdata.addElement(rs.getString("sex").trim());
				rowdata.addElement(rs.getString("blood").trim());
				rowdata.addElement(rs.getString("start").trim());
				rowdata.addElement(rs.getString("nation").trim());
				rowdata.addElement(rs.getString("hobit").trim());
				rowdata.addElement(rs.getString("zhuangtai").trim());
				rowdata.addElement(rs.getString("remark").trim());
				vdata.add(rowdata);
				System.out.println(sql);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return vdata;
	}
	public QQidtable getselectfriend(int myqqid){
		Connection conn = SQLconnection.openDB();
		String sql = "select * from idtable where qqid=?";
		int qqid=0;
		QQidtable qqidtable = new QQidtable();
		try{
			int port =getPort();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, myqqid);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				qqidtable.setQQid(rs.getInt("QQid"));
				qqidtable.setQQname(rs.getString("QQname").trim());
				qqidtable.setQQhead(rs.getString("QQhead").trim());
				qqidtable.setAge(rs.getInt("age"));
				qqidtable.setSex(rs.getString("sex").trim());
				qqidtable.setStart(rs.getString("start").trim());
				qqidtable.setBlood(rs.getString("blood").trim());
				qqidtable.setNation(rs.getString("nation").trim());
				qqidtable.setHobit(rs.getString("hobit").trim());
				qqidtable.setIpdizhi(rs.getString("ipdizhi"));
				qqidtable.setPort(rs.getInt("port"));
				qqidtable.setZhuangtai(rs.getString("zhuangtai"));//在线
				qqidtable.setRemark(rs.getString("remark"));
			}
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return qqidtable;
		
	}
	public void addFriend(int myqqcode,int friendqqcode){
		try{
			Connection conn = SQLconnection.openDB();
			String sql ="insert into friendtable values(?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, friendqqcode);
			pstmt.setInt(2, myqqcode);
			pstmt.setString(3, QQminlin.GROUPNAME[0]);
			pstmt.executeUpdate();
			pstmt.setInt(1, myqqcode);
			pstmt.setInt(2, friendqqcode);
			pstmt.setString(3, QQminlin.GROUPNAME[0]);
			pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//判断是否为好友
	public boolean isFriend(int myQQcode,int friendqqcode){
		String sql = "select * from friendtable where fqqid=? and mqqid=?";
		boolean isok=false;
		QQidtable account = new QQidtable(); 
		Connection conn = SQLconnection.openDB();
		try{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, friendqqcode);
			pstmt.setInt(2, myQQcode);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				isok=true;
			}
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return isok;
	}
	//更改状态
	public void changeStatus(int qqcode,String status){
		String sql ="update idtable set zhuangtai=? where qqid=?";
		Connection conn = SQLconnection.openDB();
		try{
			int i=1;
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(i++, status);
			pstmt.setInt(i++, qqcode);
			i=pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//删除好友
	public void delFriend(int myqqcode,int friendqqcode){
		try{
			Connection conn = SQLconnection.openDB();
			String sql ="delete friendtable where fqqid=? and mqqid=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, friendqqcode);
			pstmt.setInt(2, myqqcode);
			pstmt.executeUpdate();
			pstmt.setInt(1, myqqcode);
			pstmt.setInt(2, friendqqcode);
			pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//判断自己是否在线
	public boolean isonline(int myQQcode){
		String sql = "select * from idtable where qqid=? and zhuangtai=?";
		boolean isok=false;
		QQidtable account = new QQidtable(); 
		Connection conn = SQLconnection.openDB();
		try{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, myQQcode);
			pstmt.setString(2, "在线");
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				isok=true;
			}
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return isok;
	}
	//更改状态
	public void changepassword(int qqcode,String pass){
		String sql ="update idtable set qqpassword=? where qqid=?";
		Connection conn = SQLconnection.openDB();
		try{
			int i=1;
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(i++, pass);
			pstmt.setInt(i++, qqcode);
			pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void offline(int mqqcode,int fqqcode,int minglinzhi,String xinxi){
		String sql = "insert into news values (?, ?,?,?)";
		Connection conn = SQLconnection.openDB();
		try{
			int n=1;
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(n++, mqqcode);
			pstmt.setInt(n++, fqqcode);
			pstmt.setInt(n++, minglinzhi);
			pstmt.setString(n++,xinxi );
			pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public Vector readoffline(int mqqcode){
		String sql = "select * from news where fqqid=?";
		Connection conn = SQLconnection.openDB();
		Vector data = new Vector();
		try{
			int n=1;
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(n++, mqqcode);
			ResultSet rSet  = pstmt.executeQuery();
			while (rSet.next()) {
				data.add(rSet.getInt("mqqid"));
				data.add(rSet.getInt("fqqid"));
				data.add(rSet.getInt("minlin"));
				data.add(rSet.getString("newsxinxi"));
				
			}
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return data;
		
	}
	
	public void deletenews(int mqqcode){
		String sql = "delete from news where fqqid=?";
		Connection conn = SQLconnection.openDB();
		try{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mqqcode);
			pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public Vector<QQidtable> ssendxinxi(int myQQcode,int friendqqcode){
		Connection conn = SQLconnection.openDB();
		String sql = "select newsxinxi  from news where myid=? and fqqid=?";
		int qqcode = 0;
		Vector<QQidtable> news = new Vector<QQidtable>();
		try{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, myQQcode);
			pstmt.setInt(2, friendqqcode);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				QQidtable qqidtable = new QQidtable();
				qqidtable.setQQid(rs.getInt("mqqid"));
				qqidtable.setQQname(rs.getString("fqqid").trim());
				qqidtable.setQQhead(rs.getString("newsxinxi").trim());
				news.add(qqidtable);
			}
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return news;
	}
	
	
}

