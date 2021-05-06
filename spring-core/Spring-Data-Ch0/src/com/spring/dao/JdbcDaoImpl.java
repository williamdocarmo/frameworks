package com.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.aop.model.Circle;

@Component
public class JdbcDaoImpl {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/* Select */
	public String getCircleName(int id) {
		String sql = "Select name from Circle where id = ?";
		String name = jdbcTemplate.queryForObject(sql, String.class, new Object[] {id});
		return name;
	}
	
	/* Select */
	public int getCircleCount() {
		String sql = "select count(*) from circle";
		int count = jdbcTemplate.queryForObject(sql, int.class);
		return count;
	}
	
	/* Insert */
	public void insertCircle (Circle circle) {
		String sql = "insert into circle values (?, ?)";
		jdbcTemplate.update(sql, circle.getId(), circle.getName());
	}
	
	/* Update */
	public void updateCircle (int id, String name) {
		String sql = "update circle set name=? where id=?";
		jdbcTemplate.update(sql, name, id);
	}
	
	/* Delete */
	public void deleteCircle (int id) {
		String sql = "delete from circle where id=?";
		jdbcTemplate.update(sql, id);
	}
	
	public void createTrianglTable() {
		String sql = "create table triangle (id integer, name varchar(50))";
		try{
			jdbcTemplate.execute(sql);
		} catch (Exception e) {
			System.out.println("Exception Caught: "+e.getMessage());
		}
	}
	
	/* Row Mapper - Single Record */
	public Circle getCircle (int id) {
		String sql = "select * from circle where id = ?";
		Circle circle = jdbcTemplate.queryForObject(sql, new RowMapper<Circle>() {
			@Override
			public Circle mapRow(ResultSet rs, int rowNum) throws SQLException {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Circle circle = new Circle(id, name);
				return circle;
			}
		}, new Object[] {id});
		return circle;
	}
	
	/* Result Set Extractor - Single Record */
	public Circle getCircleRS (int id) {
		String sql = "select * from circle where id = ?";
		Circle circle = jdbcTemplate.query(sql, new ResultSetExtractor<Circle>() {

			@Override
			public Circle extractData(ResultSet rs) throws SQLException, DataAccessException {
				Circle circle = null;
				while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					circle = new Circle(id, name);
				}
				
				return circle;
			}
			
		}, id);
		return circle;
	}

	/* Row Mapper - Multiple Record */
	public List<Circle> getAllCircles() {
		String sql = "select * from circle";
		return jdbcTemplate.query(sql, new CircleMapper());
	}
	
	private static final class CircleMapper implements RowMapper<Circle>{
		@Override
		public Circle mapRow(ResultSet rs, int rowNum) throws SQLException {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			Circle circle = new Circle(id, name);
			return circle;
		}
	}
	
}
