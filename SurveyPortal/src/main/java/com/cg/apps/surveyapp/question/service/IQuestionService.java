package com.cg.apps.surveyapp.question.service;

import java.util.List;

import com.cg.apps.surveyapp.question.entities.Option;
import com.cg.apps.surveyapp.question.entities.Question;
import com.cg.apps.surveyapp.survey.entities.Survey;

public interface IQuestionService {

	Question findById(Long questionId);

	Question createQuestion(Survey survey, String questionText, List<Option> options);

	Question updateQuestion(Question questionDetails);

	Question removeById(Long questionId);

}
