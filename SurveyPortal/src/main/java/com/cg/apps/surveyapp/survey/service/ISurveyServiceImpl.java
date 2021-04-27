package com.cg.apps.surveyapp.survey.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private ISurveyRepository surveyRepo;

	private Logger logger = LoggerFactory.getLogger(ISurveyServiceImpl.class);

	@Override
	public Survey updateSurveyDescription(Long surveyId, String description) {
		Optional<Survey> survey = surveyRepo.findById(surveyId);
		if (!survey.isPresent()) {
			logger.error(SurveyExceptionMessages.SURVEY_NOT_FOUND);
			throw new SurveyNotFoundException(SurveyExceptionMessages.SURVEY_NOT_FOUND);
		}
		survey.get().setDescription(description);
		logger.info(survey.get().toString());
		return surveyRepo.save(survey.get());
	}

	@Override
	public Survey add(Survey survey) {
		if (survey == null) {
			logger.error(SurveyExceptionMessages.INVALID_SURVEY);
			throw new InvalidSurveyException(SurveyExceptionMessages.INVALID_SURVEY);
		}
		logger.info(survey.toString());
		return surveyRepo.save(survey);
	}

	@Override
	public Survey findById(Long id) {
		Optional<Survey> survey = surveyRepo.findById(id);
		if (!survey.isPresent()) {
			logger.info(SurveyExceptionMessages.SURVEY_NOT_FOUND);
			throw new SurveyNotFoundException(SurveyExceptionMessages.SURVEY_NOT_FOUND);
		}
		logger.info(survey.get().toString());
		return survey.get();
	}

	@Override
	public void removeSurveyById(Long id) {
		Optional<Survey> survey = surveyRepo.findById(id);
		if (!survey.isPresent()) {
			logger.error(SurveyExceptionMessages.SURVEY_NOT_FOUND);
			throw new SurveyNotFoundException(SurveyExceptionMessages.SURVEY_NOT_FOUND);
		}
		logger.info(survey.get().toString());
		surveyRepo.delete(survey.get());
	}

	@Override
	public List<Participant> findParticipants(Survey survey) {
		Optional<Survey> sur = surveyRepo.findById(survey.getId());
		if (!sur.isPresent()) {
			logger.error(SurveyExceptionMessages.SURVEY_NOT_FOUND);
			throw new SurveyNotFoundException(SurveyExceptionMessages.SURVEY_NOT_FOUND);
		}
		List<Participant> participants = new ArrayList<>();
		for (Feedback feedback : sur.get().getFeedbacks()) {
			participants.add(feedback.getParticipant());
		}
		logger.info(participants.toString());
		return participants;
	}

	@Override
	public int countFeedbacksInSurvey(Survey survey) {
		Optional<Survey> sur = surveyRepo.findById(survey.getId());
		if (!sur.isPresent()) {
			logger.error(SurveyExceptionMessages.SURVEY_NOT_FOUND);
			throw new SurveyNotFoundException(SurveyExceptionMessages.SURVEY_NOT_FOUND);
		}
		int count = 0;
		count = sur.get().getFeedbacks().size();
		logger.info(Integer.toString(count));
		return count;
	}

	@Override
	public void close(Survey survey) {
		Optional<Survey> sur = surveyRepo.findById(survey.getId());
		if (!sur.isPresent()) {
			logger.error(SurveyExceptionMessages.SURVEY_NOT_FOUND);
			throw new SurveyNotFoundException(SurveyExceptionMessages.SURVEY_NOT_FOUND);
		}
		sur.get().setActive(false);
		logger.info(sur.get().toString());
		surveyRepo.save(sur.get());
	}

}
