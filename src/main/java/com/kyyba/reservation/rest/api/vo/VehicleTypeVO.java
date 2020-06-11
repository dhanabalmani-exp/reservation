/**
 * 
 */
package com.kyyba.reservation.rest.api.vo;

/**
 * @author DhanabalM
 *
 */
public class VehicleTypeVO {

	private Integer id;
	private String type;

	public VehicleTypeVO() {
		super();
	}

	public VehicleTypeVO(Integer id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

}
