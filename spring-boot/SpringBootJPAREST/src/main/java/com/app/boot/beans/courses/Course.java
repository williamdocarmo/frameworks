package com.app.boot.beans.courses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.app.boot.beans.topics.Topic;

@Entity
@Table(name = "COURSE_DETAILS")
public class Course {

	@Id
	@Column(name = "COURSE_ID")
	private String courseId;

	@Column(name = "COURSE_NAME")
	private String courseName;

	@Column(name = "COURSE_DESCRIPTION")
	private String courseDescription;

	@ManyToOne
	@JoinColumn(name = "TOPIC_ID")
	private Topic topic;

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(String courseId, String courseName, String courseDescription, String topicId) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.topic = new Topic("", "", "");
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseDescription="
				+ courseDescription + ", topic=" + topic + "]";
	}

}
