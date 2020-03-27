package com.hibernate.infra;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
	
	static {
		Logger.getLogger("").setLevel(Level.OFF);
	}

	static SessionFactory sessionFactory;

	public static Session getSession() {
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
		sessionFactory = metadata.getSessionFactoryBuilder().build();
		return sessionFactory.openSession();
	}

	public static void closeResources(Session session) {
		if (null != session && session.isOpen())
			session.close();
		if (null != sessionFactory && !sessionFactory.isClosed())
			sessionFactory.close();

	}

}
