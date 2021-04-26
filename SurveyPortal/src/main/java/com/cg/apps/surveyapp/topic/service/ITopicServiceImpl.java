package com.cg.apps.surveyapp.topic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.apps.surveyapp.exceptions.InvalidSurveyorException;
import com.cg.apps.surveyapp.exceptions.SurveyExceptionMessages;
import com.cg.apps.surveyapp.exceptions.TopicNotFoundException;
import com.cg.apps.surveyapp.surveyor.entities.Surveyor;
import com.cg.apps.surveyapp.topic.entities.Topic;
import com.cg.apps.surveyapp.topic.repository.ITopicRepository;

@Service("topicService")
@Transactional
public class ITopicServiceImpl implements ITopicService {

	@Autowired
	private ITopicRepository topicRepo;

	@Override
	public Topic createTopic(Surveyor surveyor, String topicName) throws InvalidSurveyorException {
		Topic topic = new Topic(surveyor, topicName);
		Topic newTopic = topicRepo.save(topic);
		if (newTopic == null) {
			throw new InvalidSurveyorException("No such surveyor found");
		}
		return newTopic;
	}

	@Override
	public Topic findById(Long id) throws TopicNotFoundException {
		Optional<Topic> topic = topicRepo.findById(id);
		if (!topic.isPresent()) {
			throw new TopicNotFoundException(SurveyExceptionMessages.TOPIC_NOT_FOUND);
		}
		return topic.get();
	}

	@Override
	public List<Topic> findByName(String topicName) throws TopicNotFoundException {
		List<Topic> topics = null;
		topics = topicRepo.findByTopicName(topicName);
		if (topics == null) {
			throw new TopicNotFoundException(SurveyExceptionMessages.TOPIC_NOT_FOUND);
		}
		return topics;
	}

	@Override
	public Topic updateTopic(Long topicId, String topicName, String description) throws TopicNotFoundException {
		Optional<Topic> topic = topicRepo.findById(topicId);
		if (!topic.isPresent()) {
			throw new TopicNotFoundException(SurveyExceptionMessages.TOPIC_NOT_FOUND);
		}
		topic.get().setTopicName(topicName);
		topic.get().setTopicDescription(description);
		topicRepo.save(topic.get());
		return topic.get();
	}

	@Override
	public int countSurveysDoneForTopic(Topic topic) {
		Optional<Topic> top = topicRepo.findById(topic.getId());
		if (!top.isPresent()) {
			throw new TopicNotFoundException(SurveyExceptionMessages.TOPIC_NOT_FOUND);
		}
		int count = 0;
		if (top.get().getSurveys() != null) {
			count = top.get().getSurveys().size();
		}
		return count;
	}

}
