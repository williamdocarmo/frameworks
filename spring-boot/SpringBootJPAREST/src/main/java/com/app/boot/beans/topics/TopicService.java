package com.app.boot.beans.topics;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopics() {
		Iterable<Topic> topicsFromRepo = topicRepository.findAll();
		List<Topic> topics = new ArrayList<Topic>();
		for (Topic t : topicsFromRepo) {
			topics.add(t);
		}
		return topics;
	}

	public Topic getTopicById(String id) {
		return topicRepository.findById(id).get();
	}
	
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
	}
	
	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}

}
