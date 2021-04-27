package com.cg.testing;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.apps.surveyapp.topic.entities.Topic;
import com.cg.apps.surveyapp.topic.service.ITopicService;
import com.cg.apps.surveyapp.topic.service.ITopicServiceImpl;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import(ITopicServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ITopicServiceImplTest {
	@Autowired
	private ITopicService topicService;

	@Test
	void createTopic() {
		Topic topic = new Topic("Topic_A", "Topic_A_Description");
		Topic savedTopic = topicService.createTopic(topic);
		assertEquals(topic.getTopicDescription(), savedTopic.getTopicDescription());
		assertEquals(topic.getTopicName(), savedTopic.getTopicName());
	}

	@Test
	void updateTopic() {

		Topic savedTopic = topicService.createTopic(new Topic("Topic_A", "Topic_A_Description"));
		savedTopic.setTopicDescription("Description for Topic_A");
		Topic updateTopic = topicService.updateTopic(savedTopic.getId(), savedTopic.getTopicName(),
				savedTopic.getTopicDescription());
		assertEquals(savedTopic, updateTopic);

	}

	@Test
	void findById() {
		Topic savedTopic = topicService.createTopic(new Topic("Topic_A", "Topic_A_Description"));
		Topic foundTopic = topicService.findById(savedTopic.getId());
		assertEquals(savedTopic, foundTopic);
	}

	@Test
	void findByName() {
		Topic savedTopic = topicService.createTopic(new Topic("Topic_A", "Topic_A_Description"));
		List<Topic> foundTopic = topicService.findByName(savedTopic.getTopicName());
		for (Topic topic : foundTopic) {
			assertEquals(savedTopic, topic);
		}

	}
}
