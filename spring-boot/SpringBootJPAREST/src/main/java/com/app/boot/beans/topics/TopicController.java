package com.app.boot.beans.topics;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PropertySource(value = { "file:application.properties" })
public class TopicController {
	
	private static final Logger logger = LoggerFactory.getLogger(TopicController.class);
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private TopicService topicService;
	
	@Value("${custom.param.1}")
	private String customParam1;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		logger.info("Environment Property: "+environment.getProperty("custom.param.1"));
		logger.info("Injected Property: "+customParam1);
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{topicId}")
	@ResponseBody
	public Topic getTopicById(@PathVariable(name = "topicId") String id) {
		return topicService.getTopicById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/topics")
	public void createTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	@RequestMapping(path = "/topics/{topicId}", method = RequestMethod.PUT)
	public void updateTopic(@PathVariable(name = "topicId") String id, @RequestBody Topic topic) {
		topicService.updateTopic(id, topic);
	}
	
	@RequestMapping(path = "/topics/{topicId}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(name = "topicId") String id) {
		topicService.deleteTopic(id);
	}

}
