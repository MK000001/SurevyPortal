package com.cg.apps.surveyapp.feedback.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.apps.surveyapp.dto.FeedbackDetails;
import com.cg.apps.surveyapp.feedback.entities.Feedback;
import com.cg.apps.surveyapp.feedback.service.IFeedbackService;
import com.cg.apps.surveyapp.pojos.FeedbackRequest;
import com.cg.apps.surveyapp.pojos.SurveyRequest;
import com.cg.apps.surveyapp.survey.entities.Survey;
import com.cg.util.FeedbackUtil;

@RestController
@RequestMapping("/feedback")
@Validated
public class FeedbackController {

	@Autowired
	private IFeedbackService feedbackService;
	@Autowired
	private FeedbackUtil feedUtil;

	@RequestMapping("/hello")
	public String greet() {
		return "Hello! from Feedback Controller";
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/add")
	public FeedbackDetails addFeedback(@RequestBody @Valid FeedbackRequest feedbackDetails) {
		Feedback feedback = new Feedback(feedbackDetails.getSurvey(), feedbackDetails.getPostedDateTime(),
				feedbackDetails.getParticipant(), feedbackDetails.getChosenAnswers());
		Feedback feed = feedbackService.createFeedback(feedback);
		return feedUtil.toDetails(feed);
	}

	@GetMapping("/all")
	public List<FeedbackDetails> findAll() {
		List<Feedback> feedbacks = feedbackService.findAll();
		return feedUtil.toDetails(feedbacks);
	}

	@PostMapping("/update")
	public FeedbackDetails updateFeedback(@RequestBody @Valid FeedbackRequest feedback) {

		Feedback feed = feedbackService.updateFeedback(feedback.getId(), feedback.getChosenAnswers());
		return feedUtil.toDetails(feed);
	}

	@DeleteMapping("/delete/{id}")
	public void removeByFeedbackById(@PathVariable("id") Long feedbackId) {
		feedbackService.removeByFeedbackById(feedbackId);
	}

	@GetMapping("/find/by/date")
	public List<FeedbackDetails> findFeedbacksForSurveyAfterDateTime(@RequestBody SurveyRequest survey,
			@RequestParam(value = "dateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateTime) {

		List<Feedback> feedbacks = feedbackService.findFeedbacksForSurveyAfterDateTime(
				new Survey(survey.getId(), survey.getDescription(), survey.getTopic(), survey.getPostedBy(),
						survey.getPublishedDateTime(), survey.getEndDateTime(), survey.getActive()),
				dateTime);
		return feedUtil.toDetails(feedbacks);
	}

}
