 package com.app;

import org.hibernate.Session;

import com.app.model.Subscriber;
import com.app.util.HibernateUtil;
import com.app.util.Utils;

public class ORMApplication {
	
	private Session session;
	
	public ORMApplication() {
		this.session = HibernateUtil.getSession();
	}
	
	public void insert() {
		Subscriber user = new Subscriber(2, "msisdn2", Utils.firstJan(), "Address2", Utils.largeString(), true);
		session.beginTransaction();
		session.persist(user);
		session.getTransaction().commit();
	}
	
	public void select() {
		Subscriber subscriber = session.get(Subscriber.class, 1);
		System.out.println("Subscriber Retrieved: "+subscriber);
	}
	
	public void update() {
		session.beginTransaction();
		Subscriber subscriber = session.get(Subscriber.class, 1);
		subscriber.setFirstBilling(Utils.firstApril());
		session.update(subscriber);
		session.getTransaction().commit();
	}
	
	public void delete() {
		session.beginTransaction();
		Subscriber subscriber = session.get(Subscriber.class, 1);
		session.delete(subscriber);
		session.getTransaction().commit();
	}

}
