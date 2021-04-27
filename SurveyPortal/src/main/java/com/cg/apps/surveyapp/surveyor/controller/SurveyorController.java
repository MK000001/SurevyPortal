package com.cg.apps.surveyapp.surveyor.controller;

import java.time.LocalDate;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.apps.surveyapp.dto.SurveyDetails;
import com.cg.apps.surveyapp.dto.SurveyorDetails;
import com.cg.apps.surveyapp.pojos.SurveyorRequest;
import com.cg.apps.surveyapp.survey.entities.Survey;
import com.cg.apps.surveyapp.surveyor.entities.Surveyor;
import com.cg.apps.surveyapp.surveyor.service.ISurveyorService;
import com.cg.util.SurveyUtil;
import com.cg.util.SurveyorUtil;

@RestController
@RequestMapping("/surveyor")
@Validated
public class SurveyorController {

	@Autowired
	private ISurveyorService surveyorService;
	@Autowired
	private SurveyorUtil surveyorUtil;
	@Autowired
	private SurveyUtil surveyUtil;

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/add")
	public SurveyorDetails addSurveyor(@RequestBody @Valid SurveyorRequest surveyorDetails) {

		Surveyor surveyor = new Surveyor(surveyorDetails.getUsername(), surveyorDetails.getFirstName(),
				surveyorDetails.getLastName());
		Surveyor surv = surveyorService.register(surveyor);
		return surveyorUtil.toDetails(surv);
	}

	@GetMapping("/find/all")
	public List<SurveyorDetails> findAll() {
		List<Surveyor> surveyors = surveyorService.findAll();
		return surveyorUtil.toDetails(surveyors);
	}

	@GetMapping("find/id/{id}")
	public SurveyorDetails findById(@PathVariable("id") Long id) {
		Surveyor surveyor = surveyorService.findById(id);
		return surveyorUtil.toDetails(surveyor);
	}

	@GetMapping("/find/by/date")
	public List<SurveyDetails> findAllSurveysBySurveyorAfterDateTime(
			@RequestBody @Valid SurveyorRequest surveyorDetails,
			@RequestParam(value = "dateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateTime) {

		List<Survey> surveys = surveyorService.findAllSurveysBySurveyorAfterDateTime(
				new Surveyor(surveyorDetails.getId(), surveyorDetails.getUsername(), surveyorDetails.getFirstName(),
						surveyorDetails.getLastName()),
				dateTime);
		return surveyUtil.toDetails(surveys);
	}

	@PostMapping("/update")
	public SurveyorDetails updateSurveyor(@RequestBody @Valid SurveyorRequest surveyorDetails) {
		Surveyor surveyor = new Surveyor(surveyorDetails.getId(), surveyorDetails.getUsername(),
				surveyorDetails.getFirstName(), surveyorDetails.getLastName());
		Surveyor surv = surveyorService.update(surveyor);
		return surveyorUtil.toDetails(surv);
	}
}
