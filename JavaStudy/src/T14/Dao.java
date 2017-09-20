package T14;
import java.sql.*;
public class Dao{
	public static void main(String args[]){
		new Dao();
	}
	public Dao(){
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        Connection  conn=DriverManager.getConnection("jdbc:sqlserver://localhost\\SQL2005:1433;DatabaseName=T14","sa","123456");
			PreparedStatement ps=conn.prepareStatement("update zuoye set name=? where id=?");
			//?表示要用setXXX方法复值的变量
			ps.setString(1,"小飞");//表示第一个参数为张三,
			ps.setInt(2,3);//表示第二个参数为32
			ps.executeUpdate();//执行更新操作
			System.out.println("更新成功！！！");
		 }catch (Exception e) {
		 	System.out.println("连接失败");
		 	e.printStackTrace();
		 }
	}
}
