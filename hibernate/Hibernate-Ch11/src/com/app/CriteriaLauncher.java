package com.app;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.app.model.UserDetails;

public class CriteriaLauncher {

	public static void main(String[] args) throws InterruptedException {
		
		Configuration configuration = new Configuration();
		SessionFactory sessionFactory = configuration.configure("hibernate.config.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Criteria criteria = null;
		
		//ID Equals
		criteria = session.createCriteria(UserDetails.class);
		criteria.add(Restrictions.idEq(5));
		System.out.println("criteria.list()1: "+criteria.list());
		
		// Parameter Between
		criteria = session.createCriteria(UserDetails.class);
		criteria.add(Restrictions.between("id", 3, 5));
		System.out.println("criteria.list()2: "+criteria.list());
		
		// Values in
		criteria = session.createCriteria(UserDetails.class);
		List<String> in = new ArrayList<String>();
		in.add("User 4"); in.add("User 5");
		criteria.add(Restrictions.in("username", in));
		System.out.println("criteria.list()3: "+criteria.list());
		
		// Parameter AND: Greater and Less than
		criteria = session.createCriteria(UserDetails.class);
		criteria.add(Restrictions.and(Restrictions.ge("id", 4), Restrictions.lt("id", 6)));
		System.out.println("criteria.list()4: "+criteria.list());
		
		// Parameter OR: ID equals and Value equals
		criteria = session.createCriteria(UserDetails.class);
		criteria.add(Restrictions.or(Restrictions.idEq(5), Restrictions.eq("username", "User 6")));
		System.out.println("criteria.list()5: "+criteria.list());
		
		// Not check: ID equals and Value equals
		criteria = session.createCriteria(UserDetails.class);
		criteria.add(Restrictions.not(Restrictions.gt("id", 3)));
		System.out.println("criteria.list()5: "+criteria.list());
		
		// Like
		criteria = session.createCriteria(UserDetails.class);
		criteria.add(Restrictions.like("username", "User 1", MatchMode.ANYWHERE));
		System.out.println("criteria.list()6: "+criteria.list());
		
		session.getTransaction().commit();
		session.close();
	}
	
}