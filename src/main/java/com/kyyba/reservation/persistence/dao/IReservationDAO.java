/**
 * 
 */
package com.kyyba.reservation.persistence.dao;

import java.util.List;

import com.kyyba.reservation.exception.ReservationException;
import com.kyyba.reservation.hibernate.core.entity.City;
import com.kyyba.reservation.hibernate.core.entity.Vehicle;

/**
 * @author DhanabalM
 *
 */
public interface IReservationDAO {

	List<City> getCities() throws ReservationException;

	List<Vehicle> getVehicles() throws ReservationException;

}
