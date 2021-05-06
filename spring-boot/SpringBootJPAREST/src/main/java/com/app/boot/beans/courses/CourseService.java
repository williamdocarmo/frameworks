package com.app.boot.beans.courses;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(String topicId) {
		Iterable<Course> coursesFromRepo = courseRepository.findByTopicTopicId(topicId);
		List<Course> courses = new ArrayList<Course>();
		for (Course t : coursesFromRepo) {
			courses.add(t);
		}
		return courses;
	}

	public Course getCourseById(String id) {
		return courseRepository.findById(id).get();
	}
	
	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	public void updateCourse(Course course) {
		courseRepository.save(course);
	}
	
	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}

}
