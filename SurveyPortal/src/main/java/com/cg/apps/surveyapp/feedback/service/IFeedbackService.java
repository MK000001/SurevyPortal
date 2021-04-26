package com.cg.apps.surveyapp.feedback.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.cg.apps.surveyapp.feedback.entities.Feedback;
import com.cg.apps.surveyapp.participant.entities.Participant;
import com.cg.apps.surveyapp.question.entities.Option;
import com.cg.apps.surveyapp.survey.entities.Survey;

public interface IFeedbackService {

	Feedback createFeedback(Survey survey, Participant participant, Map<Long, Option> answers);

	Feedback updateFeedback(Long feedbackId, Map<Long, Option> answers);

	List<Feedback> findFeedbacksForSurveyAfterDateTime(Survey survey, LocalDateTime dateTime);

	void removeByFeedbackById(Long feedbackId);

	List<Feedback> findAll();

}
