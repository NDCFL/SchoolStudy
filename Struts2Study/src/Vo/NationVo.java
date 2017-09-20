package Vo;

import java.io.Serializable;

public class NationVo implements Serializable{

	private int nationid;
	private String nationname;
	public int getNationid() {
		return nationid;
	}
	public void setNationid(int nationid) {
		this.nationid = nationid;
	}
	public String getNationname() {
		return nationname;
	}
	public void setNationname(String nationname) {
		this.nationname = nationname;
	}
	
}
