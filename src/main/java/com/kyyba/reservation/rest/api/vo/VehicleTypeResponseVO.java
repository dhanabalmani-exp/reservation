/**
 * 
 */
package com.kyyba.reservation.rest.api.vo;

import java.util.List;

import com.kyyba.reservation.hibernate.core.entity.Vehicle;

/**
 * @author DhanabalM
 *
 */
public class VehicleTypeResponseVO {

	private List<Vehicle> vehicles;

	/**
	 * @return the vehicles
	 */
	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	/**
	 * @param vehicles
	 *            the vehicle to set
	 */
	public void setVehicle(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

}
