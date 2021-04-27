package com.cg.apps.surveyapp.question.service;

import com.cg.apps.surveyapp.question.entities.Question;

public interface IQuestionService {

	Question findById(Long questionId);

	Question createQuestion(Question question);

	Question updateQuestion(Question questionDetails);

	Question removeById(Long questionId);

}
