package com.ht.pojo;

/**
 * TMission entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TMission implements java.io.Serializable {

	// Fields

	private String idString;
	private Integer quantityInt;
	private Integer monthesint;
	private String empIdString;
	private Double bonusPercentDouble;

	// Constructors

	/** default constructor */
	public TMission() {
	}

	/** minimal constructor */
	public TMission(String idString) {
		this.idString = idString;
	}

	/** full constructor */
	public TMission(String idString, Integer quantityInt, Integer monthesint,
			String empIdString, Double bonusPercentDouble) {
		this.idString = idString;
		this.quantityInt = quantityInt;
		this.monthesint = monthesint;
		this.empIdString = empIdString;
		this.bonusPercentDouble = bonusPercentDouble;
	}

	// Property accessors

	public String getIdString() {
		return this.idString;
	}

	public void setIdString(String idString) {
		this.idString = idString;
	}

	public Integer getQuantityInt() {
		return this.quantityInt;
	}

	public void setQuantityInt(Integer quantityInt) {
		this.quantityInt = quantityInt;
	}

	public Integer getMonthesint() {
		return this.monthesint;
	}

	public void setMonthesint(Integer monthesint) {
		this.monthesint = monthesint;
	}

	public String getEmpIdString() {
		return this.empIdString;
	}

	public void setEmpIdString(String empIdString) {
		this.empIdString = empIdString;
	}

	public Double getBonusPercentDouble() {
		return this.bonusPercentDouble;
	}

	public void setBonusPercentDouble(Double bonusPercentDouble) {
		this.bonusPercentDouble = bonusPercentDouble;
	}

}