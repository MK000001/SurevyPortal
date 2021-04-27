package com.cg.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.apps.surveyapp.dto.SurveyDetails;
import com.cg.apps.surveyapp.dto.SurveyorDetails;
import com.cg.apps.surveyapp.survey.entities.Survey;
import com.cg.apps.surveyapp.surveyor.entities.Surveyor;

@Component
public class SurveyorUtil {

	@Autowired
	SurveyUtil surveyUtil;

	public SurveyorDetails toDetails(Surveyor surveyor) {
		List<Survey> surveyList = surveyor.getCreatedSurveys();
		List<SurveyDetails> surveys = new ArrayList<>();
		if (surveyList != null) {
			for (Survey survey : surveyList) {
				surveys.add(new SurveyDetails(surveyUtil.toDetails(survey)));
			}
		}
		return new SurveyorDetails(surveyor.getId(), surveyor.getUsername(), surveyor.getFirstName(),
				surveyor.getLastName(), surveys);
	}

	public List<SurveyorDetails> toDetails(List<Surveyor> surveyors) {
		List<SurveyorDetails> surveyorsList = new ArrayList<>();
		for (Surveyor surveyor : surveyors) {
			surveyorsList.add(toDetails(surveyor));
		}
		return surveyorsList;
	}

}
