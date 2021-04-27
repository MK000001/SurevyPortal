package com.cg.apps.surveyapp.topic.service;

import java.util.List;

import com.cg.apps.surveyapp.exceptions.InvalidSurveyorException;
import com.cg.apps.surveyapp.exceptions.TopicNotFoundException;
import com.cg.apps.surveyapp.topic.entities.Topic;

public interface ITopicService {

	Topic createTopic(Topic topic) throws InvalidSurveyorException;

	Topic findById(Long id) throws TopicNotFoundException;

	List<Topic> findByName(String topicName) throws TopicNotFoundException;

	Topic updateTopic(Long topicId, String topicName, String description) throws TopicNotFoundException;

	int countSurveysDoneForTopic(Topic topic);
}
