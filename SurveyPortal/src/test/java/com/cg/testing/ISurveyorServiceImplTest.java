package com.cg.testing;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.apps.surveyapp.surveyor.entities.Surveyor;
import com.cg.apps.surveyapp.surveyor.service.ISurveyorService;
import com.cg.apps.surveyapp.surveyor.service.ISurveyorServiceImpl;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import(ISurveyorServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ISurveyorServiceImplTest {

	@Autowired
	private ISurveyorService surveyorService;

	@Test
	void register() {
		Surveyor surveyor = new Surveyor("Rahul_1234", "Rahul", "Garg");
		Surveyor savedSurveyor = surveyorService.register(surveyor);
		assertEquals(surveyor, savedSurveyor);
	}

	@Test
	void update() {
		Surveyor surveyor = surveyorService.register(new Surveyor("Rahul_1234", "Rahul", "Garg"));
		surveyor.setFirstName("Shivam");
		surveyor.setUsername("Shivam_1234");
		Surveyor updatePart = surveyorService.update(surveyor);
		assertEquals(surveyor, updatePart);
	}

	@Test
	void findById() {
		Surveyor surveyor = surveyorService.register(new Surveyor("Rahul_1234", "Rahul", "Garg"));
		Long id = surveyor.getId();
		Surveyor fSurveyor = surveyorService.findById(id);
		assertEquals(fSurveyor, surveyor);
	}

}
