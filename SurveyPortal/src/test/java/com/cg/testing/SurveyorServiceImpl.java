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
import com.cg.apps.surveyapp.surveyor.entities.Surveyor;
import com.cg.apps.surveyapp.surveyor.service.ISurveyorService;
import com.cg.apps.surveyapp.surveyor.service.ISurveyorServiceImpl;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import(ISurveyorServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SurveyorServiceImpl {

	@Autowired
	private ISurveyorService surveyorService;
	@Autowired
	private EntityManager em;

	@Test
	void register() {
		Surveyor surveyor = new Surveyor("Harry_324", "Harry", "Preet");
		Surveyor savedSurveyor = surveyorService.register(surveyor);
		assertEquals(surveyor, savedSurveyor);
	}

	@Test
	void update() {
		Surveyor surveyor = new Surveyor("Harry_324", "Harry", "Preet");
		em.persist(surveyor);
		surveyor.setFirstName("Yuvraj");
		Surveyor updatePart = surveyorService.update(surveyor);
		em.persist(updatePart);
		assertEquals(surveyor, updatePart);
	}

	@Test
	void findById() {
		Surveyor surveyor = new Surveyor("Harry_324", "Harry", "Preet");
		em.persist(surveyor);
		Long id = surveyor.getId();
		Surveyor fSurveyor = surveyorService.findById(id);
		assertEquals(fSurveyor, surveyor);
	}

}
