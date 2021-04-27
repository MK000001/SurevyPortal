package com.cg.apps.surveyapp.surveyor.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.apps.surveyapp.exceptions.InvalidSurveyorException;
import com.cg.apps.surveyapp.exceptions.SurveyExceptionMessages;
import com.cg.apps.surveyapp.exceptions.SurveyorNotFoundException;
import com.cg.apps.surveyapp.survey.entities.Survey;
import com.cg.apps.surveyapp.surveyor.entities.Surveyor;
import com.cg.apps.surveyapp.surveyor.repository.ISurveyorRepository;

@Service("surveyorService")
@Transactional
public class ISurveyorServiceImpl implements ISurveyorService {

	@Autowired
	private ISurveyorRepository surveyorRepo;

	private Logger logger = LoggerFactory.getLogger(ISurveyorServiceImpl.class);

	@Override
	public Surveyor register(Surveyor surveyor) {
		if (surveyor == null) {
			logger.error(SurveyExceptionMessages.INVALID_SURVEYOR);
			throw new InvalidSurveyorException(SurveyExceptionMessages.INVALID_SURVEYOR);
		}
		logger.info(surveyor.toString());
		return surveyorRepo.save(surveyor);
	}

	@Override
	public Surveyor authenticate(String username, String password) {
		return null;
	}

	@Override
	public Surveyor findById(Long surveyorId) {
		Optional<Surveyor> surv = surveyorRepo.findById(surveyorId);
		if (!surv.isPresent()) {
			logger.error(SurveyExceptionMessages.SURVEYOR_NOT_FOUND);
			throw new SurveyorNotFoundException(SurveyExceptionMessages.SURVEYOR_NOT_FOUND);
		}
		logger.info(surv.get().toString());
		return surv.get();
	}

	@Override
	public Surveyor update(Surveyor surveyor) {
		if (surveyor == null) {
			logger.error(SurveyExceptionMessages.INVALID_SURVEYOR);
			throw new InvalidSurveyorException(SurveyExceptionMessages.INVALID_SURVEYOR);
		}
		Optional<Surveyor> surv = surveyorRepo.findById(surveyor.getId());
		if (!surv.isPresent()) {
			logger.error(SurveyExceptionMessages.SURVEYOR_NOT_FOUND);
			throw new SurveyorNotFoundException(SurveyExceptionMessages.SURVEYOR_NOT_FOUND);
		}
		logger.info(surveyor.toString());
		return surveyorRepo.save(surveyor);
	}

	public List<Survey> findAllSurveysBySurveyorAfterDateTime(Surveyor surveyor, LocalDate dateTime) {

		List<Survey> listOfSurvey = new ArrayList<>();
		Optional<Surveyor> surv = surveyorRepo.findById(surveyor.getId());
		if (!surv.isPresent()) {
			logger.info(SurveyExceptionMessages.SURVEYOR_NOT_FOUND);
			throw new SurveyorNotFoundException(SurveyExceptionMessages.SURVEYOR_NOT_FOUND);
		}
		if (surv.get().getCreatedSurveys() == null) {
			logger.info(SurveyExceptionMessages.SURVEY_NOT_FOUND);
			throw new SurveyorNotFoundException(SurveyExceptionMessages.SURVEY_NOT_FOUND);
		}
		for (Survey survey : surv.get().getCreatedSurveys()) {
			if (survey.getPublishedDateTime().isAfter(dateTime)) {
				listOfSurvey.add(survey);
			}
		}
		logger.info(listOfSurvey.toString());
		return listOfSurvey;
	}

	@Override
	public List<Surveyor> findAll() {
		logger.info(surveyorRepo.findAll().toString());
		return surveyorRepo.findAll();
	}
}
