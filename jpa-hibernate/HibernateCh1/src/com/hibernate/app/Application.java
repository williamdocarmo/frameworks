package com.hibernate.app;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.entity.UserDataVO;
import com.hibernate.infra.HibernateUtils;
import com.hibernate.utils.UserFactory;

public class Application {

	static Session session;

	public static void main(String[] args) {
		session = HibernateUtils.getSession();
		Transaction txn = session.beginTransaction();
		crudOperations();
		txn.commit();
		HibernateUtils.closeResources(session);
		System.exit(0);

	}

	private static void crudOperations() {
		persist();
		// retrieve();
		// update();
		// delete();
	}

	private static void persist() {
		// Persist, Save, SaveOrUpdate
		UserDataVO user = UserFactory.getUser();
		session.persist(UserFactory.getUser()); // Inserts directly
		session.save(UserFactory.getUser());// Inserts directly
		session.saveOrUpdate(UserFactory.getUser()); // Reads first, then inserts
	}

	private static void retrieve() {
		// Get, Find, Load
		UserDataVO user;
		user = (UserDataVO) session.get(UserDataVO.class, "user1937"); // Selects
		System.out.println(user);
		user = (UserDataVO) session.find(UserDataVO.class, "user1937"); // Selects
		System.out.println(user);
		user = (UserDataVO) session.load(UserDataVO.class, "user1937"); // Lazy Loading
		// session.close();
		System.out.println(user); // Throws exception if session is closed
	}

	private static void update() {
		// Update, Save, SaveOrUpdate
		UserDataVO user = session.get(UserDataVO.class, "user1937");
		if (null != user)
			user.setUsername("updated_user1937_3"); // No need to call API, as the object is in persistent state
		// Still you can call the below methods
		// session.update(user);
		// session.save(user);
		// session.saveOrUpdate(user);
	}

	private static void delete() {
		// Remove, Delete
		UserDataVO user;
		user = (UserDataVO) session.get(UserDataVO.class, "user9764");
		session.delete(user);
		user = (UserDataVO) session.get(UserDataVO.class, "user5356");
		session.remove(user);
	}

}
