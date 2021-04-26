package com.cg.apps.surveyapp.participant.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.apps.surveyapp.feedback.entities.Feedback;
import com.cg.apps.surveyapp.participant.entities.Participant;

@Repository("participantRepo")
public interface IParticipantRepository extends JpaRepository<Participant, Long> {

	// List<Feedback> findFeedbacksByParticipantAfterDateTime(Participant
	// participant, LocalDateTime dateTime);

}
