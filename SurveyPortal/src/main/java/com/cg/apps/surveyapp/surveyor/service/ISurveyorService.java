package com.cg.apps.surveyapp.surveyor.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.apps.surveyapp.survey.entities.Survey;
import com.cg.apps.surveyapp.surveyor.entities.Surveyor;

public interface ISurveyorService {

	Surveyor register(Surveyor surveyor);

	Surveyor authenticate(String username, String password);

	Surveyor findById(Long surveyorId);

	Surveyor update(Surveyor surveyor);

	List<Surveyor> findAll();

	List<Survey> findAllSurveysBySurveyorAfterDateTime(Surveyor surveyor, LocalDate dateTime);

}
