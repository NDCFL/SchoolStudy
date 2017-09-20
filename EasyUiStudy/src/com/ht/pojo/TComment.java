package com.ht.pojo;

import java.util.Date;

/**
 * TComment entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TComment implements java.io.Serializable {

	// Fields

	private String idString;
	private String contentString;
	private String buildingsIdString;
	private Date commentTime;
	private String userIdString;
	private Integer status;

	// Constructors

	/** default constructor */
	public TComment() {
	}

	/** minimal constructor */
	public TComment(String idString) {
		this.idString = idString;
	}

	/** full constructor */
	public TComment(String idString, String contentString,
			String buildingsIdString, Date commentTime, String userIdString,
			Integer status) {
		this.idString = idString;
		this.contentString = contentString;
		this.buildingsIdString = buildingsIdString;
		this.commentTime = commentTime;
		this.userIdString = userIdString;
		this.status = status;
	}

	// Property accessors

	public String getIdString() {
		return this.idString;
	}

	public void setIdString(String idString) {
		this.idString = idString;
	}

	public String getContentString() {
		return this.contentString;
	}

	public void setContentString(String contentString) {
		this.contentString = contentString;
	}

	public String getBuildingsIdString() {
		return this.buildingsIdString;
	}

	public void setBuildingsIdString(String buildingsIdString) {
		this.buildingsIdString = buildingsIdString;
	}

	public Date getCommentTime() {
		return this.commentTime;
	}

	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

	public String getUserIdString() {
		return this.userIdString;
	}

	public void setUserIdString(String userIdString) {
		this.userIdString = userIdString;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}