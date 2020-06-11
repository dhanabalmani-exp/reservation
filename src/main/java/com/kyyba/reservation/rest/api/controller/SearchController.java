/**
 * 
 */
package com.kyyba.reservation.rest.api.controller;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kyyba.reservation.rest.api.handler.SearchHandler;
import com.kyyba.reservation.rest.api.vo.VehicleTypeResponseVO;

/**
 * @author DhanabalM
 *
 */
@RestController
@RequestMapping("/api/vehicle/{vehicleTypeId}/search")
public class SearchController {
	
	@Autowired
	private SearchHandler handler;

	@RequestMapping(value = "/{fromCityId}/{toCityId}/{searchDate}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public VehicleTypeResponseVO search(@PathVariable("vehicleTypeId") final Integer vehicleTypeId,
			@PathVariable("fromCityId") final Integer fromCityId, @PathVariable("toCityId") final Integer toCityId,
			@PathVariable("searchDate") final String searchDate) {

		final VehicleTypeResponseVO vo = handler.search(vehicleTypeId, fromCityId, toCityId, searchDate);

		return vo;
	}
}
