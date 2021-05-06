package com.app;


import java.awt.print.Book;
import java.util.List;

import org.hibernate.MultiIdentifierLoadAccess;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.model.UserDetails;

public class Launcher {

	public static void main(String[] args) throws InterruptedException {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = null;
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		MultiIdentifierLoadAccess<UserDetails> multi = session.byMultipleIds(UserDetails.class);
		List<UserDetails> users = multi.multiLoad(1, 4, 6);
		
		System.out.println("Users Retrieved: "+users);
		
		session.getTransaction().commit();
		session.close();
		
 		
		
	}
	
}