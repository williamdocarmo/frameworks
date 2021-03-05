package com.app;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.app.model.UserDetails;

public class ProjectionsLauncher {

	public static void main(String[] args) throws InterruptedException {

		Configuration configuration = new Configuration();
		SessionFactory sessionFactory = configuration.configure("hibernate.config.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Criteria criteria = null;
		List<UserDetails> resultList = null;

		// Select Column
		criteria = session.createCriteria(UserDetails.class).setProjection(Projections.property("id"));
		System.out.println("resultList1: " + criteria.list());
		
		// Select Max
		criteria = session.createCriteria(UserDetails.class).setProjection(Projections.max("id"));
		System.out.println("resultList2: " + criteria.list());
		
		// Select count
		criteria = session.createCriteria(UserDetails.class).setProjection(Projections.count("id"));
		System.out.println("resultList3: " + criteria.list());
		
		// Select Distinct
		criteria = session.createCriteria(UserDetails.class).setProjection(Projections.countDistinct("username"));
		System.out.println("resultList4: " + criteria.list());
		
		// Select all ID
		criteria = session.createCriteria(UserDetails.class).setProjection(Projections.id());
		System.out.println("resultList5: " + criteria.list());
		
		// Select row count
		criteria = session.createCriteria(UserDetails.class).setProjection(Projections.rowCount());
		System.out.println("resultList6: " + criteria.list());
		
		// Select row count
		criteria = session.createCriteria(UserDetails.class).setProjection(Projections.groupProperty("id"))
				.addOrder(Order.desc("id" ));
		System.out.println("resultList7: " + criteria.list());

		session.getTransaction().commit();
		session.close();
	}

}