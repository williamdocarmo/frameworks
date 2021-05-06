package com.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.app.model.UserDetails;

public class SecondLevelCache {

	public static void main(String[] args) throws InterruptedException {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = null;

		// First Session
		System.out.println("First Session");
		session = sessionFactory.openSession();
		session.beginTransaction();

		UserDetails user = session.get(UserDetails.class, 2);
		System.out.println("User: " + user);

		user.setUsername("Hello User");

		session.getTransaction().commit();
		session.close();

		// Second Session
		System.out.println("Second Session");
		session = sessionFactory.openSession();
		session.beginTransaction();

		UserDetails user2 = session.get(UserDetails.class, 2);
		System.out.println("User2: " + user2);

		session.getTransaction().commit();
		session.close();
		
		// Third Session
		System.out.println("Third Session");
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query query1 = session.createQuery("from UserDetails where id=2");
		query1.setCacheable(true);
		System.out.println("Result: "+query1.list());
		
		// Fourth Session
		System.out.println("Fourth Session");
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query query2 = session.createQuery("from UserDetails where id=2");
		query2.setCacheable(true);
		System.out.println("Result: "+query2.list());
		
		sessionFactory.close();
	}

}