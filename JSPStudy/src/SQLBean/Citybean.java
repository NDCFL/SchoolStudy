package SQLBean;

import java.io.Serializable;

public class Citybean implements Serializable{

	private int cityid;
	private int privaceid;
	private String cityname;
	private String privacename;
	public int getCityid() {
		return cityid;
	}
	public void setCityid(int cityid) {
		this.cityid = cityid;
	}
	public int getPrivaceid() {
		return privaceid;
	}
	public void setPrivaceid(int privaceid) {
		this.privaceid = privaceid;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public String getPrivacename() {
		return privacename;
	}
	public void setPrivacename(String privacename) {
		this.privacename = privacename;
	}
	
}
