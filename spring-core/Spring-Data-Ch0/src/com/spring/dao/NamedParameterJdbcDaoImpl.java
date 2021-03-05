package com.spring.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.spring.aop.model.Circle;

@Component
public class NamedParameterJdbcDaoImpl {
	
	private NamedParameterJdbcTemplate npJdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.npJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	/* Insert Using Named Parameter Template*/
	public void insertCircleNP (Circle circle) {
		String sql = "insert into circle values (:id, :name)";
		SqlParameterSource namedParameters = new MapSqlParameterSource("id", circle.getId())
				.addValue("name", circle.getName());
		npJdbcTemplate.update(sql, namedParameters);
	}

}
