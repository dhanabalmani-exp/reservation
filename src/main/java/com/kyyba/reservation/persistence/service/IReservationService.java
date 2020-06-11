/**
 * 
 */
package com.kyyba.reservation.persistence.service;

import java.util.List;

import com.kyyba.reservation.exception.ReservationException;
import com.kyyba.reservation.hibernate.core.entity.Vehicle;

/**
 * @author DhanabalM
 *
 */
public interface IReservationService {

	List<Vehicle> getVehicles() throws ReservationException;

}
