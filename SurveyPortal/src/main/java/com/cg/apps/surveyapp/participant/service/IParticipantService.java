package com.cg.apps.surveyapp.participant.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.apps.surveyapp.feedback.entities.Feedback;
import com.cg.apps.surveyapp.participant.entities.Participant;

public interface IParticipantService {

	Participant register(Participant participant);

	Participant authenticate(String username, String password);

	Participant update(Participant participant);

	/**
	 * finds count of surveys participant participated in
	 *
	 * @param participant
	 * @return count of surveys participated in
	 */
	int countParticipations(Participant participant);

	List<Feedback> findFeedbacksByParticipantAfterDateTime(Participant participant, LocalDate dateTime);

	List<Participant> findAll();

}
