package com.cg.apps.surveyapp.participant.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.apps.surveyapp.exceptions.InvalidParticipantException;
import com.cg.apps.surveyapp.exceptions.SurveyExceptionMessages;
import com.cg.apps.surveyapp.feedback.entities.Feedback;
import com.cg.apps.surveyapp.participant.entities.Participant;
import com.cg.apps.surveyapp.participant.repository.IParticipantRepository;

@Service("participantService")
@Transactional
public class IParticipantServiceImpl implements IParticipantService {

	@Autowired
	private IParticipantRepository participantRepo;

	private Logger logger = LoggerFactory.getLogger(IParticipantServiceImpl.class);

	@Override
	public Participant register(Participant participant) {
		if (participant == null) {
			logger.error(SurveyExceptionMessages.INVALID_PARTICIPANT);
			throw new InvalidParticipantException(SurveyExceptionMessages.INVALID_PARTICIPANT);
		}
		logger.info(participant.toString());
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
			logger.error(SurveyExceptionMessages.PARTICIPANT_NOT_FOUND);
			throw new InvalidParticipantException(SurveyExceptionMessages.PARTICIPANT_NOT_FOUND);
		}
		logger.info(participant.toString());
		return participantRepo.save(part.get());
	}

	@Override
	public int countParticipations(Participant participant) {
		int count = 0;
		Optional<Participant> part = participantRepo.findById(participant.getId());
		if (!part.isPresent()) {
			logger.error(SurveyExceptionMessages.PARTICIPANT_NOT_FOUND);
			throw new InvalidParticipantException(SurveyExceptionMessages.PARTICIPANT_NOT_FOUND);
		}
		count = part.get().getFeedbacks().size();
		logger.info(Integer.toString(count));
		return count;
	}

	public List<Feedback> findFeedbacksByParticipantAfterDateTime(Participant participant, LocalDate dateTime) {

		List<Feedback> listOfFeedback = new ArrayList<>();
		Optional<Participant> part = participantRepo.findById(participant.getId());
		if (!part.isPresent()) {
			logger.error(SurveyExceptionMessages.PARTICIPANT_NOT_FOUND);
			throw new InvalidParticipantException(SurveyExceptionMessages.PARTICIPANT_NOT_FOUND);
		}
		for (Feedback feedback : part.get().getFeedbacks()) {
			if (feedback.getPostedDateTime().isAfter(dateTime)) {
				listOfFeedback.add(feedback);
			}
		}
		logger.info(listOfFeedback.toString());
		return listOfFeedback;
	}

	@Override
	public List<Participant> findAll() {
		logger.info(participantRepo.findAll().toString());
		return participantRepo.findAll();
	}

}
