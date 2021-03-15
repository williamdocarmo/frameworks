package com.app.ws.impl;

import com.app.framework.ContextHolder;
import com.app.framework.JdbcDaoImpl;
import com.app.ws.SubscriberService;

import jakarta.jws.WebService;

@WebService(endpointInterface = "com.app.ws.SubscriberService")
public class SubscriberServiceImpl implements SubscriberService {
	
	private JdbcDaoImpl getDAO() {
		return ContextHolder.getContextHolder().getDAO();
	}

	@Override
	public String createSubscriber(String id, String name) {
		getDAO().createSubscriber(id, name);
		return null;
	}

}
