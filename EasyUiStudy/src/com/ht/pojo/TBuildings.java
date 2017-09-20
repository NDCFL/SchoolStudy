package com.ht.pojo;

import java.util.Date;

/**
 * TBuildings entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TBuildings implements java.io.Serializable {

	// Fields

	private String idString;
	private String nameString;
	private String areaString;
	private String addressString;
	private Double floorAreaString;
	private Double buildingAreaString;
	private String houseTypeString;
	private String buildingTypeString;
	private Double longitudeDouble;
	private Double latitudeDouble;
	private Double avgPriceDouble;
	private String companyString;
	private Date openDate;
	private Integer totalRoomsInt;
	private String receptionAddressString;
	private String telString;
	private Double greenRatioDouble;
	private Double plotRatioDouble;
	private String propertyCompany;
	private Double propertyFeeDouble;
	private Integer carStationInt;
	private String trafficString;
	private String equipmentsString;
	private String logoString;
	private String introString;
	private Date createdTime;
	private Integer statusInt;

	// Constructors

	/** default constructor */
	public TBuildings() {
	}

	/** minimal constructor */
	public TBuildings(String idString) {
		this.idString = idString;
	}

	/** full constructor */
	public TBuildings(String idString, String nameString, String areaString,
			String addressString, Double floorAreaString,
			Double buildingAreaString, String houseTypeString,
			String buildingTypeString, Double longitudeDouble,
			Double latitudeDouble, Double avgPriceDouble, String companyString,
			Date openDate, Integer totalRoomsInt,
			String receptionAddressString, String telString,
			Double greenRatioDouble, Double plotRatioDouble,
			String propertyCompany, Double propertyFeeDouble,
			Integer carStationInt, String trafficString,
			String equipmentsString, String logoString, String introString,
			Date createdTime, Integer statusInt) {
		this.idString = idString;
		this.nameString = nameString;
		this.areaString = areaString;
		this.addressString = addressString;
		this.floorAreaString = floorAreaString;
		this.buildingAreaString = buildingAreaString;
		this.houseTypeString = houseTypeString;
		this.buildingTypeString = buildingTypeString;
		this.longitudeDouble = longitudeDouble;
		this.latitudeDouble = latitudeDouble;
		this.avgPriceDouble = avgPriceDouble;
		this.companyString = companyString;
		this.openDate = openDate;
		this.totalRoomsInt = totalRoomsInt;
		this.receptionAddressString = receptionAddressString;
		this.telString = telString;
		this.greenRatioDouble = greenRatioDouble;
		this.plotRatioDouble = plotRatioDouble;
		this.propertyCompany = propertyCompany;
		this.propertyFeeDouble = propertyFeeDouble;
		this.carStationInt = carStationInt;
		this.trafficString = trafficString;
		this.equipmentsString = equipmentsString;
		this.logoString = logoString;
		this.introString = introString;
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

	public String getAreaString() {
		return this.areaString;
	}

	public void setAreaString(String areaString) {
		this.areaString = areaString;
	}

	public String getAddressString() {
		return this.addressString;
	}

	public void setAddressString(String addressString) {
		this.addressString = addressString;
	}

	public Double getFloorAreaString() {
		return this.floorAreaString;
	}

	public void setFloorAreaString(Double floorAreaString) {
		this.floorAreaString = floorAreaString;
	}

	public Double getBuildingAreaString() {
		return this.buildingAreaString;
	}

	public void setBuildingAreaString(Double buildingAreaString) {
		this.buildingAreaString = buildingAreaString;
	}

	public String getHouseTypeString() {
		return this.houseTypeString;
	}

	public void setHouseTypeString(String houseTypeString) {
		this.houseTypeString = houseTypeString;
	}

	public String getBuildingTypeString() {
		return this.buildingTypeString;
	}

	public void setBuildingTypeString(String buildingTypeString) {
		this.buildingTypeString = buildingTypeString;
	}

	public Double getLongitudeDouble() {
		return this.longitudeDouble;
	}

	public void setLongitudeDouble(Double longitudeDouble) {
		this.longitudeDouble = longitudeDouble;
	}

	public Double getLatitudeDouble() {
		return this.latitudeDouble;
	}

	public void setLatitudeDouble(Double latitudeDouble) {
		this.latitudeDouble = latitudeDouble;
	}

	public Double getAvgPriceDouble() {
		return this.avgPriceDouble;
	}

	public void setAvgPriceDouble(Double avgPriceDouble) {
		this.avgPriceDouble = avgPriceDouble;
	}

	public String getCompanyString() {
		return this.companyString;
	}

	public void setCompanyString(String companyString) {
		this.companyString = companyString;
	}

	public Date getOpenDate() {
		return this.openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public Integer getTotalRoomsInt() {
		return this.totalRoomsInt;
	}

	public void setTotalRoomsInt(Integer totalRoomsInt) {
		this.totalRoomsInt = totalRoomsInt;
	}

	public String getReceptionAddressString() {
		return this.receptionAddressString;
	}

	public void setReceptionAddressString(String receptionAddressString) {
		this.receptionAddressString = receptionAddressString;
	}

	public String getTelString() {
		return this.telString;
	}

	public void setTelString(String telString) {
		this.telString = telString;
	}

	public Double getGreenRatioDouble() {
		return this.greenRatioDouble;
	}

	public void setGreenRatioDouble(Double greenRatioDouble) {
		this.greenRatioDouble = greenRatioDouble;
	}

	public Double getPlotRatioDouble() {
		return this.plotRatioDouble;
	}

	public void setPlotRatioDouble(Double plotRatioDouble) {
		this.plotRatioDouble = plotRatioDouble;
	}

	public String getPropertyCompany() {
		return this.propertyCompany;
	}

	public void setPropertyCompany(String propertyCompany) {
		this.propertyCompany = propertyCompany;
	}

	public Double getPropertyFeeDouble() {
		return this.propertyFeeDouble;
	}

	public void setPropertyFeeDouble(Double propertyFeeDouble) {
		this.propertyFeeDouble = propertyFeeDouble;
	}

	public Integer getCarStationInt() {
		return this.carStationInt;
	}

	public void setCarStationInt(Integer carStationInt) {
		this.carStationInt = carStationInt;
	}

	public String getTrafficString() {
		return this.trafficString;
	}

	public void setTrafficString(String trafficString) {
		this.trafficString = trafficString;
	}

	public String getEquipmentsString() {
		return this.equipmentsString;
	}

	public void setEquipmentsString(String equipmentsString) {
		this.equipmentsString = equipmentsString;
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

	public Integer getStatusInt() {
		return this.statusInt;
	}

	public void setStatusInt(Integer statusInt) {
		this.statusInt = statusInt;
	}

}