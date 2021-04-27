package com.cg.apps.surveyapp.feedback.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.cg.apps.surveyapp.feedback.entities.Feedback;
import com.cg.apps.surveyapp.question.entities.Option;
import com.cg.apps.surveyapp.survey.entities.Survey;

public interface IFeedbackService {

	Feedback createFeedback(Feedback feedback);

	Feedback updateFeedback(Long feedbackId, Map<Long, Option> answers);

	List<Feedback> findFeedbacksForSurveyAfterDateTime(Survey survey, LocalDate dateTime);

	void removeByFeedbackById(Long feedbackId);

	List<Feedback> findAll();

}
