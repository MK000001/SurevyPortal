package com.cg.apps.surveyapp.survey.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.apps.surveyapp.dto.ParticipantDetails;
import com.cg.apps.surveyapp.dto.SurveyDetails;
import com.cg.apps.surveyapp.pojos.SurveyRequest;
import com.cg.apps.surveyapp.survey.entities.Survey;
import com.cg.apps.surveyapp.survey.service.ISurveyService;
import com.cg.util.ParticipantUtil;
import com.cg.util.SurveyUtil;

@RestController
@RequestMapping("/survey")
@Validated
public class SurveyController {
	@Autowired
	private ISurveyService surveyService;

	@Autowired
	private SurveyUtil surveyUtil;
	@Autowired
	private ParticipantUtil partUtil;

	@RequestMapping("/hello")
	public String greet() {

		return "Hello!! from survey controller";
	}

	@PostMapping("/update")
	public SurveyDetails updateSurvey(@RequestBody @Valid SurveyRequest surveyDetails) {
		Survey survey = new Survey(surveyDetails.getId(), surveyDetails.getDescription(), surveyDetails.getTopic(),
				surveyDetails.getPostedBy(), surveyDetails.getPublishedDateTime(), surveyDetails.getEndDateTime(),
				surveyDetails.getActive());
		Survey sur = surveyService.updateSurveyDescription(survey.getId(), survey.getDescription());
		return surveyUtil.toDetails(sur);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/add")
	public SurveyDetails add(@RequestBody @Valid SurveyRequest surveyDetails) {
		Survey survey = new Survey(surveyDetails.getDescription(), surveyDetails.getTopic(),
				surveyDetails.getPostedBy(), surveyDetails.getPublishedDateTime(), surveyDetails.getEndDateTime(),
				surveyDetails.getActive());
		Survey sur = surveyService.add(survey);
		return surveyUtil.toDetails(sur);
	}

	@GetMapping("/count/surveys")
	public int countFeedbacksInSurvey(@RequestBody @Valid SurveyRequest surveyDetails) {
		int count = 0;
		Survey survey = new Survey(surveyDetails.getId(), surveyDetails.getDescription(), surveyDetails.getTopic(),
				surveyDetails.getPostedBy(), surveyDetails.getPublishedDateTime(), surveyDetails.getEndDateTime(),
				surveyDetails.getActive());
		count = surveyService.countFeedbacksInSurvey(survey);
		return count;
	}

	@GetMapping("/participants")
	public List<ParticipantDetails> findParticipants(@RequestBody @Valid SurveyRequest surveyDetails) {
		Survey survey = new Survey(surveyDetails.getId(), surveyDetails.getDescription(), surveyDetails.getTopic(),
				surveyDetails.getPostedBy(), surveyDetails.getPublishedDateTime(), surveyDetails.getEndDateTime(),
				surveyDetails.getActive());
		return partUtil.toDetails(surveyService.findParticipants(survey));
	}

	@GetMapping("/find/{id}")
	public SurveyDetails findById(@PathVariable("id") Long id) {
		Survey survey = surveyService.findById(id);
		return surveyUtil.toDetails(survey);
	}
}
