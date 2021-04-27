package com.cg.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.apps.surveyapp.dto.SurveyDetails;
import com.cg.apps.surveyapp.survey.entities.Survey;

@Component
public class SurveyUtil {

	public SurveyDetails toDetails(Survey survey) {
		return new SurveyDetails(survey.getId(), survey.getDescription(), survey.getPublishedDateTime(),
				survey.getEndDateTime(), survey.getActive());
	}

	public List<SurveyDetails> toDetails(List<Survey> surveys) {
		List<SurveyDetails> surveyList = new ArrayList<>();
		if (surveys == null) {
			return surveyList;
		}
		for (Survey survey : surveys) {
			surveyList.add(toDetails(survey));
		}

		return surveyList;
	}

}
