package com.ht.pojo;

import java.util.Date;

/**
 * TLike entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TLike implements java.io.Serializable {

	// Fields

	private String idString;
	private String userIdString;
	private String buildingsIdString;
	private Date createdTime;

	// Constructors

	/** default constructor */
	public TLike() {
	}

	/** minimal constructor */
	public TLike(String idString) {
		this.idString = idString;
	}

	/** full constructor */
	public TLike(String idString, String userIdString,
			String buildingsIdString, Date createdTime) {
		this.idString = idString;
		this.userIdString = userIdString;
		this.buildingsIdString = buildingsIdString;
		this.createdTime = createdTime;
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

	public String getBuildingsIdString() {
		return this.buildingsIdString;
	}

	public void setBuildingsIdString(String buildingsIdString) {
		this.buildingsIdString = buildingsIdString;
	}

	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

}