package com.ht.pojo;

import java.util.Date;

/**
 * TEmployee entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TEmployee implements java.io.Serializable {

	// Fields

	private String idString;
	private String nameString;
	private String emailString;
	private String pwdString;
	private String phoneString;
	private String qqString;
	private String wechatString;
	private String genderString;
	private String expString;
	private String desString;
	private String addressString;
	private Double basicSalaryDouble;
	private String headiconString;
	private String introString;
	private String angencyIdString;
	private String buildingIdString;
	private Date createdTime;
	private Integer statusInt;

	// Constructors

	/** default constructor */
	public TEmployee() {
	}

	/** minimal constructor */
	public TEmployee(String idString) {
		this.idString = idString;
	}

	/** full constructor */
	public TEmployee(String idString, String nameString, String emailString,
			String pwdString, String phoneString, String qqString,
			String wechatString, String genderString, String expString,
			String desString, String addressString, Double basicSalaryDouble,
			String headiconString, String introString, String angencyIdString,
			String buildingIdString, Date createdTime, Integer statusInt) {
		this.idString = idString;
		this.nameString = nameString;
		this.emailString = emailString;
		this.pwdString = pwdString;
		this.phoneString = phoneString;
		this.qqString = qqString;
		this.wechatString = wechatString;
		this.genderString = genderString;
		this.expString = expString;
		this.desString = desString;
		this.addressString = addressString;
		this.basicSalaryDouble = basicSalaryDouble;
		this.headiconString = headiconString;
		this.introString = introString;
		this.angencyIdString = angencyIdString;
		this.buildingIdString = buildingIdString;
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

	public String getPhoneString() {
		return this.phoneString;
	}

	public void setPhoneString(String phoneString) {
		this.phoneString = phoneString;
	}

	public String getQqString() {
		return this.qqString;
	}

	public void setQqString(String qqString) {
		this.qqString = qqString;
	}

	public String getWechatString() {
		return this.wechatString;
	}

	public void setWechatString(String wechatString) {
		this.wechatString = wechatString;
	}

	public String getGenderString() {
		return this.genderString;
	}

	public void setGenderString(String genderString) {
		this.genderString = genderString;
	}

	public String getExpString() {
		return this.expString;
	}

	public void setExpString(String expString) {
		this.expString = expString;
	}

	public String getDesString() {
		return this.desString;
	}

	public void setDesString(String desString) {
		this.desString = desString;
	}

	public String getAddressString() {
		return this.addressString;
	}

	public void setAddressString(String addressString) {
		this.addressString = addressString;
	}

	public Double getBasicSalaryDouble() {
		return this.basicSalaryDouble;
	}

	public void setBasicSalaryDouble(Double basicSalaryDouble) {
		this.basicSalaryDouble = basicSalaryDouble;
	}

	public String getHeadiconString() {
		return this.headiconString;
	}

	public void setHeadiconString(String headiconString) {
		this.headiconString = headiconString;
	}

	public String getIntroString() {
		return this.introString;
	}

	public void setIntroString(String introString) {
		this.introString = introString;
	}

	public String getAngencyIdString() {
		return this.angencyIdString;
	}

	public void setAngencyIdString(String angencyIdString) {
		this.angencyIdString = angencyIdString;
	}

	public String getBuildingIdString() {
		return this.buildingIdString;
	}

	public void setBuildingIdString(String buildingIdString) {
		this.buildingIdString = buildingIdString;
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