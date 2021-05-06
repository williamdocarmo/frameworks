package com.app.util;

import java.io.Serializable;
import java.util.Iterator;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import com.app.model.Subscriber;

public class MyInterceptor extends EmptyInterceptor {

	private static final long serialVersionUID = 1L;

	public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
	}

	public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {
		System.out.println("onFlushDirty");
		return true;
	}

	public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		((Subscriber) entity).setMsisdn("MSISDN999");
		System.out.println("----onLoad----");
		System.out.println("Object: "+entity);
		System.out.println("ID: "+id);
		System.out.println("State: ");
		for (Object obj : state) {
			System.out.println(obj);
		}
		System.out.println("PropertyNames: ");
		for (Object obj : propertyNames) {
			System.out.println(obj);
		}
		System.out.println("Types: ");
		for (Object obj : types) {
			System.out.println(obj);
		}
		System.out.println("----onLoad----");
		return true;
	}

	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		System.out.println("----onSave----");
		((Subscriber) entity).setMsisdn("MSISDN999");
		System.out.println("Object: "+entity);
		System.out.println("ID: "+id);
		System.out.println("State: ");
		for (Object obj : state) {
			System.out.println(obj);
		}
		System.out.println("PropertyNames: ");
		for (Object obj : propertyNames) {
			System.out.println(obj);
		}
		System.out.println("Types: ");
		for (Object obj : types) {
			System.out.println(obj);
		}
		System.out.println("----onSave----");
		return true;
	}

	public void preFlush(Iterator iterator) {
		System.out.println("preFlush");
	}

	public void postFlush(Iterator iterator) {
		System.out.println("postFlush");
	}
}