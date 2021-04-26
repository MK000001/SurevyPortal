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

import com.cg.apps.surveyapp.topic.entities.Topic;
import com.cg.apps.surveyapp.topic.service.ITopicService;

@RestController
@RequestMapping("/topic")
@Validated
public class TopicController {

	@Autowired
	private ITopicService topicService;

	@RequestMapping("/hello")
	public String greet() {

		return "Hello!! from topic controller";
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/add")
	public Topic addTopic(@RequestBody @Valid Topic topic) {

		return topicService.createTopic(topic.getCreatedBy(), topic.getTopicName());
	}

	@GetMapping("/by/id/{id}")
	public Topic fetchtopic(@PathVariable("id") Long id) {

		return topicService.findById(id);
	}

	@GetMapping("/by/name/{name}")
	public List<Topic> findByName(@PathVariable("name") String name) {
		return topicService.findByName(name);
	}

	@PostMapping("/update")
	public Topic updateTopic(@RequestBody @Valid Topic topic) {

		return topicService.updateTopic(topic.getId(), topic.getTopicName(), topic.getTopicDescription());
	}

}
