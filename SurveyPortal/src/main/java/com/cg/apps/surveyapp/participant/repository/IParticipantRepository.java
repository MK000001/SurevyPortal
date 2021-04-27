package com.cg.apps.surveyapp.participant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.apps.surveyapp.participant.entities.Participant;

@Repository("participantRepo")
public interface IParticipantRepository extends JpaRepository<Participant, Long> {

}
