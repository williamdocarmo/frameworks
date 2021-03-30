package com.app.boot.beans.courses;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.boot.beans.topics.Topic;

@RestController
@PropertySource(value = { "file:application.properties" })
public class CourseController {
	
	private static final Logger logger = LoggerFactory.getLogger(CourseController.class);
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable("topicId") String id) {
		return courseService.getAllCourses(id);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}")
	@ResponseBody
	public Course getCourseById(@PathVariable(name = "topicId") String topicId, @PathVariable(name = "courseId") String courseId) {
		return courseService.getCourseById(courseId);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/topics/{topicId}/courses")
	public void createCourse(@RequestBody Course course, @PathVariable("topicId") String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
	}
	
	@RequestMapping(path = "/topics/{topicId}/courses/{courseId}", method = RequestMethod.PUT)
	public void updateCourse(@RequestBody Course course, @PathVariable("topicId") String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(path = "/topics/{topicId}/courses/{courseId}", method = RequestMethod.DELETE)
	public void deleteCourse(@PathVariable(name = "courseId") String id) {
		courseService.deleteCourse(id);
	}

}
