package SQLServletTest;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Statement;

public class CallStatementDemo {

	//事务处理
	public static void maintest(String[] args) {
		Connection con = SQLConection.openDB();
		try {
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			String sql = "update salarymoney set salary=salary-1000 where moneyname='张三'";
			st.executeUpdate(sql);
			int n = st.getUpdateCount();
			String sql1 = "update salarymoney set salary=salary+1000 where moneyname='李四'";
			st.executeUpdate(sql1); 
			int num = st.getUpdateCount();
			if(n!=0 && num!=0){
				System.out.println("交易成功！");
				con.commit();
			}else {
				System.out.println("交易失败！");
				con.rollback();
			}
		} catch (Exception e) {
			try {
				con.rollback();
				System.out.println("交易失败");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	//调用存储过程
	public static void main(String[] args) {
		Connection con = SQLConection.openDB();
		try {
			String sql="{call up_getcode(?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.registerOutParameter(1, java.sql.Types.VARCHAR);
			cs.executeUpdate();
			System.out.println("订单号："+cs.getNString(1));
		} catch (Exception e) {
			
		}
	}
}
