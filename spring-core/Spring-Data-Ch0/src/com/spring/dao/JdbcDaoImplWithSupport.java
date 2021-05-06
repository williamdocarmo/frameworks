package com.spring.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

@Component
public class JdbcDaoImplWithSupport extends JdbcDaoSupport {
	
	public int getCircleCount() {
		String sql = "select count(*) from circle";
		int count = this.getJdbcTemplate().queryForObject(sql, int.class);
		return count;
	}
	
}
