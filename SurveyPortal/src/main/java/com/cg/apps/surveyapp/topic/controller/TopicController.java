package com.cg.apps.surveyapp.topic.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.apps.surveyapp.dto.TopicDetails;
import com.cg.apps.surveyapp.pojos.TopicRequest;
import com.cg.apps.surveyapp.topic.entities.Topic;
import com.cg.apps.surveyapp.topic.service.ITopicService;
import com.cg.util.TopicUtil;

@RestController
@RequestMapping("/topic")
@Validated
public class TopicController {

	@Autowired
	private ITopicService topicService;

	@Autowired
	private TopicUtil topicUtil;

	@RequestMapping("/hello")
	public String greet() {

		return "Hello!! from topic controller";
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/add")
	public TopicDetails addTopic(@RequestBody @Valid TopicRequest topicDetails) {
		Topic topic = new Topic(topicDetails.getTopicName(), topicDetails.getTopicDescription(),
				topicDetails.getCreatedBy());
		Topic top = topicService.createTopic(topic);
		return topicUtil.toDetails(top);
	}

	@GetMapping("/by/id/{id}")
	public TopicDetails fetchtopic(@PathVariable("id") Long id) {

		Topic topic = topicService.findById(id);
		return topicUtil.toDetails(topic);
	}

	@GetMapping("/by/name/{name}")
	public List<TopicDetails> findByName(@PathVariable("name") String name) {
		List<Topic> topics = topicService.findByName(name);
		return topicUtil.toDetails(topics);
	}

	@PostMapping("/update")
	public TopicDetails updateTopic(@RequestBody @Valid TopicRequest topic) {

		Topic top = topicService.updateTopic(topic.getId(), topic.getTopicName(), topic.getTopicDescription());
		return topicUtil.toDetails(top);
	}

}
