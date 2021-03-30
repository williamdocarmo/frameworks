package com.app.boot.beans.topics;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "COURSE_TOPICS")
public class Topic {
	
	@Id
	@Column(name = "TOPIC_ID")
	private String topicId;
	
	@Column(name = "TOPIC_NAME")
	private String topicName;
	
	@Column(name = "TOPIC_DESCRIPTION")
	private String topicDescription;

	public String getTopicId() {
		return topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getTopicDescription() {
		return topicDescription;
	}

	public void setTopicDescription(String topicDescription) {
		this.topicDescription = topicDescription;
	}

	public Topic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Topic(String topicId, String topicName, String topicDescription) {
		super();
		this.topicId = topicId;
		this.topicName = topicName;
		this.topicDescription = topicDescription;
	}

	@Override
	public String toString() {
		return "Topic [topicId=" + topicId + ", topicName=" + topicName + ", topicDescription=" + topicDescription
				+ "]";
	}
	
}
