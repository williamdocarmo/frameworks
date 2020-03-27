package com.hibernate.infra;

import java.io.Serializable;
import java.util.Iterator;

import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.EntityMode;
import org.hibernate.Transaction;
import org.hibernate.type.Type;

import com.hibernate.model.UserDataVO;
@SuppressWarnings("rawtypes")
public class UserInterceptor extends EmptyInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public void afterTransactionBegin(Transaction tx) {
		super.afterTransactionBegin(tx);
	}

	@Override
	public void afterTransactionCompletion(Transaction tx) {
		/*System.out.println("After Transaction Complete: ");
		System.out.println(tx.getTimeout()+" "+tx.getLocalStatus());*/
		super.afterTransactionCompletion(tx);
	}

	@Override
	public void beforeTransactionCompletion(Transaction tx) {
		super.beforeTransactionCompletion(tx);
	}

	@Override
	public int[] findDirty(Object entity, Serializable id,
			Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {
		return super.findDirty(entity, id, currentState, previousState, propertyNames,
				types);
	}

	@Override
	public Object getEntity(String entityName, Serializable id) {
		System.out.println("------------------------------------------");
		System.out.println("Get Entity");
		System.out.println(entityName+" "+id);
		System.out.println("------------------------------------------");
		return super.getEntity(entityName, id);
	}

	@Override
	public String getEntityName(Object object) {
		//System.out.println("Entity Name: "+object);
		return super.getEntityName(object);
	}

	@Override
	public Object instantiate(String entityName, EntityMode entityMode,
			Serializable id) {
		return super.instantiate(entityName, entityMode, id);
	}

	@Override
	public Boolean isTransient(Object entity) {
		return super.isTransient(entity);
	}

	@Override
	public void onCollectionRecreate(Object collection, Serializable key)
			throws CallbackException {
		super.onCollectionRecreate(collection, key);
	}

	@Override
	public void onCollectionRemove(Object collection, Serializable key)
			throws CallbackException {
		super.onCollectionRemove(collection, key);
	}

	@Override
	public void onCollectionUpdate(Object collection, Serializable key)
			throws CallbackException {
		super.onCollectionUpdate(collection, key);
	}

	@Override
	public void onDelete(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {
		super.onDelete(entity, id, state, propertyNames, types);
	}

	@Override
	public boolean onFlushDirty(Object entity, Serializable id,
			Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {
		return super.onFlushDirty(entity, id, currentState, previousState,
				propertyNames, types);
	}

	@Override
	public boolean onLoad(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {
		System.out.println("Entity: "+entity);
		/*System.out.println("Onload Method Called...");
		System.out.println("Entity: "+entity);
		System.out.println("ID: "+id);
		System.out.println("State: ");
		for(Object obj : state)System.out.println(obj);
		System.out.println("PropertyNames: ");
		for(Object obj : propertyNames)System.out.println(obj);
		System.out.println("Types: ");
		for(Object obj : types)System.out.println(obj);*/
		return super.onLoad(entity, id, state, propertyNames, types);
	}

	@Override
	public String onPrepareStatement(String sql) {
		return super.onPrepareStatement(sql);
	}

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {
		if(entity instanceof UserDataVO){
			UserDataVO user = (UserDataVO) entity;
			System.out.println("User: "+user);
			if(user.getUsername().equalsIgnoreCase("Santanu")){
				user.setUsername("Santanu B");
			}
			
		}
		return super.onSave(entity, id, state, propertyNames, types);
	}

	@Override
	public void postFlush(Iterator entities) {
		super.postFlush(entities);
	}

	@Override
	public void preFlush(Iterator entities) {
		super.preFlush(entities);
	}

	
	
}