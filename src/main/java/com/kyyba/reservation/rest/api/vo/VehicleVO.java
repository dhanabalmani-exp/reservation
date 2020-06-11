/**
 * 
 */
package com.kyyba.reservation.rest.api.vo;

/**
 * @author DhanabalM
 *
 */
public class VehicleVO {

	private Integer id;
	private String name;
	private VehicleTypeVO type;
	private double price;

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the type
	 */
	public VehicleTypeVO getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(VehicleTypeVO type) {
		this.type = type;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

}
