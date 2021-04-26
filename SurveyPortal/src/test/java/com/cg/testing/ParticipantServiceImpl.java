package com.cg.testing;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.apps.surveyapp.feedback.entities.Feedback;
import com.cg.apps.surveyapp.participant.entities.Participant;
import com.cg.apps.surveyapp.participant.service.IParticipantService;
import com.cg.apps.surveyapp.participant.service.IParticipantServiceImpl;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import(IParticipantServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ParticipantServiceImpl {

	@Autowired
	private IParticipantService participantService;
	@Autowired
	private EntityManager em;

	@Test
	void register() {
		Participant participant = new Participant("John_123", "John", "Mayer");
		Participant savedPart = participantService.register(participant);
		Assertions.assertEquals(participant.getFirstName(), savedPart.getFirstName());
	}

	@Test
	void update() {
		Participant participant = new Participant("Robert_777", "Robert", "Junior");
		em.persist(participant);
		participant.setFirstName("Downey");
		Participant updatePart = participantService.update(participant);
		em.persist(updatePart);
		assertEquals(participant, updatePart);
	}

	@Test
	void countParticipations() {
		Participant participant = new Participant("Jason_099", "Jason", "Statham");
		em.persist(participant);
		int count = participantService.countParticipations(participant);
		assertEquals(0, count);

	}

}
