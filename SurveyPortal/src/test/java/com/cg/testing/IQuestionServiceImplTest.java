package com.cg.testing;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.apps.surveyapp.question.entities.Option;
import com.cg.apps.surveyapp.question.entities.Question;
import com.cg.apps.surveyapp.question.service.IQuestionService;
import com.cg.apps.surveyapp.question.service.IQuestionServiceImpl;
import com.cg.apps.surveyapp.survey.entities.Survey;
import com.cg.apps.surveyapp.topic.entities.Topic;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import(IQuestionServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class IQuestionServiceImplTest {

	@Autowired
	private IQuestionService questionService;

	@Test
	void addQuestion() {
		Question question = new Question("What is your gender?");
		question.setSurvey(new Survey("Description about Survey", new Topic("Topic_A", "Topic_A Description"),
				LocalDate.of(2019, 05, 19), LocalDate.of(2021, 05, 19), true));
		List<Option> options = new ArrayList<>();
		options.add(new Option(1, "Male"));
		options.add(new Option(2, "Female"));
		question.setOptions(options);
		Question savedQuestion = questionService.createQuestion(question);
		assertEquals(question.getOptions(), savedQuestion.getOptions());
		assertEquals(question.getQuestionText(), savedQuestion.getQuestionText());
		assertEquals(question.getSurvey(), savedQuestion.getSurvey());
	}

	@Test
	void findQuestion() {
		Question question = new Question(1L, "What is your gender?",
				new Survey("Description about Survey", new Topic("Topic_A", "Topic_A Description"),
						LocalDate.of(2019, 05, 19), LocalDate.of(2021, 05, 19), true),
				null);
		List<Option> options = new ArrayList<>();
		options.add(new Option(1, "Male"));
		options.add(new Option(2, "Female"));
		question.setOptions(options);
		Question savedQuestion = questionService.createQuestion(question);
		Question foundQuestion = questionService.findById(savedQuestion.getId());
		assertEquals(savedQuestion.getId(), foundQuestion.getId());
	}

}
