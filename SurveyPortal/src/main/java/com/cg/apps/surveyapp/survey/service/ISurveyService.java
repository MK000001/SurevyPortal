package com.cg.apps.surveyapp.survey.service;

import java.util.List;

import com.cg.apps.surveyapp.participant.entities.Participant;
import com.cg.apps.surveyapp.survey.entities.Survey;

public interface ISurveyService {
	Survey updateSurveyDescription(Long surveyId, String description);

	Survey add(Survey survey);

	Survey findById(Long id);

	void removeSurveyById(Long id);

	/**
	 * finds all participants who participated in survey
	 *
	 * @param survey
	 * @return list of participants
	 */
	List<Participant> findParticipants(Survey survey);

	/**
	 * calculates count of feedbacks posted in the survey
	 *
	 * @param survey
	 * @return count of feedbacks posted in survey
	 */
	int countFeedbacksInSurvey(Survey survey);

	/**
	 * close survey
	 * 
	 * @param survey
	 */
	void close(Survey survey);

}
