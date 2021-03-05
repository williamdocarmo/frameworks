package com.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.graph.RootGraph;
import org.hibernate.query.Query;

import com.app.model.UserDetails;

public class Launcher {

	public static void main(String[] args) throws InterruptedException {

		Configuration configuration = new Configuration();
		SessionFactory sessionFactory = configuration.configure("hibernate.config.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query<UserDetails> userQuery = session.createQuery("from UserDetails", UserDetails.class);
		List<UserDetails> result = userQuery.list();
		System.out.println("Result: "+result);

		session.getTransaction().commit();
		session.close();

	}

}