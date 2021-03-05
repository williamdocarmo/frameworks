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
		UserDetails user = new UserDetails("First User");
		user.addVehicle(new Vehicle("Maruti", user));
		user.addVehicle(new Vehicle("Fiat", user));
		session.persist(user);
		session.getTransaction().commit();
	}
	
	public void insertExisting() {
		session.beginTransaction();
		UserDetails user = new UserDetails("Second User");
		
		Vehicle v2 = session.get(Vehicle.class, 2);
		v2.addUser(user);
		user.addVehicle(v2);
		
		user.addVehicle(new Vehicle("Honda", user));
		
		session.save(user);
		session.getTransaction().commit();
	}
	
	public void getVehicle() {
		session.beginTransaction();
		Vehicle v2 = session.get(Vehicle.class, 2);
		System.out.println("Retrieved: "+v2);
	}
	
	public void deleteExisting() {
		session.beginTransaction();
		UserDetails user = session.get(UserDetails.class, 3);
		session.delete(user);
		session.getTransaction().commit();
	}
	
	
}
