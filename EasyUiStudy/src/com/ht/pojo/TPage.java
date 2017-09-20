package com.ht.pojo;

/**
 * TPage entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TPage implements java.io.Serializable {

	// Fields

	private TPageId id;

	// Constructors

	/** default constructor */
	public TPage() {
	}

	/** full constructor */
	public TPage(TPageId id) {
		this.id = id;
	}

	// Property accessors

	public TPageId getId() {
		return this.id;
	}

	public void setId(TPageId id) {
		this.id = id;
	}

}