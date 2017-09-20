package SQLBean;

import java.io.Serializable;
import java.util.Date;

//系统日志表
public class SysLogBean implements Serializable{

	private int syslogid;   
	private int managerid;
	private int Typetext; 
	private String Countent;
	private Date createdate;  
	private String ipaddress;
	public int getSyslogid() {
		return syslogid;
	}
	public void setSyslogid(int syslogid) {
		this.syslogid = syslogid;
	}
	public int getManagerid() {
		return managerid;
	}
	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}
	public int getTypetext() {
		return Typetext;
	}
	public void setTypetext(int typetext) {
		Typetext = typetext;
	}
	public String getCountent() {
		return Countent;
	}
	public void setCountent(String countent) {
		Countent = countent;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public String getIpaddress() {
		return ipaddress;
	}
	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

}
