package com.cg.apps.surveyapp.participant.contoller;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

import com.cg.apps.surveyapp.feedback.entities.Feedback;
import com.cg.apps.surveyapp.participant.entities.Participant;
import com.cg.apps.surveyapp.participant.service.IParticipantService;

@RestController
@RequestMapping("/participant")
@Validated
public class ParticipantController {

	@Autowired
	private IParticipantService participantService;

	@RequestMapping("/hello")
	public String greet() {

		return "Hello!! from participant controller";
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/add")
	public Participant addParticipant(@RequestBody @Valid Participant participantDetails) {
		return participantService.register(participantDetails);
	}

	@GetMapping("/all")
	public List<Participant> findAll() {
		return participantService.findAll();
	}

	@GetMapping("/count/participations")
	public int countParticipations(@RequestBody @Valid Participant participant) {
		int count = 0;
		count = participantService.countParticipations(participant);
		return count;
	}

	@PostMapping("/update")
	public Participant updateParticipant(@RequestBody @Valid Participant participant) {

		return participantService.update(participant);
	}

	@GetMapping("/find/feedback/{dateTime}")
	public List<Feedback> findFeedbacksByParticipantAfterDateTime(@RequestBody @Valid Participant participant,
			@PathVariable("dateTime") @DateTimeFormat(pattern = "dd-mm-yyyy") LocalDateTime dateTime) {
		return participantService.findFeedbacksByParticipantAfterDateTime(participant, dateTime);
	}
}
