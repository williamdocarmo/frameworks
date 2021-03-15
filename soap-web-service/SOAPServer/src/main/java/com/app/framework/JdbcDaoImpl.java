package com.app.framework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcDaoImpl {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void createSubscriber(String id, String name) {
		String query = "insert into Subscriber values (?, ?)";
		jdbcTemplate.update(query, id, name);
	}

}
