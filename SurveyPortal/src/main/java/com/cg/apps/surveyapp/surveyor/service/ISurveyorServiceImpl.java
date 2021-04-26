package com.cg.apps.surveyapp.surveyor.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

	@Override
	public Surveyor register(Surveyor surveyor) {
		if (surveyor == null) {
			throw new InvalidSurveyorException(SurveyExceptionMessages.INVALID_SURVEYOR);
		}

		return surveyorRepo.save(surveyor);
	}

	@Override
	public Surveyor authenticate(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Surveyor findById(Long surveyorId) {
		Optional<Surveyor> surv = surveyorRepo.findById(surveyorId);
		if (!surv.isPresent()) {
			throw new SurveyorNotFoundException(SurveyExceptionMessages.SURVEYOR_NOT_FOUND);
		}
		return surv.get();
	}

	@Override
	public Surveyor update(Surveyor surveyor) {
		if (surveyor == null) {
			throw new InvalidSurveyorException(SurveyExceptionMessages.INVALID_SURVEYOR);
		}
		Optional<Surveyor> surv = surveyorRepo.findById(surveyor.getId());
		if (!surv.isPresent()) {
			throw new SurveyorNotFoundException(SurveyExceptionMessages.SURVEYOR_NOT_FOUND);
		}
		return surveyorRepo.save(surveyor);
	}

	public List<Survey> findAllSurveysBySurveyorAfterDateTime(Surveyor surveyor, LocalDateTime dateTime) {

		List<Survey> listOfSurvey = new ArrayList<>();
		Optional<Surveyor> surv = surveyorRepo.findById(surveyor.getId());
		if (!surv.isPresent()) {
			throw new SurveyorNotFoundException(SurveyExceptionMessages.SURVEYOR_NOT_FOUND);
		}
		for (Survey survey : surv.get().getCreatedSurveys()) {
			if (survey.getPublishedDateTime().isAfter(dateTime)) {
				listOfSurvey.add(survey);
			}
		}
		return listOfSurvey;
	}

	@Override
	public List<Surveyor> findAll() {
		return surveyorRepo.findAll();
	}
}
