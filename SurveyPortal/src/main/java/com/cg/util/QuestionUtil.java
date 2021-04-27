package com.cg.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.apps.surveyapp.dto.QuestionDetails;
import com.cg.apps.surveyapp.question.entities.Question;

@Component
public class QuestionUtil {
	@Autowired
	private SurveyUtil surveyUtil;

	public QuestionDetails toDetails(Question question) {
		return new QuestionDetails(question.getId(), question.getQuestionText(),
				surveyUtil.toDetails(question.getSurvey()), question.getOptions());
	}

}
