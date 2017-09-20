package com.ht.pojo;

import java.util.Date;

/**
 * TArticle entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TArticle implements java.io.Serializable {

	// Fields

	private String idString;
	private String titleString;
	private String abstractsString;
	private String contentString;
	private String logoString;
	private Date createdTime;
	private Integer statusInt;

	// Constructors

	/** default constructor */
	public TArticle() {
	}

	/** minimal constructor */
	public TArticle(String idString) {
		this.idString = idString;
	}

	/** full constructor */
	public TArticle(String idString, String titleString,
			String abstractsString, String contentString, String logoString,
			Date createdTime, Integer statusInt) {
		this.idString = idString;
		this.titleString = titleString;
		this.abstractsString = abstractsString;
		this.contentString = contentString;
		this.logoString = logoString;
		this.createdTime = createdTime;
		this.statusInt = statusInt;
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

	public String getAbstractsString() {
		return this.abstractsString;
	}

	public void setAbstractsString(String abstractsString) {
		this.abstractsString = abstractsString;
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

	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Integer getStatusInt() {
		return this.statusInt;
	}

	public void setStatusInt(Integer statusInt) {
		this.statusInt = statusInt;
	}

}