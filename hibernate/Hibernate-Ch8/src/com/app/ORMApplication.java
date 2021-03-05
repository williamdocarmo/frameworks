package com.app;

import org.hibernate.Session;

import com.app.model.Bike;
import com.app.model.Car;
import com.app.model.Vehicle;
import com.app.util.HibernateUtil;

public class ORMApplication {
	
	private Session session;
	
	public ORMApplication() {
		this.session = HibernateUtil.getSession();
	}
	
	public void persistVehicle() {
		session.beginTransaction();
		
		Vehicle vehicle = new Vehicle("Boeing");
		Bike bike = new Bike("Honda", "Steering Handle");
		Car car = new Car("BMW", "Steering Wheel");
		
		session.persist(vehicle);
		session.persist(bike);
		session.persist(car);
		
		session.getTransaction().commit();
	}
	
	
	
}
