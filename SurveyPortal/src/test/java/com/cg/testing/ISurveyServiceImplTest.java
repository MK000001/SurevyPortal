package com.cg.testing;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.apps.surveyapp.survey.entities.Survey;
import com.cg.apps.surveyapp.survey.service.ISurveyService;
import com.cg.apps.surveyapp.survey.service.ISurveyServiceImpl;
import com.cg.apps.surveyapp.topic.entities.Topic;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import(ISurveyServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ISurveyServiceImplTest {

	@Autowired
	private ISurveyService surveyService;

	@Test
	void addSurvey() {
		Survey survey = new Survey("Survey on Crime", new Topic("Crime", "Crime related topic"),
				LocalDate.of(2019, 05, 19), LocalDate.of(2021, 05, 19), true);
		Survey savedSurvey = surveyService.add(survey);
		assertEquals(savedSurvey, survey);

	}

	@Test
	void findById() {
		Survey survey = new Survey("Survey on Crime", new Topic("Crime", "Crime related topic"),
				LocalDate.of(2019, 05, 19), LocalDate.of(2021, 05, 19), true);
		Survey savedSurvey = surveyService.add(survey);

		Survey foundSurvey = surveyService.findById(savedSurvey.getId());
		assertEquals(savedSurvey, foundSurvey);

	}

	@Test
	void updateSurvey() {
		Survey survey = new Survey("Survey on Crime", new Topic("Crime", "Crime related topic"),
				LocalDate.of(2019, 05, 19), LocalDate.of(2021, 05, 19), true);
		Survey savedSurvey = surveyService.add(survey);
		Survey updateSurvey = surveyService.updateSurveyDescription(savedSurvey.getId(), "Crime Topic");
		assertEquals(savedSurvey, updateSurvey);
	}
}
