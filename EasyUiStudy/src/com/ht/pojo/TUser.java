package com.ht.pojo;

import java.util.Date;

/**
 * TUser entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TUser implements java.io.Serializable {

	// Fields

	private String idString;
	private String emailString;
	private String phoneString;
	private String pwdString;
	private String qqString;
	private String wechatString;
	private String genderString;
	private Date birthday;
	private String nicknameString;
	private String nameString;
	private String headiconString;

	// Constructors

	/** default constructor */
	public TUser() {
	}

	/** minimal constructor */
	public TUser(String idString) {
		this.idString = idString;
	}

	/** full constructor */
	public TUser(String idString, String emailString, String phoneString,
			String pwdString, String qqString, String wechatString,
			String genderString, Date birthday, String nicknameString,
			String nameString, String headiconString) {
		this.idString = idString;
		this.emailString = emailString;
		this.phoneString = phoneString;
		this.pwdString = pwdString;
		this.qqString = qqString;
		this.wechatString = wechatString;
		this.genderString = genderString;
		this.birthday = birthday;
		this.nicknameString = nicknameString;
		this.nameString = nameString;
		this.headiconString = headiconString;
	}

	// Property accessors

	public String getIdString() {
		return this.idString;
	}

	public void setIdString(String idString) {
		this.idString = idString;
	}

	public String getEmailString() {
		return this.emailString;
	}

	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}

	public String getPhoneString() {
		return this.phoneString;
	}

	public void setPhoneString(String phoneString) {
		this.phoneString = phoneString;
	}

	public String getPwdString() {
		return this.pwdString;
	}

	public void setPwdString(String pwdString) {
		this.pwdString = pwdString;
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

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getNicknameString() {
		return this.nicknameString;
	}

	public void setNicknameString(String nicknameString) {
		this.nicknameString = nicknameString;
	}

	public String getNameString() {
		return this.nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public String getHeadiconString() {
		return this.headiconString;
	}

	public void setHeadiconString(String headiconString) {
		this.headiconString = headiconString;
	}

}