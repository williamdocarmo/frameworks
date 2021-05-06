package com.app;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.model.UserDetails;

public class FirstLevelCache {

	public static void main(String[] args) throws InterruptedException {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = null;
		
		// First Session
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		UserDetails user = session.get(UserDetails.class, 2);
		System.out.println("User: " +user);
		
		session.getTransaction().commit();
		session.close();
		
		// Second Session
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		UserDetails user2 = session.get(UserDetails.class, 2);
		System.out.println("User2: " +user2);
		
		session.getTransaction().commit();
		session.close();
 		
		
	}
	
}