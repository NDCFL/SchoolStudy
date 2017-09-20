package com.ht.pojo;

import java.util.Date;

/**
 * TActivity entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TActivity implements java.io.Serializable {

	// Fields

	private String idString;
	private String titleString;
	private Date startTime;
	private Date endTime;
	private String addressString;
	private String contentString;
	private String logoString;
	private String buildingsIdString;

	// Constructors

	/** default constructor */
	public TActivity() {
	}

	/** minimal constructor */
	public TActivity(String idString) {
		this.idString = idString;
	}

	/** full constructor */
	public TActivity(String idString, String titleString, Date startTime,
			Date endTime, String addressString, String contentString,
			String logoString, String buildingsIdString) {
		this.idString = idString;
		this.titleString = titleString;
		this.startTime = startTime;
		this.endTime = endTime;
		this.addressString = addressString;
		this.contentString = contentString;
		this.logoString = logoString;
		this.buildingsIdString = buildingsIdString;
	}

	// Property accessors

	public String getIdString() {
		return this.idString;
	}

	public void setIdString(String idString) {
		this.idString = idString;
	}

	public String getTitleString() {
		return this.titleString;
	}

	public void setTitleString(String titleString) {
		this.titleString = titleString;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getAddressString() {
		return this.addressString;
	}

	public void setAddressString(String addressString) {
		this.addressString = addressString;
	}

	public String getContentString() {
		return this.contentString;
	}

	public void setContentString(String contentString) {
		this.contentString = contentString;
	}

	public String getLogoString() {
		return this.logoString;
	}

	public void setLogoString(String logoString) {
		this.logoString = logoString;
	}

	public String getBuildingsIdString() {
		return this.buildingsIdString;
	}

	public void setBuildingsIdString(String buildingsIdString) {
		this.buildingsIdString = buildingsIdString;
	}

}