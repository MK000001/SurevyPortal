package com.cg.apps.surveyapp.topic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.apps.surveyapp.exceptions.TopicNotFoundException;
import com.cg.apps.surveyapp.topic.entities.Topic;

@Repository("topicRepo")
public interface ITopicRepository extends JpaRepository<Topic, Long> {

	List<Topic> findByTopicName(String name) throws TopicNotFoundException;

}
