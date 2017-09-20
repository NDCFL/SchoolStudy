package DevicetManger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class  BaseDAOimp implements BaseDAO{

	Connection conn = MysqlConnection.open();
	
	public void adddevice(DeviceVo device) {
		try {
			Statement st = conn.createStatement();
			String sql = "insert into peasonmanager(gongzi,licai,richang,guding,touzi) values(";
			sql+="'"+device.getGongzi()+"',";
			sql+="'"+device.getLicai()+"',";
			sql+="'"+device.getRichang()+"',";
			sql+="'"+device.getGuding()+"',";
			sql+="'"+device.getTouzi()+"')";
			System.out.println(sql);
			st.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println("新增失败");
			e.printStackTrace();
		}
		
	}

	
	public void deletedevice(String billid) {
		try {
			Statement st = conn.createStatement();
			String sql = "delete from peasonmanager where billid='"+billid+"'";
			System.out.println(sql);
			st.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println("删除失败！");
			e.printStackTrace();
		}
	}

	
	public DeviceVo finddeviceVo(String billid) {
		DeviceVo device = new DeviceVo();
		try { 
			Statement st = conn.createStatement();
			String sql = "select * from peasonmanager where  billid='"+billid+"'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				device.setGongzi(rs.getInt("gongzi"));
				device.setLicai(rs.getInt("licai"));
				device.setGuding(rs.getInt("guding"));
				device.setRichang(rs.getInt("richang"));
				device.setTouzi(rs.getInt("touzi"));
				device.setBillid(rs.getInt("billid"));
			}
		} catch (Exception e) {
			System.out.println("查询失败");
			e.printStackTrace();
		}
		return device;
		
	}

	
	public List<DeviceVo> devicelist() {
		List<DeviceVo> list = new ArrayList<DeviceVo>();
		try { 
			Statement st = conn.createStatement();
			String sql = "select * from peasonmanager";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				DeviceVo device = new DeviceVo();
				device.setGongzi(rs.getInt("gongzi"));
				device.setLicai(rs.getInt("licai"));
				device.setGuding(rs.getInt("guding"));
				device.setRichang(rs.getInt("richang"));
				device.setTouzi(rs.getInt("touzi"));
				device.setBillid(rs.getInt("billid"));
				list.add(device);
			}
		} catch (Exception e) {
			System.out.println("查询失败");
			e.printStackTrace();
		}
		return list;
	}

	
	public void updatedevice(DeviceVo deviceVo) {
		try {
			Statement st = conn.createStatement();
			String sql="update peasonmanager set ";
			sql+="gongzi='"+deviceVo.getGongzi()+"',";
			sql+="licai='"+deviceVo.getLicai()+"',";
			sql+="guding='"+deviceVo.getGuding()+"',";
			sql+="richang='"+deviceVo.getRichang()+"',";
			sql+="touzi='"+deviceVo.getTouzi()+"'";
			sql+=" where billid='"+deviceVo.getBillid()+"'";
			System.err.println(sql);
			st.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println("更新数据失败");
			e.printStackTrace();
		}
		
	}

	
	public List<DeviceVo> find(String sql) {
		List<DeviceVo> list = new ArrayList<DeviceVo>();
		try { 
			Statement st = conn.createStatement();
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				DeviceVo device = new DeviceVo();
				device.setGongzi(rs.getInt("gongzi"));
				device.setLicai(rs.getInt("licai"));
				device.setGuding(rs.getInt("guding"));
				device.setRichang(rs.getInt("richang"));
				device.setTouzi(rs.getInt("touzi"));
				device.setBillid(rs.getInt("billid"));
				list.add(device);
			}
		} catch (Exception e) {
			System.out.println("查询失败");
			e.printStackTrace();
		}
		return list;
	}

	
}
