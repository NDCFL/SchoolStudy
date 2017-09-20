package QQbean;

import java.io.Serializable;

public class QQidtable implements Serializable{

	private int QQid ;
	private String QQname;
	private String  QQpassword;
	private String  QQhead;
	private int age ;
	private String  sex ;
	private String  start ;
	private String  blood ;
	private String  nation ;
	private String  hobit ;
	private String  ipdizhi ;
	private int port ;
	private String  zhuangtai ;
	private String  remark ;
	private String  groupname ;
	public int getQQid() {
		return QQid;
	}
	public void setQQid(int qid) {
		QQid = qid;
	}
	public String getQQname() {
		return QQname;
	}
	public void setQQname(String qname) {
		QQname = qname;
	}
	public String getQQpassword() {
		return QQpassword;
	}
	public void setQQpassword(String qpassword) {
		QQpassword = qpassword;
	}
	public String getQQhead() {
		return QQhead;
	}
	public void setQQhead(String qhead) {
		QQhead = qhead;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getBlood() {
		return blood;
	}
	public void setBlood(String blood) {
		this.blood = blood;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getHobit() {
		return hobit;
	}
	public void setHobit(String hobit) {
		this.hobit = hobit;
	}
	public String getIpdizhi() {
		return ipdizhi;
	}
	public void setIpdizhi(String ipdizhi) {
		this.ipdizhi = ipdizhi;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getZhuangtai() {
		return zhuangtai;
	}
	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getGroupname() {
		return groupname;
	}
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
	
}
