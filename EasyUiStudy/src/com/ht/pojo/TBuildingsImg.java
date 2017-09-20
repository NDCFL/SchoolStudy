package com.ht.pojo;

import java.util.Date;

/**
 * TBuildingsImg entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TBuildingsImg implements java.io.Serializable {

	// Fields

	private String idString;
	private String imgPathString;
	private String imgDesString;
	private String buildingsIdString;
	private Date createdTime;

	// Constructors

	/** default constructor */
	public TBuildingsImg() {
	}

	/** minimal constructor */
	public TBuildingsImg(String idString) {
		this.idString = idString;
	}

	/** full constructor */
	public TBuildingsImg(String idString, String imgPathString,
			String imgDesString, String buildingsIdString, Date createdTime) {
		this.idString = idString;
		this.imgPathString = imgPathString;
		this.imgDesString = imgDesString;
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

	public String getImgPathString() {
		return this.imgPathString;
	}

	public void setImgPathString(String imgPathString) {
		this.imgPathString = imgPathString;
	}

	public String getImgDesString() {
		return this.imgDesString;
	}

	public void setImgDesString(String imgDesString) {
		this.imgDesString = imgDesString;
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