package com.app;

import java.util.List;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.graph.RootGraph;
import org.hibernate.query.Query;

import com.app.model.UserDetails;

public class Launcher {

	public static void main(String[] args) throws InterruptedException {

		SessionFactory sessionFactory = getHibernateConfiguration().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		UserDetails user = new UserDetails("Santanu");
		session.persist(user);

		session.getTransaction().commit();
		session.close();
		
		
		
	}

	private static Configuration getHibernateConfiguration() {
		Configuration configuration = new Configuration();
		Properties props = new Properties();
		props.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		props.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		props.put("hibernate.connection.username", "root");
		props.put("hibernate.connection.password", "System123");
		props.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/sys");
		props.put("hibernate.hbm2ddl.auto", "update");
		props.put("cache.provider_class", "org.hibernate.cache.NoCacheProvider");
		props.put("connection.pool_size", "10");
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.format_sql", "false");
		props.put("hibernate.use_sql_comments", "false");
		configuration.addAnnotatedClass(UserDetails.class);
		return configuration.addProperties(props);
	}

}