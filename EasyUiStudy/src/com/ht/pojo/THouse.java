package com.ht.pojo;

import java.util.Date;

/**
 * THouse entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class THouse implements java.io.Serializable {

	// Fields

	private String idString;
	private String nameString;
	private String logoString;
	private String introString;
	private Double areaDouble;
	private Double unitPriceDouble;
	private String buildingsIdString;
	private Date createdTime;
	private Integer statusInt;

	// Constructors

	/** default constructor */
	public THouse() {
	}

	/** minimal constructor */
	public THouse(String idString) {
		this.idString = idString;
	}

	/** full constructor */
	public THouse(String idString, String nameString, String logoString,
			String introString, Double areaDouble, Double unitPriceDouble,
			String buildingsIdString, Date createdTime, Integer statusInt) {
		this.idString = idString;
		this.nameString = nameString;
		this.logoString = logoString;
		this.introString = introString;
		this.areaDouble = areaDouble;
		this.unitPriceDouble = unitPriceDouble;
		this.buildingsIdString = buildingsIdString;
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

	public Double getAreaDouble() {
		return this.areaDouble;
	}

	public void setAreaDouble(Double areaDouble) {
		this.areaDouble = areaDouble;
	}

	public Double getUnitPriceDouble() {
		return this.unitPriceDouble;
	}

	public void setUnitPriceDouble(Double unitPriceDouble) {
		this.unitPriceDouble = unitPriceDouble;
	}

	public String getBuildingsIdString() {
		return this.buildingsIdString;
	}

	public void setBuildingsIdString(String buildingsIdString) {
		this.buildingsIdString = buildingsIdString;
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