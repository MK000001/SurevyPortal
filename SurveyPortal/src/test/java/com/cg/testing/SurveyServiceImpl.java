package com.cg.testing;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

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
public class SurveyServiceImpl {

	@Autowired
	private ISurveyService surveyService;
	@Autowired
	private EntityManager em;

	@Test
	void addSurvey() {
		Survey survey = new Survey("Survey on Student", new Topic("Student", "Student Experience"),
				LocalDateTime.of(2019, 05, 19, 5, 56), LocalDateTime.of(2021, 05, 19, 5, 56), true);
		Survey savedSurvey = surveyService.add(survey);
		assertEquals(savedSurvey, survey);

	}
}
