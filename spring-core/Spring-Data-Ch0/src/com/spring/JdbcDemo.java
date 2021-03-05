package com.spring;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.aop.model.Circle;
import com.spring.dao.JdbcDaoImpl;
import com.spring.dao.JdbcDaoImplWithSupport;
import com.spring.dao.NamedParameterJdbcDaoImpl;

public class JdbcDemo {

	public static void main(String[] args) throws InterruptedException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		JdbcDaoImpl dao = context.getBean("jdbcDaoImpl", JdbcDaoImpl.class);
		NamedParameterJdbcDaoImpl npdao = context.getBean("namedParameterJdbcDaoImpl", NamedParameterJdbcDaoImpl.class);
		JdbcDaoImplWithSupport daoWithSupport = context.getBean("jdbcDaoImplWithSupport", JdbcDaoImplWithSupport.class);
		
		String circleName = dao.getCircleName(1);
		System.out.println("getCircleName:: "+circleName);
		
		dao.insertCircle(new Circle(4, "Circle 4"));
		
		npdao.insertCircleNP(new Circle(6, "Circle 6"));
		
		Integer count = dao.getCircleCount();
		System.out.println("getCircleCount:: "+count);
		
		dao.updateCircle(3, "Circle 3_1");
		
		dao.deleteCircle(4);
		
		Circle circle = dao.getCircle(3);
		System.out.println("Circle Returned: "+circle);
		
		circle = dao.getCircleRS(3);
		System.out.println("Circle Returned: "+circle);
		
		List<Circle> circles = dao.getAllCircles();
		System.out.println("All Circles Returned: "+circles);
		
		dao.createTrianglTable();
		
		System.out.println("Circle Count: "+daoWithSupport.getCircleCount());
		
	}

}
