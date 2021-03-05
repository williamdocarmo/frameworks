package com.app;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.app.model.UserDetails;

public class Launcher {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		
		Configuration configuration = new Configuration();
		SessionFactory sessionFactory = configuration.configure("hibernate.config.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		// Select All
		Query<UserDetails> userQuery = session.createQuery("from UserDetails");
		userQuery.setFirstResult(1);
		userQuery.setMaxResults(2);
		List<UserDetails> users = userQuery.list();
		for (UserDetails u : users) {
			System.out.println("User1: "+u.getUsername());
		}
		
		// Select a Particular Column
		Query<String> userNameQuery = session.createQuery("select username from UserDetails");
		userNameQuery.setFirstResult(1);
		userNameQuery.setMaxResults(2);
		List<String> usernames = userNameQuery.list();
		for (String u : usernames) {
			System.out.println("User2: "+u);
		}
		
		// Select more than one Columns
		Query<Object[]> userIdNameQuery = session.createQuery("select id, username from UserDetails");
		userIdNameQuery.setFirstResult(1);
		userIdNameQuery.setMaxResults(2);
		List<Object[]> userIdNames = userIdNameQuery.list();
		for (Object[] userIdName  : userIdNames) {
			for (Object u : userIdName) {
				System.out.println("User3: "+u);
			}
		}
		
		// Select Count
		Query<Integer> countQuery = session.createQuery("select count(*) from UserDetails");
		List<Integer> count = countQuery.list();
		System.out.println("Count: "+count.get(0));
		
		// Parameterized Query - Numeric Placeholder
		Query<UserDetails> parameterizedQuery = session.createQuery("select username from UserDetails where id > ?0 and id < ?1");
		parameterizedQuery.setParameter(0, 6);
		parameterizedQuery.setParameter(1, 11);
		List<UserDetails> users2 = parameterizedQuery.list();
		System.out.println("Users in Range: "+users2);
		
		// Parameterized Query - Name Placeholder
		Query<UserDetails> parameterizeQuerywithName = session.createQuery("select username from UserDetails where id > :idStart and id < :idEnd");
		parameterizeQuerywithName.setParameter("idStart", 6);
		parameterizeQuerywithName.setParameter("idEnd", 11);
		List<UserDetails> users3 = parameterizeQuerywithName.list();
		System.out.println("Users in Range: "+users3);
		
		// Named Query
		Query<UserDetails> namedQuery = session.getNamedQuery("UserDetails.byId");
		namedQuery.setParameter("id", 5);
		List<UserDetails> user = namedQuery.list();
		System.out.println("User Retrieved using Named Query: "+user);
		
		// Named Query
		namedQuery = session.getNamedQuery("UserDetails.getAll");
		user = namedQuery.list();
		System.out.println("User Retrieved using Named Query: "+user);
		
		// Named Native Query
		Query<UserDetails> namedNativeQuery = session.getNamedNativeQuery("UserDetails.byIdNative");
		namedNativeQuery.setParameter("id", 5);
		List<UserDetails> userbyNamedNativeQuery = namedNativeQuery.list();
		System.out.println("User Retrieved using Named Native Query: "+userbyNamedNativeQuery);
		
		// Native Query - Select
		Query<String> nativeQuerySelect = session.createNativeQuery("select username from UserDetails where id= :id");
		nativeQuerySelect.setParameter("id", "5");
		String userbyNativeQuery = nativeQuerySelect.uniqueResult();
		System.out.println("User Retrieved using Native Query: "+userbyNativeQuery);
		
		// Native Query - Insert
		Query<String> nativeQueryInsert = session.createNativeQuery("insert into userdetails values (:id, :username)");
		nativeQueryInsert.setParameter("id", "99");
		nativeQueryInsert.setParameter("username", "customer 99");
		nativeQueryInsert.executeUpdate();
		System.out.println("User Retrieved using Native Query: "+userbyNativeQuery);
		
		session.getTransaction().commit();
		session.close();
	}
	
}