package com.app;

import org.hibernate.Session;

import com.app.model.UserDetails;
import com.app.model.Account;
import com.app.util.HibernateUtil;

public class ORMApplication {
	
	private Session session;
	
	public ORMApplication() {
		this.session = HibernateUtil.getSession();
	}
	
	public void insert() {
		session.beginTransaction();
		UserDetails user = new UserDetails("First User");
		user.addAccount(new Account("Account1", user));
		user.addAccount(new Account("Account2", user));
		session.save(user);
		session.getTransaction().commit();
	}
	
}
