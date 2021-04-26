package com.cg.apps.surveyapp.feedback.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.apps.surveyapp.exceptions.FeedbackNotFoundException;
import com.cg.apps.surveyapp.exceptions.SurveyExceptionMessages;
import com.cg.apps.surveyapp.exceptions.SurveyNotFoundException;
import com.cg.apps.surveyapp.feedback.entities.Feedback;
import com.cg.apps.surveyapp.feedback.repository.IFeedbackRepository;
import com.cg.apps.surveyapp.participant.entities.Participant;
import com.cg.apps.surveyapp.question.entities.Option;
import com.cg.apps.surveyapp.survey.entities.Survey;
import com.cg.apps.surveyapp.survey.service.ISurveyService;

@Service("feedbackService")
@Transactional
public class IFeedbackServiceImpl implements IFeedbackService {
	@Autowired
	IFeedbackRepository feedbackRepo;

	@Autowired
	ISurveyService surveySurvice;

	@Override
	public Feedback createFeedback(Survey survey, Participant participant, Map<Long, Option> answers) {
		Feedback feed = new Feedback();
		feed.setChosenAnswers(answers);
		feed.setSurvey(survey);
		feed.setParticipant(participant);
		return feedbackRepo.save(feed);
	}

	@Override
	public Feedback updateFeedback(Long feedbackId, Map<Long, Option> answers) {
		Optional<Feedback> feed = feedbackRepo.findById(feedbackId);
		if (!feed.isPresent()) {
			throw new FeedbackNotFoundException(SurveyExceptionMessages.FEEDBACK_NOT_FOUND);
		}
		feed.get().setChosenAnswers(answers);
		return feedbackRepo.save(feed.get());
	}

	@Override
	public List<Feedback> findFeedbacksForSurveyAfterDateTime(Survey survey, LocalDateTime dateTime) {
		List<Feedback> listOfFeedback = new ArrayList<>();
		Survey sur = surveySurvice.findById(survey.getId());
		if (sur == null) {
			throw new SurveyNotFoundException(SurveyExceptionMessages.SURVEY_NOT_FOUND);
		}
		List<Feedback> feedbacks = sur.getFeedbacks();
		if (feedbacks == null) {
			throw new FeedbackNotFoundException(SurveyExceptionMessages.FEEDBACK_NOT_FOUND);
		}
		for (Feedback feedback : feedbacks) {
			if (feedback.getPostedDateTime().isAfter(dateTime)) {
				listOfFeedback.add(feedback);
			}
		}
		return listOfFeedback;
	}

	@Override
	public void removeByFeedbackById(Long feedbackId) {
		Optional<Feedback> feed = feedbackRepo.findById(feedbackId);
		if (!feed.isPresent()) {
			throw new FeedbackNotFoundException(SurveyExceptionMessages.FEEDBACK_NOT_FOUND);
		}
		feedbackRepo.deleteById(feedbackId);

	}

	@Override
	public List<Feedback> findAll() {
		return feedbackRepo.findAll();
	}

}