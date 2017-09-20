package com.ht.pojo;

import java.util.Date;

/**
 * TEmployeesalary entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TEmployeesalary implements java.io.Serializable {

	// Fields

	private String salaryIdString;
	private String emoloyeeIdString;
	private String userIdString;
	private Double salaryDouble;
	private String reason;
	private Date createTime;

	// Constructors

	/** default constructor */
	public TEmployeesalary() {
	}

	/** minimal constructor */
	public TEmployeesalary(String salaryIdString) {
		this.salaryIdString = salaryIdString;
	}

	/** full constructor */
	public TEmployeesalary(String salaryIdString, String emoloyeeIdString,
			String userIdString, Double salaryDouble, String reason,
			Date createTime) {
		this.salaryIdString = salaryIdString;
		this.emoloyeeIdString = emoloyeeIdString;
		this.userIdString = userIdString;
		this.salaryDouble = salaryDouble;
		this.reason = reason;
		this.createTime = createTime;
	}

	// Property accessors

	public String getSalaryIdString() {
		return this.salaryIdString;
	}

	public void setSalaryIdString(String salaryIdString) {
		this.salaryIdString = salaryIdString;
	}

	public String getEmoloyeeIdString() {
		return this.emoloyeeIdString;
	}

	public void setEmoloyeeIdString(String emoloyeeIdString) {
		this.emoloyeeIdString = emoloyeeIdString;
	}

	public String getUserIdString() {
		return this.userIdString;
	}

	public void setUserIdString(String userIdString) {
		this.userIdString = userIdString;
	}

	public Double getSalaryDouble() {
		return this.salaryDouble;
	}

	public void setSalaryDouble(Double salaryDouble) {
		this.salaryDouble = salaryDouble;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}