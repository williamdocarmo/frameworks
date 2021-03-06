package com.app.util;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.query.NativeQuery;

public class CustomIDGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor arg0, Object arg1) throws HibernateException {
		String idSuffixSql = "SELECT ID FROM USER_SEQUENCE";
		
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		NativeQuery query = session.createNativeQuery(idSuffixSql);
		String result = (String) query.uniqueResult();
		String updateSeqSql = "UPDATE USER_SEQUENCE SET ID=LAST_INSERT_ID(ID+1)";
		query = session.createNativeQuery(updateSeqSql);
		query.executeUpdate();
		session.getTransaction().commit();
		return "User"+result;
	}

}
