package com.cg.apps.surveyapp.question.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.apps.surveyapp.exceptions.QuestionNotFoundException;
import com.cg.apps.surveyapp.exceptions.SurveyExceptionMessages;
import com.cg.apps.surveyapp.exceptions.SurveyNotFoundException;
import com.cg.apps.surveyapp.question.entities.Option;
import com.cg.apps.surveyapp.question.entities.Question;
import com.cg.apps.surveyapp.question.repository.IQuestionRepository;
import com.cg.apps.surveyapp.survey.entities.Survey;

@Service("questionService")
@Transactional
public class IQuestionServiceImpl implements IQuestionService {

	@Autowired
	IQuestionRepository questionRepo;

	@Override
	public Question findById(Long questionId) {
		Optional<Question> question = questionRepo.findById(questionId);
		if (!question.isPresent()) {
			throw new QuestionNotFoundException(SurveyExceptionMessages.QUESTION_NOT_FOUND);
		}

		return question.get();
	}

	@Override
	public Question createQuestion(Survey survey, String questionText, List<Option> options) {

		if (survey == null) {
			throw new SurveyNotFoundException(SurveyExceptionMessages.INVALID_SURVEY);
		}
		Question question = new Question();
		question.setQuestionText(questionText);
		question.setSurvey(survey);
		question.setOptions(options);
		return questionRepo.save(question);
	}

	@Override
	public Question updateQuestion(Question questionDetails) {
		Optional<Question> question = questionRepo.findById(questionDetails.getId());
		if (!question.isPresent()) {
			throw new QuestionNotFoundException(SurveyExceptionMessages.QUESTION_NOT_FOUND);
		}
		return questionRepo.save(question.get());

	}

	@Override
	public Question removeById(Long questionId) {
		Optional<Question> question = questionRepo.findById(questionId);
		if (!question.isPresent()) {
			throw new QuestionNotFoundException(SurveyExceptionMessages.QUESTION_NOT_FOUND);
		}
		questionRepo.delete(question.get());
		return question.get();
	}

}
