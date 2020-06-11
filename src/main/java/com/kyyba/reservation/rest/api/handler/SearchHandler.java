/**
 * 
 */
package com.kyyba.reservation.rest.api.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kyyba.reservation.persistence.service.IReservationService;
import com.kyyba.reservation.rest.api.vo.VehicleTypeResponseVO;

/**
 * @author DhanabalM
 *
 */
@Component
public class SearchHandler {

	@Autowired
	private IReservationService reservationService;

	public VehicleTypeResponseVO search(Integer vehicleTypeId, Integer fromCityId, Integer toCityId, String searchDate) {

		final VehicleTypeResponseVO vo = new VehicleTypeResponseVO();
		vo.setVehicle(reservationService.getVehicles());

		return vo;
	}

	/*private VehicleTypeResponseVO getSample(final List<Vehicle> vehicle) {
	
		final List<VehicleVO> vo
		
		return vo;
	}*/

}
