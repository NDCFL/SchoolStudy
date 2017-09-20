package com.ht.pojo;

import java.util.Date;

/**
 * TCustomer entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TCustomer implements java.io.Serializable {

	// Fields

	private String idString;
	private String nameString;
	private String genderString;
	private Date birthday;
	private String identityIdString;
	private String emailString;
	private String phoneString;
	private String addressString;
	private String customerTypeString;
	private String togetherString;
	private String contractString;
	private String archivesString;
	private Date createdTime;
	private Integer statusInt;

	// Constructors

	/** default constructor */
	public TCustomer() {
	}

	/** minimal constructor */
	public TCustomer(String idString) {
		this.idString = idString;
	}

	/** full constructor */
	public TCustomer(String idString, String nameString, String genderString,
			Date birthday, String identityIdString, String emailString,
			String phoneString, String addressString,
			String customerTypeString, String togetherString,
			String contractString, String archivesString, Date createdTime,
			Integer statusInt) {
		this.idString = idString;
		this.nameString = nameString;
		this.genderString = genderString;
		this.birthday = birthday;
		this.identityIdString = identityIdString;
		this.emailString = emailString;
		this.phoneString = phoneString;
		this.addressString = addressString;
		this.customerTypeString = customerTypeString;
		this.togetherString = togetherString;
		this.contractString = contractString;
		this.archivesString = archivesString;
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

	public String getIdentityIdString() {
		return this.identityIdString;
	}

	public void setIdentityIdString(String identityIdString) {
		this.identityIdString = identityIdString;
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

	public String getAddressString() {
		return this.addressString;
	}

	public void setAddressString(String addressString) {
		this.addressString = addressString;
	}

	public String getCustomerTypeString() {
		return this.customerTypeString;
	}

	public void setCustomerTypeString(String customerTypeString) {
		this.customerTypeString = customerTypeString;
	}

	public String getTogetherString() {
		return this.togetherString;
	}

	public void setTogetherString(String togetherString) {
		this.togetherString = togetherString;
	}

	public String getContractString() {
		return this.contractString;
	}

	public void setContractString(String contractString) {
		this.contractString = contractString;
	}

	public String getArchivesString() {
		return this.archivesString;
	}

	public void setArchivesString(String archivesString) {
		this.archivesString = archivesString;
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