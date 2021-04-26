package com.cg.apps.surveyapp.participant.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.apps.surveyapp.exceptions.InvalidParticipantException;
import com.cg.apps.surveyapp.exceptions.ParticipantNotFoundException;
import com.cg.apps.surveyapp.exceptions.SurveyExceptionMessages;
import com.cg.apps.surveyapp.feedback.entities.Feedback;
import com.cg.apps.surveyapp.participant.entities.Participant;
import com.cg.apps.surveyapp.participant.repository.IParticipantRepository;

@Service("participantService")
@Transactional
public class IParticipantServiceImpl implements IParticipantService {

	@Autowired
	IParticipantRepository participantRepo;

	@Override
	public Participant register(Participant participant) {
		if (participant == null) {
			throw new InvalidParticipantException(SurveyExceptionMessages.INVALID_PARTICIPANT);
		}

		return participantRepo.save(participant);
	}

	@Override
	public Participant authenticate(String username, String password) {

		return null;
	}

	@Override
	public Participant update(Participant participant) {
		Optional<Participant> part = participantRepo.findById(participant.getId());
		if (!part.isPresent()) {
			throw new InvalidParticipantException(SurveyExceptionMessages.INVALID_PARTICIPANT);
		}
		return participantRepo.save(participant);
	}

	@Override
	public int countParticipations(Participant participant) {
		int count = 0;
		Optional<Participant> part = participantRepo.findById(participant.getId());
		if (!part.isPresent()) {
			throw new InvalidParticipantException(SurveyExceptionMessages.INVALID_PARTICIPANT);
		}
		count = part.get().getFeedbacks().size();
		return count;
	}

	public List<Feedback> findFeedbacksByParticipantAfterDateTime(Participant participant, LocalDateTime dateTime) {

		List<Feedback> listOfFeedback = new ArrayList<>();
		Optional<Participant> part = participantRepo.findById(participant.getId());
		if (!part.isPresent()) {
			throw new InvalidParticipantException(SurveyExceptionMessages.INVALID_PARTICIPANT);
		}
		for (Feedback feedback : part.get().getFeedbacks()) {
			if (feedback.getPostedDateTime().isAfter(dateTime)) {
				listOfFeedback.add(feedback);
			}
		}
		return listOfFeedback;

	}

	@Override
	public List<Participant> findAll() {
		return participantRepo.findAll();
	}

}
