package com.app;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.app.model.UserDetails;

public class ExampleLauncher {

	public static void main(String[] args) throws InterruptedException {

		Configuration configuration = new Configuration();
		SessionFactory sessionFactory = configuration.configure("hibernate.config.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		UserDetails example = null;
		Criteria criteria = null;
		
		example = new UserDetails("User 4");
		criteria = session.createCriteria(UserDetails.class).add(Example.create(example));
		System.out.println("resultList1: " + criteria.list());
		
		example = new UserDetails("User %");
		criteria = session.createCriteria(UserDetails.class).add(Example.create(example).enableLike());
		System.out.println("resultList2: " + criteria.list());
		
		session.getTransaction().commit();
		session.close();
	}

}