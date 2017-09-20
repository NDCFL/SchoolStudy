package com.ht.pojo;

import java.util.Date;

/**
 * TAppointment entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TAppointment implements java.io.Serializable {

	// Fields

	private String idString;
	private String empIdString;
	private String userIdString;
	private Date appArriveTime;
	private Date arriveTime;
	private String houseIdString;
	private Integer appStatusInt;
	private Date createdTime;
	private Integer status;

	// Constructors

	/** default constructor */
	public TAppointment() {
	}

	/** minimal constructor */
	public TAppointment(String idString) {
		this.idString = idString;
	}

	/** full constructor */
	public TAppointment(String idString, String empIdString,
			String userIdString, Date appArriveTime, Date arriveTime,
			String houseIdString, Integer appStatusInt, Date createdTime,
			Integer status) {
		this.idString = idString;
		this.empIdString = empIdString;
		this.userIdString = userIdString;
		this.appArriveTime = appArriveTime;
		this.arriveTime = arriveTime;
		this.houseIdString = houseIdString;
		this.appStatusInt = appStatusInt;
		this.createdTime = createdTime;
		this.status = status;
	}

	// Property accessors

	public String getIdString() {
		return this.idString;
	}

	public void setIdString(String idString) {
		this.idString = idString;
	}

	public String getEmpIdString() {
		return this.empIdString;
	}

	public void setEmpIdString(String empIdString) {
		this.empIdString = empIdString;
	}

	public String getUserIdString() {
		return this.userIdString;
	}

	public void setUserIdString(String userIdString) {
		this.userIdString = userIdString;
	}

	public Date getAppArriveTime() {
		return this.appArriveTime;
	}

	public void setAppArriveTime(Date appArriveTime) {
		this.appArriveTime = appArriveTime;
	}

	public Date getArriveTime() {
		return this.arriveTime;
	}

	public void setArriveTime(Date arriveTime) {
		this.arriveTime = arriveTime;
	}

	public String getHouseIdString() {
		return this.houseIdString;
	}

	public void setHouseIdString(String houseIdString) {
		this.houseIdString = houseIdString;
	}

	public Integer getAppStatusInt() {
		return this.appStatusInt;
	}

	public void setAppStatusInt(Integer appStatusInt) {
		this.appStatusInt = appStatusInt;
	}

	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}