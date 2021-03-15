package com.app.framework;

import org.springframework.context.support.AbstractApplicationContext;

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

}
