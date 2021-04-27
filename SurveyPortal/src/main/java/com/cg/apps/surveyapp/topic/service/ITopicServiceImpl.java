package com.cg.apps.surveyapp.topic.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.apps.surveyapp.exceptions.InvalidSurveyorException;
import com.cg.apps.surveyapp.exceptions.InvalidTopicNameException;
import com.cg.apps.surveyapp.exceptions.SurveyExceptionMessages;
import com.cg.apps.surveyapp.exceptions.TopicNotFoundException;
import com.cg.apps.surveyapp.topic.entities.Topic;
import com.cg.apps.surveyapp.topic.repository.ITopicRepository;

@Service("topicService")
@Transactional
public class ITopicServiceImpl implements ITopicService {

	@Autowired
	private ITopicRepository topicRepo;

	private Logger logger = LoggerFactory.getLogger(ITopicServiceImpl.class);

	@Override
	public Topic createTopic(Topic topic) throws InvalidSurveyorException {

		if (topic == null) {
			logger.error(SurveyExceptionMessages.INVALID_TOPIC_NAME);
			throw new InvalidTopicNameException(SurveyExceptionMessages.INVALID_TOPIC_NAME);
		}
		return topicRepo.save(topic);
	}

	@Override
	public Topic findById(Long id) throws TopicNotFoundException {
		Optional<Topic> topic = topicRepo.findById(id);
		if (!topic.isPresent()) {
			logger.error(SurveyExceptionMessages.TOPIC_NOT_FOUND);
			throw new TopicNotFoundException(SurveyExceptionMessages.TOPIC_NOT_FOUND);

		}
		logger.info(topic.get().toString());
		return topic.get();
	}

	@Override
	public List<Topic> findByName(String topicName) throws TopicNotFoundException {
		List<Topic> topics = null;
		topics = topicRepo.findByTopicName(topicName);
		if (topics == null) {
			logger.error(SurveyExceptionMessages.TOPIC_NOT_FOUND);
			throw new TopicNotFoundException(SurveyExceptionMessages.TOPIC_NOT_FOUND);

		}
		logger.info(topics.toString());
		return topics;
	}

	@Override
	public Topic updateTopic(Long topicId, String topicName, String description) throws TopicNotFoundException {
		Optional<Topic> topic = topicRepo.findById(topicId);
		if (!topic.isPresent()) {
			logger.error(SurveyExceptionMessages.TOPIC_NOT_FOUND);
			throw new TopicNotFoundException(SurveyExceptionMessages.TOPIC_NOT_FOUND);
		}
		topic.get().setTopicName(topicName);
		topic.get().setTopicDescription(description);
		topicRepo.save(topic.get());
		logger.info(topic.get().toString());
		return topic.get();
	}

	@Override
	public int countSurveysDoneForTopic(Topic topic) {
		Optional<Topic> top = topicRepo.findById(topic.getId());
		if (!top.isPresent()) {
			logger.error(SurveyExceptionMessages.TOPIC_NOT_FOUND);
			throw new TopicNotFoundException(SurveyExceptionMessages.TOPIC_NOT_FOUND);
		}
		int count = 0;
		if (top.get().getSurveys() != null) {
			count = top.get().getSurveys().size();
		}
		logger.info(Integer.toString(count));
		return count;
	}

}
