package com.app.dao;
import java.util.List;

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
	
	public List<String> getAllProductCategories() {
		String query = "select category from productcategories";
		return jdbcTemplate.queryForList(query, String.class);
	}
	
	public List<String> getAllBooks() {
		String query = "select category from books";
		return jdbcTemplate.queryForList(query, String.class);
	}
	
	public List<String> getAllMovies() {
		String query = "select category from movies";
		return jdbcTemplate.queryForList(query, String.class);
	}
	
	public List<String> getAllMusics() {
		String query = "select category from music";
		return jdbcTemplate.queryForList(query, String.class);
	}
	
	public void addBooks(String bookname) {
		String query = "insert into books values (?)";
		jdbcTemplate.update(query, bookname);
	}
	
	public void addMovies(String movie) {
		String query = "insert into movies values (?)";
		jdbcTemplate.update(query, movie);
	}
	
	public void addMusic(String music) {
		String query = "insert into music values (?)";
		jdbcTemplate.update(query, music);
	}
	
	

}
