package DevicetManger;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class DeviceVo implements Serializable{

	private int billid;
	private int gongzi;
	private int licai;
	private int richang;
	private int guding;
	private int touzi;
	public int getBillid() {
		return billid;
	}
	public void setBillid(int billid) {
		this.billid = billid;
	}
	public int getGongzi() {
		return gongzi;
	}
	public void setGongzi(int gongzi) {
		this.gongzi = gongzi;
	}
	public int getLicai() {
		return licai;
	}
	public void setLicai(int licai) {
		this.licai = licai;
	}
	public int getRichang() {
		return richang;
	}
	public void setRichang(int richang) {
		this.richang = richang;
	}
	public int getGuding() {
		return guding;
	}
	public void setGuding(int guding) {
		this.guding = guding;
	}
	public int getTouzi() {
		return touzi;
	}
	public void setTouzi(int touzi) {
		this.touzi = touzi;
	}
	
}
