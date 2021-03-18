package com.app.framework;

import org.springframework.context.support.AbstractApplicationContext;

import com.app.dao.JdbcDaoImpl;
import com.app.dao.SubscriberDAO;

public class ContextHolder {

	private ContextHolder() {
	}

	private static ContextHolder contextHolder;

	public static ContextHolder getContextHolder() {
		if (null == contextHolder) {
			contextHolder = new ContextHolder();
		}
		return contextHolder;
	}

	private AbstractApplicationContext context;

	public void setContext(AbstractApplicationContext context) {
		this.context = context;
	}

	public JdbcDaoImpl getDAO() {
		return this.context.getBean("jdbcDaoImpl", JdbcDaoImpl.class);
	}
	
	public SubscriberDAO subscriberDao() {
		return this.context.getBean("subscriberDAO", SubscriberDAO.class);
	}

}
