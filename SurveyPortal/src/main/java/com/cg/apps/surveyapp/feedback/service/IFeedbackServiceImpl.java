package com.cg.apps.surveyapp.feedback.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.apps.surveyapp.exceptions.FeedbackNotFoundException;
import com.cg.apps.surveyapp.exceptions.SurveyExceptionMessages;
import com.cg.apps.surveyapp.exceptions.SurveyNotFoundException;
import com.cg.apps.surveyapp.feedback.entities.Feedback;
import com.cg.apps.surveyapp.feedback.repository.IFeedbackRepository;
import com.cg.apps.surveyapp.question.entities.Option;
import com.cg.apps.surveyapp.survey.entities.Survey;
import com.cg.apps.surveyapp.survey.repository.ISurveyRepository;

@Service("feedbackService")
@Transactional
public class IFeedbackServiceImpl implements IFeedbackService {
	@Autowired
	IFeedbackRepository feedbackRepo;

	@Autowired
	private ISurveyRepository surveyRepo;

	private Logger logger = LoggerFactory.getLogger(IFeedbackServiceImpl.class);

	@Override
	public Feedback createFeedback(Feedback feedback) {

		logger.info(feedback.toString());
		return feedbackRepo.save(feedback);
	}

	@Override
	public Feedback updateFeedback(Long feedbackId, Map<Long, Option> answers) {
		Optional<Feedback> feed = feedbackRepo.findById(feedbackId);
		if (!feed.isPresent()) {
			logger.error(SurveyExceptionMessages.FEEDBACK_NOT_FOUND);
			throw new FeedbackNotFoundException(SurveyExceptionMessages.FEEDBACK_NOT_FOUND);
		}
		feed.get().setChosenAnswers(answers);
		logger.info(feed.get().toString());
		return feedbackRepo.save(feed.get());
	}

	@Override
	public List<Feedback> findFeedbacksForSurveyAfterDateTime(Survey survey, LocalDate dateTime) {
		List<Feedback> listOfFeedback = new ArrayList<>();
		Optional<Survey> sur = surveyRepo.findById(survey.getId());
		if (!sur.isPresent()) {
			logger.error(SurveyExceptionMessages.SURVEY_NOT_FOUND);
			throw new SurveyNotFoundException(SurveyExceptionMessages.SURVEY_NOT_FOUND);
		}
		List<Feedback> feedbacks = sur.get().getFeedbacks();
		if (feedbacks == null) {
			logger.error(SurveyExceptionMessages.FEEDBACK_NOT_FOUND);
			throw new FeedbackNotFoundException(SurveyExceptionMessages.FEEDBACK_NOT_FOUND);
		}
		for (Feedback feedback : feedbacks) {
			if (feedback.getPostedDateTime().isAfter(dateTime)) {
				listOfFeedback.add(feedback);
			}
		}
		logger.info(listOfFeedback.toString());
		return listOfFeedback;
	}

	@Override
	public void removeByFeedbackById(Long feedbackId) {
		Optional<Feedback> feed = feedbackRepo.findById(feedbackId);
		if (!feed.isPresent()) {
			logger.error(SurveyExceptionMessages.FEEDBACK_NOT_FOUND);
			throw new FeedbackNotFoundException(SurveyExceptionMessages.FEEDBACK_NOT_FOUND);
		}
		logger.info(feed.get().toString());
		feedbackRepo.deleteById(feedbackId);
	}

	@Override
	public List<Feedback> findAll() {
		logger.info(feedbackRepo.findAll().toString());
		return feedbackRepo.findAll();
	}

}