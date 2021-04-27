package com.cg.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.apps.surveyapp.dto.SurveyDetails;
import com.cg.apps.surveyapp.dto.TopicDetails;
import com.cg.apps.surveyapp.survey.entities.Survey;
import com.cg.apps.surveyapp.topic.entities.Topic;

@Component
public class TopicUtil {
	@Autowired
	SurveyUtil surveyUtil;

	@Autowired
	private SurveyorUtil surveyorUtil;

	public TopicDetails toDetails(Topic topic) {
		List<SurveyDetails> surveyDetails = new ArrayList<>();
		if (topic.getSurveys() != null) {
			for (Survey survey : topic.getSurveys()) {
				surveyDetails.add(new SurveyDetails(surveyUtil.toDetails(survey)));
			}
		}
		return new TopicDetails(topic.getId(), topic.getTopicName(), topic.getTopicDescription(), surveyDetails,
				surveyorUtil.toDetails(topic.getCreatedBy()));
	}

	public List<TopicDetails> toDetails(List<Topic> topics) {
		List<TopicDetails> topicList = new ArrayList<>();
		for (Topic topic : topics) {
			topicList.add(toDetails(topic));
		}
		return topicList;
	}

}
