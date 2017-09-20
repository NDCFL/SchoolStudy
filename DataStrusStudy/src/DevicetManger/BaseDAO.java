package DevicetManger;

import java.util.List;

public interface BaseDAO {

	//账单的新增函数
	public void adddevice(DeviceVo deviceVo);
	//删除账单
	public void deletedevice(String sno);
	//查询账单列表
	public List<DeviceVo> devicelist();
	//更新账单的函数
	public void updatedevice(DeviceVo deviceVo);
	//查询单个账单的资料
	public DeviceVo finddeviceVo(String billid);
	
	public List<DeviceVo> find(String sql);
}
