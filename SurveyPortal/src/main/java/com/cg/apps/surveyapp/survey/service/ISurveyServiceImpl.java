package com.cg.apps.surveyapp.survey.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.apps.surveyapp.exceptions.InvalidSurveyException;
import com.cg.apps.surveyapp.exceptions.SurveyExceptionMessages;
import com.cg.apps.surveyapp.exceptions.SurveyNotFoundException;
import com.cg.apps.surveyapp.feedback.entities.Feedback;
import com.cg.apps.surveyapp.participant.entities.Participant;
import com.cg.apps.surveyapp.survey.entities.Survey;
import com.cg.apps.surveyapp.survey.repository.ISurveyRepository;

@Service("surveyService")
@Transactional
public class ISurveyServiceImpl implements ISurveyService {

	@Autowired
	ISurveyRepository surveyRepo;

	@Override
	public Survey updateSurveyDescription(Long surveyId, String description) {
		Optional<Survey> survey = surveyRepo.findById(surveyId);
		if (!survey.isPresent()) {
			throw new SurveyNotFoundException(SurveyExceptionMessages.SURVEY_NOT_FOUND);
		}
		survey.get().setDescription(description);
		return surveyRepo.save(survey.get());
	}

	@Override
	public Survey add(Survey survey) {
		if (survey == null) {
			throw new InvalidSurveyException(SurveyExceptionMessages.INVALID_SURVEY);
		}

		return surveyRepo.save(survey);
	}

	@Override
	public Survey findById(Long id) {
		Optional<Survey> survey = surveyRepo.findById(id);
		if (!survey.isPresent()) {
			throw new SurveyNotFoundException(SurveyExceptionMessages.SURVEY_NOT_FOUND);
		}
		return survey.get();
	}

	@Override
	public void removeSurveyById(Long id) {
		Optional<Survey> survey = surveyRepo.findById(id);
		if (!survey.isPresent()) {
			throw new SurveyNotFoundException(SurveyExceptionMessages.SURVEY_NOT_FOUND);
		}
		surveyRepo.delete(survey.get());
	}

	@Override
	public List<Participant> findParticipants(Survey survey) {
		Optional<Survey> sur = surveyRepo.findById(survey.getId());
		if (!sur.isPresent()) {
			throw new SurveyNotFoundException(SurveyExceptionMessages.SURVEY_NOT_FOUND);
		}
		List<Participant> participants = new ArrayList<>();
		for (Feedback feedbacks : sur.get().getFeedbacks()) {

			participants.add(feedbacks.getParticipant());
		}
		return participants;
	}

	@Override
	public int countFeedbacksInSurvey(Survey survey) {
		Optional<Survey> sur = surveyRepo.findById(survey.getId());
		if (!sur.isPresent()) {
			throw new SurveyNotFoundException(SurveyExceptionMessages.SURVEY_NOT_FOUND);
		}
		int count = 0;
		count = sur.get().getFeedbacks().size();
		return count;
	}

	@Override
	public void close(Survey survey) {
		Optional<Survey> sur = surveyRepo.findById(survey.getId());
		if (!sur.isPresent()) {
			throw new SurveyNotFoundException(SurveyExceptionMessages.SURVEY_NOT_FOUND);
		}
		sur.get().setActive(false);
		surveyRepo.save(sur.get());

	}

}
