/**
 * 
 */
package com.kyyba.reservation.persistence.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyyba.reservation.exception.ReservationException;
import com.kyyba.reservation.hibernate.core.entity.Vehicle;
import com.kyyba.reservation.persistence.dao.IReservationDAO;
import com.kyyba.reservation.persistence.service.IReservationService;

/**
 * @author DhanabalM
 *
 */
@Service
public class ReservationService implements IReservationService {
	
	@Autowired
	private IReservationDAO reservationDAO;
	
	@Override
	public List<Vehicle> getVehicles() throws ReservationException {
		return reservationDAO.getVehicles();
		
	}

}
