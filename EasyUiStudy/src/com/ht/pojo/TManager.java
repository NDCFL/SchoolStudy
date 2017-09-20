package com.ht.pojo;

/**
 * TManager entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TManager implements java.io.Serializable {

	// Fields

	private String idString;
	private String phoneString;
	private String passwordString;
	private String nameString;
	private Integer sexInt;
	private Integer statusInt;
	private Integer typeInt;

	// Constructors

	/** default constructor */
	public TManager() {
	}

	/** minimal constructor */
	public TManager(String idString) {
		this.idString = idString;
	}

	/** full constructor */
	public TManager(String idString, String phoneString, String passwordString,
			String nameString, Integer sexInt, Integer statusInt,
			Integer typeInt) {
		this.idString = idString;
		this.phoneString = phoneString;
		this.passwordString = passwordString;
		this.nameString = nameString;
		this.sexInt = sexInt;
		this.statusInt = statusInt;
		this.typeInt = typeInt;
	}

	// Property accessors

	public String getIdString() {
		return this.idString;
	}

	public void setIdString(String idString) {
		this.idString = idString;
	}

	public String getPhoneString() {
		return this.phoneString;
	}

	public void setPhoneString(String phoneString) {
		this.phoneString = phoneString;
	}

	public String getPasswordString() {
		return this.passwordString;
	}

	public void setPasswordString(String passwordString) {
		this.passwordString = passwordString;
	}

	public String getNameString() {
		return this.nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public Integer getSexInt() {
		return this.sexInt;
	}

	public void setSexInt(Integer sexInt) {
		this.sexInt = sexInt;
	}

	public Integer getStatusInt() {
		return this.statusInt;
	}

	public void setStatusInt(Integer statusInt) {
		this.statusInt = statusInt;
	}

	public Integer getTypeInt() {
		return this.typeInt;
	}

	public void setTypeInt(Integer typeInt) {
		this.typeInt = typeInt;
	}

}