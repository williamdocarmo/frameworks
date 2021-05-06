package com.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.model.UserDetails;

public class Launcher {

	public static void main(String[] args) throws InterruptedException {
		
		// create();
		// read();
		// delete();
		
		update();
	}

	private static void create() {
		// Transient Object
		UserDetails user = new UserDetails("First User");
		
		Configuration configuration = new Configuration();
		SessionFactory sessionFactory = configuration.configure("hibernate.config.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		// Persistent Object
		session.save(user);
		user.setUsername("Updated User");
		user.setUsername("Updated User Name");
		
		session.getTransaction().commit();
		session.close();
		
		// Detached Object
		user.setUsername("User After Session Close");
	}
	
	private static void read() {
		Configuration configuration = new Configuration();
		SessionFactory sessionFactory = configuration.configure("hibernate.config.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		// Persistent Object
		UserDetails user = session.get(UserDetails.class, 1);
		
		user.setUsername("Updated User After Get");

		session.getTransaction().commit();
		session.close();
		
	}
	
	private static void delete() {
		Configuration configuration = new Configuration();
		SessionFactory sessionFactory = configuration.configure("hibernate.config.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		// Persistent Object
		UserDetails user = session.get(UserDetails.class, 2);
		session.delete(user);
		
		// Transient
		user.setUsername("Setting After Delete");

		session.getTransaction().commit();
		session.close();
		
	}
	
	private static void update() {
		Configuration configuration = new Configuration();
		SessionFactory sessionFactory = configuration.configure("hibernate.config.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		// Persistent Object
		UserDetails user = session.get(UserDetails.class, 3);
		
		session.close();
		
		// Detached
		// user.setUsername("Setting After Update");

		session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		session.update(user);
		
		
		session.getTransaction().commit();
		session.close();
		
	}

}