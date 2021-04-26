package com.cg.apps.surveyapp.survey.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.apps.surveyapp.exceptions.InvalidSurveyException;
import com.cg.apps.surveyapp.exceptions.SurveyNotFoundException;
import com.cg.apps.surveyapp.participant.entities.Participant;
import com.cg.apps.surveyapp.survey.entities.Survey;
import com.cg.apps.surveyapp.survey.service.ISurveyService;

@RestController
@RequestMapping("/survey")
@Validated
public class SurveyController {
	@Autowired
	private ISurveyService surveyService;

	@RequestMapping("/hello")
	public String greet() {

		return "Hello!! from survey controller";
	}

	@PostMapping("/update")
	public Survey updateSurvey(@RequestBody @Valid Long surveyId, String description) {
		return surveyService.updateSurveyDescription(surveyId, description);

	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/add")
	public Survey add(@RequestBody @Valid Survey survey) {

		return surveyService.add(survey);

	}

	@GetMapping("/count/surveys")
	public int countFeedbacksInSurvey(@RequestBody @Valid Survey survey) {
		int count = 0;

		count = surveyService.countFeedbacksInSurvey(survey);
		return count;
	}

	@GetMapping("/participants")
	public List<Participant> findParticipants(@RequestBody @Valid Survey survey) {
		return surveyService.findParticipants(survey);

	}

}
