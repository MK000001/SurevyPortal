package com.cg.apps.surveyapp.surveyor.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.apps.surveyapp.survey.entities.Survey;
import com.cg.apps.surveyapp.surveyor.entities.Surveyor;
import com.cg.apps.surveyapp.surveyor.service.ISurveyorService;

@RestController
@RequestMapping("/surveyor")
@Validated
public class SurveyorController {

	@Autowired
	private ISurveyorService surveyorService;
	
	@RequestMapping("/hello")
	public String greet() {

		return "Hello!! from Surveyor controller";
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/add")
	public Surveyor addSurveyor(@RequestBody @Valid Surveyor surveyorDetails) {

		return surveyorService.register(surveyorDetails);
	}

	@GetMapping("/find/all")
	public List<Surveyor> findAll() {
		return surveyorService.findAll();
	}

	@GetMapping("find/id/{id}")
	public Surveyor findById(@PathVariable("id") Long id) {

		return surveyorService.findById(id);
	}

	@GetMapping("/find/survey/{datetime}")
	public List<Survey> findAllSurveysBySurveyorAfterDateTime(@RequestBody @Valid Surveyor surveyor,
			@PathVariable("dateTime") @DateTimeFormat(pattern = "dd-mm-yyyy") LocalDateTime dateTime) {

		return surveyorService.findAllSurveysBySurveyorAfterDateTime(surveyor, dateTime);
	}

	@PostMapping("/update")
	public Surveyor updateSurveyor(@RequestBody @Valid Surveyor surveyorDetails) {

		return surveyorService.update(surveyorDetails);
	}
}
