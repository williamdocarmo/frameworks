package com.app;

import org.hibernate.Session;

import com.app.model.UserDetails;
import com.app.model.Vehicle;
import com.app.util.HibernateUtil;

public class ORMApplication {
	
	private Session session;
	
	public ORMApplication() {
		this.session = HibernateUtil.getSession();
	}
	
	public void insert() {
		session.beginTransaction();
		UserDetails user = new UserDetails("Second User");
		Vehicle vehicle = new Vehicle("Fiat");
		user.setVehicle(vehicle);
		session.save(user);
		session.getTransaction().commit();
	}
	
	public void insertExisting() {
		session.beginTransaction();
		UserDetails user = new UserDetails("Third User");
		Vehicle vehicle = session.get(Vehicle.class, 2);
		user.setVehicle(vehicle);
		session.save(user);
		// session.save(vehicle);
		session.getTransaction().commit();
	}
	
}
