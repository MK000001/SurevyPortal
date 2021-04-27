package com.cg.testing;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.apps.surveyapp.feedback.entities.Feedback;
import com.cg.apps.surveyapp.feedback.service.IFeedbackService;
import com.cg.apps.surveyapp.feedback.service.IFeedbackServiceImpl;
import com.cg.apps.surveyapp.participant.entities.Participant;
import com.cg.apps.surveyapp.question.entities.Option;
import com.cg.apps.surveyapp.survey.entities.Survey;
import com.cg.apps.surveyapp.surveyor.entities.Surveyor;
import com.cg.apps.surveyapp.topic.entities.Topic;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import(IFeedbackServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class IFeedbackServiceImplTest {

	@Autowired
	private IFeedbackService feedbackService;

	@Test
	void createFeedback() {

		Participant participant = new Participant("Shivam_123", "Shivam", "Sharma");
		Survey survey = new Survey("New Survey", new Topic("New Topic", "Topic Description"),
				new Surveyor("Rahul_123", "Rahul", "Garg"), LocalDate.of(2019, 06, 27), LocalDate.of(2022, 06, 27),
				true);
		Map<Long, Option> chosenAnswers = new HashMap<>();
		chosenAnswers.put(1L, new Option(1, "Male"));
		chosenAnswers.put(2L, new Option(3, "20-35"));
		chosenAnswers.put(3L, new Option(4, "Good"));

		Feedback feedback = new Feedback();
		feedback.setChosenAnswers(chosenAnswers);
		feedback.setParticipant(participant);
		feedback.setSurvey(survey);
		Feedback savedFeedback = feedbackService.createFeedback(feedback);
		assertEquals(feedback.getChosenAnswers(), savedFeedback.getChosenAnswers());
		assertEquals(feedback.getParticipant(), savedFeedback.getParticipant());
		assertEquals(feedback.getSurvey(), savedFeedback.getSurvey());
	}

	@Test
	void updateFeedback() {

		Participant participant = new Participant("Shivam_123", "Shivam", "Sharma");
		Survey survey = new Survey("New Survey", new Topic("New Topic", "Topic Description"),
				new Surveyor("Rahul_123", "Rahul", "Garg"), LocalDate.of(2019, 06, 27), LocalDate.of(2022, 06, 27),
				true);
		Map<Long, Option> chosenAnswers = new HashMap<>();
		chosenAnswers.put(1L, new Option(1, "Male"));
		chosenAnswers.put(2L, new Option(3, "20-35"));
		chosenAnswers.put(3L, new Option(4, "Good"));

		Feedback feedback = new Feedback();
		feedback.setChosenAnswers(chosenAnswers);
		feedback.setParticipant(participant);
		feedback.setSurvey(survey);
		Feedback savedFeedback = feedbackService.createFeedback(feedback);

		chosenAnswers.put(4L, new Option(2, "Indian"));
		Feedback updateFeedback = feedbackService.updateFeedback(savedFeedback.getId(),
				(Map<Long, Option>) chosenAnswers);
		assertEquals(savedFeedback, updateFeedback);
	}
}
