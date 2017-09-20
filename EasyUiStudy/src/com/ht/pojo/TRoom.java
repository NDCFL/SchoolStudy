package com.ht.pojo;

/**
 * TRoom entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TRoom implements java.io.Serializable {

	// Fields

	private String idString;
	private String houseIdString;
	private String buildingIdString;
	private String nameString;
	private Integer saleStatusInt;

	// Constructors

	/** default constructor */
	public TRoom() {
	}

	/** minimal constructor */
	public TRoom(String idString) {
		this.idString = idString;
	}

	/** full constructor */
	public TRoom(String idString, String houseIdString,
			String buildingIdString, String nameString, Integer saleStatusInt) {
		this.idString = idString;
		this.houseIdString = houseIdString;
		this.buildingIdString = buildingIdString;
		this.nameString = nameString;
		this.saleStatusInt = saleStatusInt;
	}

	// Property accessors

	public String getIdString() {
		return this.idString;
	}

	public void setIdString(String idString) {
		this.idString = idString;
	}

	public String getHouseIdString() {
		return this.houseIdString;
	}

	public void setHouseIdString(String houseIdString) {
		this.houseIdString = houseIdString;
	}

	public String getBuildingIdString() {
		return this.buildingIdString;
	}

	public void setBuildingIdString(String buildingIdString) {
		this.buildingIdString = buildingIdString;
	}

	public String getNameString() {
		return this.nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public Integer getSaleStatusInt() {
		return this.saleStatusInt;
	}

	public void setSaleStatusInt(Integer saleStatusInt) {
		this.saleStatusInt = saleStatusInt;
	}

}