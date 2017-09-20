package com.ht.pojo;

import java.util.Date;

/**
 * TSale entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TSale implements java.io.Serializable {

	// Fields

	private String idString;
	private String customerIdString;
	private Date saleTimeString;
	private Double unitPriceDouble;
	private String roomIdString;
	private Double discountDouble;
	private Double totalCostDouble;
	private String empIdString;
	private Date createdTime;
	private Integer statusInt;

	// Constructors

	/** default constructor */
	public TSale() {
	}

	/** minimal constructor */
	public TSale(String idString) {
		this.idString = idString;
	}

	/** full constructor */
	public TSale(String idString, String customerIdString, Date saleTimeString,
			Double unitPriceDouble, String roomIdString, Double discountDouble,
			Double totalCostDouble, String empIdString, Date createdTime,
			Integer statusInt) {
		this.idString = idString;
		this.customerIdString = customerIdString;
		this.saleTimeString = saleTimeString;
		this.unitPriceDouble = unitPriceDouble;
		this.roomIdString = roomIdString;
		this.discountDouble = discountDouble;
		this.totalCostDouble = totalCostDouble;
		this.empIdString = empIdString;
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

	public String getCustomerIdString() {
		return this.customerIdString;
	}

	public void setCustomerIdString(String customerIdString) {
		this.customerIdString = customerIdString;
	}

	public Date getSaleTimeString() {
		return this.saleTimeString;
	}

	public void setSaleTimeString(Date saleTimeString) {
		this.saleTimeString = saleTimeString;
	}

	public Double getUnitPriceDouble() {
		return this.unitPriceDouble;
	}

	public void setUnitPriceDouble(Double unitPriceDouble) {
		this.unitPriceDouble = unitPriceDouble;
	}

	public String getRoomIdString() {
		return this.roomIdString;
	}

	public void setRoomIdString(String roomIdString) {
		this.roomIdString = roomIdString;
	}

	public Double getDiscountDouble() {
		return this.discountDouble;
	}

	public void setDiscountDouble(Double discountDouble) {
		this.discountDouble = discountDouble;
	}

	public Double getTotalCostDouble() {
		return this.totalCostDouble;
	}

	public void setTotalCostDouble(Double totalCostDouble) {
		this.totalCostDouble = totalCostDouble;
	}

	public String getEmpIdString() {
		return this.empIdString;
	}

	public void setEmpIdString(String empIdString) {
		this.empIdString = empIdString;
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