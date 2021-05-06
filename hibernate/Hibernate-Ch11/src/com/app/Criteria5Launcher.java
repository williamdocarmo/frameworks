package com.app;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.app.model.UserDetails;

public class Criteria5Launcher {

	public static void main(String[] args) throws InterruptedException {
		
		Configuration configuration = new Configuration();
		SessionFactory sessionFactory = configuration.configure("hibernate.config.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<UserDetails> criteriaQuery = criteriaBuilder.createQuery(UserDetails.class);
		Root<UserDetails> root = criteriaQuery.from(UserDetails.class);
		criteriaQuery.select(root).where(criteriaBuilder.gt(root.get("id"), 8));
		Query<UserDetails> query = session.createQuery(criteriaQuery);
		System.out.println("Result List: "+query.getResultList());
		
		
		session.getTransaction().commit();
		session.close();
	}
	
}