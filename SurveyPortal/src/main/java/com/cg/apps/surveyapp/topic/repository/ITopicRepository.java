package com.cg.apps.surveyapp.topic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.apps.surveyapp.exceptions.TopicNotFoundException;
import com.cg.apps.surveyapp.topic.entities.Topic;

@Repository("topicRepo")
public interface ITopicRepository extends JpaRepository<Topic, Long> {

//	Topic add(Topic topic);
//
//	Topic findById(Long id) throws TopicNotFoundException;
//
	List<Topic> findByTopicName(String name) throws TopicNotFoundException;
//
//	Topic update(Topic topic) throws TopicNotFoundException;
//
//	Topic removeById(Long id) throws TopicNotFoundException;
//
//	int countSurveysDoneForTopic(Topic topic);

}
