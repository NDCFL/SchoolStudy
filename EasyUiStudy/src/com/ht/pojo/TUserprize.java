package com.ht.pojo;

import java.util.Date;

/**
 * TUserprize entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TUserprize implements java.io.Serializable {

	// Fields

	private String idString;
	private String userIdString;
	private Date createTime;
	private String prize;

	// Constructors

	/** default constructor */
	public TUserprize() {
	}

	/** minimal constructor */
	public TUserprize(String idString) {
		this.idString = idString;
	}

	/** full constructor */
	public TUserprize(String idString, String userIdString, Date createTime,
			String prize) {
		this.idString = idString;
		this.userIdString = userIdString;
		this.createTime = createTime;
		this.prize = prize;
	}

	// Property accessors

	public String getIdString() {
		return this.idString;
	}

	public void setIdString(String idString) {
		this.idString = idString;
	}

	public String getUserIdString() {
		return this.userIdString;
	}

	public void setUserIdString(String userIdString) {
		this.userIdString = userIdString;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getPrize() {
		return this.prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}

}