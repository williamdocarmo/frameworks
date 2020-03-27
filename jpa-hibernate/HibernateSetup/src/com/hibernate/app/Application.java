package com.hibernate.app;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.infra.HibernateUtils;
import com.hibernate.model.UserDataVO;
import com.hibernate.utils.UserFactory;

public class Application {

	static Session session;

	public static void main(String[] args) {
		session = com.hibernate.infra.HibernateUtils.getSession();
		Transaction txn = session.beginTransaction();
		persist();
		//retrieve();
		//update();
		//delete();
		txn.commit();
		HibernateUtils.closeResources(session);
		System.exit(0);

	}

	private static void persist() {
		UserDataVO user = UserFactory.getUser();
		session.persist(user);
	}

	private static void retrieve() {
		UserDataVO user = (UserDataVO) session.get(UserDataVO.class, "user2911");
		System.out.println(user);
	}

	private static void update() {
		UserDataVO user = (UserDataVO) session.get(UserDataVO.class, "user2911");
		if (null != user)
			user.setFirstname("updated first name");
	}

	private static void delete() {
		UserDataVO user = (UserDataVO) session.get(UserDataVO.class, "user2911");
		session.delete(user);
	}

}
