/**
 * 
 */
package com.kyyba.reservation.persistence.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.kyyba.reservation.exception.ReservationException;
import com.kyyba.reservation.hibernate.core.entity.City;
import com.kyyba.reservation.hibernate.core.entity.Vehicle;
import com.kyyba.reservation.persistence.dao.IReservationDAO;

/**
 * @author DhanabalM
 *
 */
@Repository
public class ReservationDAO implements IReservationDAO {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<City> getCities() throws ReservationException {
		Session session = null;
		List<City> cities = null;
		try {
			/**
			 * Note: Open a new hibernate session, which is not participated in any transaction, execute and close. It
			 * should be used by any service class, which does not use transaction for service api.
			 */
			session = hibernateTemplate.getSessionFactory().openSession();
			cities = (List<City>) session.createSQLQuery("select * from city").list();

		} catch (HibernateException ex) {
			throw new ReservationException("Error while", ex);
		} finally {
			try{ if (session != null && session.isOpen()) { session.close(); } } catch (HibernateException ex) { } 
		}
		
		return cities;
	}
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Vehicle> getVehicles() throws ReservationException {
		Session session = null;
		List<Vehicle> vehicles = null;
		try {
			/**
			 * Note: Open a new hibernate session, which is not participated in any transaction, execute and close. It
			 * should be used by any service class, which does not use transaction for service api.
			 */
			session = hibernateTemplate.getSessionFactory().openSession();
			vehicles = (List<Vehicle>) session.createQuery("from city").list();

		} catch (HibernateException ex) {
			throw new ReservationException("Error while", ex);
		} finally {
			try{ if (session != null && session.isOpen()) { session.close(); } } catch (HibernateException ex) { } 
		}
		
		return vehicles;
	}

}
