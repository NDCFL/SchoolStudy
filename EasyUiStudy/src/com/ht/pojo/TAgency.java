package com.ht.pojo;

import java.util.Date;

/**
 * TAgency entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TAgency implements java.io.Serializable {

	// Fields

	private String idString;
	private String nameString;
	private String emailString;
	private String pwdString;
	private String leaderString;
	private String phoneString;
	private String telString;
	private String addressString;
	private String logoString;
	private String introString;
	private Date createdTime;
	private Integer checkedStatusInt;
	private Integer statusInt;

	// Constructors

	/** default constructor */
	public TAgency() {
	}

	/** minimal constructor */
	public TAgency(String idString, String nameString, String emailString,
			String pwdString, String phoneString) {
		this.idString = idString;
		this.nameString = nameString;
		this.emailString = emailString;
		this.pwdString = pwdString;
		this.phoneString = phoneString;
	}

	/** full constructor */
	public TAgency(String idString, String nameString, String emailString,
			String pwdString, String leaderString, String phoneString,
			String telString, String addressString, String logoString,
			String introString, Date createdTime, Integer checkedStatusInt,
			Integer statusInt) {
		this.idString = idString;
		this.nameString = nameString;
		this.emailString = emailString;
		this.pwdString = pwdString;
		this.leaderString = leaderString;
		this.phoneString = phoneString;
		this.telString = telString;
		this.addressString = addressString;
		this.logoString = logoString;
		this.introString = introString;
		this.createdTime = createdTime;
		this.checkedStatusInt = checkedStatusInt;
		this.statusInt = statusInt;
	}

	// Property accessors

	public String getIdString() {
		return this.idString;
	}

	public void setIdString(String idString) {
		this.idString = idString;
	}

	public String getNameString() {
		return this.nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public String getEmailString() {
		return this.emailString;
	}

	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}

	public String getPwdString() {
		return this.pwdString;
	}

	public void setPwdString(String pwdString) {
		this.pwdString = pwdString;
	}

	public String getLeaderString() {
		return this.leaderString;
	}

	public void setLeaderString(String leaderString) {
		this.leaderString = leaderString;
	}

	public String getPhoneString() {
		return this.phoneString;
	}

	public void setPhoneString(String phoneString) {
		this.phoneString = phoneString;
	}

	public String getTelString() {
		return this.telString;
	}

	public void setTelString(String telString) {
		this.telString = telString;
	}

	public String getAddressString() {
		return this.addressString;
	}

	public void setAddressString(String addressString) {
		this.addressString = addressString;
	}

	public String getLogoString() {
		return this.logoString;
	}

	public void setLogoString(String logoString) {
		this.logoString = logoString;
	}

	public String getIntroString() {
		return this.introString;
	}

	public void setIntroString(String introString) {
		this.introString = introString;
	}

	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Integer getCheckedStatusInt() {
		return this.checkedStatusInt;
	}

	public void setCheckedStatusInt(Integer checkedStatusInt) {
		this.checkedStatusInt = checkedStatusInt;
	}

	public Integer getStatusInt() {
		return this.statusInt;
	}

	public void setStatusInt(Integer statusInt) {
		this.statusInt = statusInt;
	}

}