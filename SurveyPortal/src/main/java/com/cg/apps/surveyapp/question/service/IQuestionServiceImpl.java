package com.cg.apps.surveyapp.question.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.apps.surveyapp.exceptions.QuestionNotFoundException;
import com.cg.apps.surveyapp.exceptions.SurveyExceptionMessages;
import com.cg.apps.surveyapp.exceptions.SurveyNotFoundException;
import com.cg.apps.surveyapp.question.entities.Question;
import com.cg.apps.surveyapp.question.repository.IQuestionRepository;

@Service("questionService")
@Transactional
public class IQuestionServiceImpl implements IQuestionService {

	@Autowired
	private IQuestionRepository questionRepo;

	private Logger logger = LoggerFactory.getLogger(IQuestionServiceImpl.class);

	@Override
	public Question findById(Long questionId) {
		Optional<Question> question = questionRepo.findById(questionId);
		if (!question.isPresent()) {
			logger.error(SurveyExceptionMessages.QUESTION_NOT_FOUND);
			throw new QuestionNotFoundException(SurveyExceptionMessages.QUESTION_NOT_FOUND);
		}
		logger.info(question.get().toString());
		return question.get();
	}

	@Override
	public Question createQuestion(Question question) {
		if (question.getSurvey() == null) {
			logger.error(SurveyExceptionMessages.INVALID_SURVEY);
			throw new SurveyNotFoundException(SurveyExceptionMessages.INVALID_SURVEY);
		}
		logger.info(question.toString());
		return questionRepo.save(question);
	}

	@Override
	public Question updateQuestion(Question questionDetails) {
		Optional<Question> question = questionRepo.findById(questionDetails.getId());
		if (!question.isPresent()) {
			logger.error(SurveyExceptionMessages.QUESTION_NOT_FOUND);
			throw new QuestionNotFoundException(SurveyExceptionMessages.QUESTION_NOT_FOUND);
		}
		logger.info(question.get().toString());
		return questionRepo.save(question.get());

	}

	@Override
	public Question removeById(Long questionId) {
		Optional<Question> question = questionRepo.findById(questionId);
		if (!question.isPresent()) {
			logger.error(SurveyExceptionMessages.QUESTION_NOT_FOUND);
			throw new QuestionNotFoundException(SurveyExceptionMessages.QUESTION_NOT_FOUND);
		}
		questionRepo.delete(question.get());
		logger.info(question.get().toString());
		return question.get();
	}

}
