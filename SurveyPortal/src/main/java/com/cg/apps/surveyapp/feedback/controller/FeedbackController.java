package com.cg.apps.surveyapp.feedback.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.apps.surveyapp.feedback.entities.Feedback;
import com.cg.apps.surveyapp.feedback.service.IFeedbackService;
import com.cg.apps.surveyapp.question.entities.Option;
import com.cg.apps.surveyapp.survey.entities.Survey;

@RestController
@RequestMapping("/feedback")
@Validated
public class FeedbackController {

	@Autowired
	private IFeedbackService feedbackService;

	@RequestMapping("/hello")
	public String greet() {
		return "Hello! from Feedback Controller";
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/add")
	public Feedback addFeedback(@RequestBody @Valid Feedback feedbackDetails) {

		Feedback feed = new Feedback(feedbackDetails.getSurvey(), feedbackDetails.getPostedDateTime(),
				feedbackDetails.getParticipant());
		Map<Long, Option> chosenAnswers = feedbackDetails.getChosenAnswers();
		if (chosenAnswers != null) {
			feed.setChosenAnswers(chosenAnswers);
		}
		return feedbackService.createFeedback(feed.getSurvey(), feed.getParticipant(), feed.getChosenAnswers());
	}

	@GetMapping("/all")
	public List<Feedback> findAll() {
		return feedbackService.findAll();
	}

	@PostMapping("/update")
	public Feedback updateFeedback(@RequestBody @Valid Feedback feedback) {

		return feedbackService.updateFeedback(feedback.getId(), feedback.getChosenAnswers());

	}

	@DeleteMapping("/delete/{id}")
	public void removeByFeedbackById(@PathVariable Long feedbackId) {
		feedbackService.removeByFeedbackById(feedbackId);
	}

	@GetMapping("/find/{dateTime}")
	public List<Feedback> findFeedbacksForSurveyAfterDateTime(@RequestBody Survey survey,
			@PathVariable("dateTime") @DateTimeFormat(pattern = "dd-mm-yyyy") LocalDateTime dateTime) {
		return feedbackService.findFeedbacksForSurveyAfterDateTime(survey, dateTime);
	}

}
