package com.cg.apps.surveyapp.question.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.apps.surveyapp.dto.QuestionDetails;
import com.cg.apps.surveyapp.pojos.QuestionRequest;
import com.cg.apps.surveyapp.question.entities.Question;
import com.cg.apps.surveyapp.question.service.IQuestionService;
import com.cg.util.QuestionUtil;

@RestController
@RequestMapping("/question")
@Validated
public class QuestionController {

	@Autowired
	private IQuestionService questionService;

	@Autowired
	private QuestionUtil quesUtil;

	@PostMapping("/add")
	public QuestionDetails addQuestion(@RequestBody QuestionRequest questionDetails) {
		Question question = new Question(questionDetails.getQuestionText(), questionDetails.getSurvey(),
				questionDetails.getOptions());
		Question quest = questionService.createQuestion(question);
		return quesUtil.toDetails(quest);
	}

	@PostMapping("/update")
	public QuestionDetails updateQuestion(@RequestBody QuestionRequest questionDetails) {
		Question question = new Question(questionDetails.getId(), questionDetails.getQuestionText(),
				questionDetails.getSurvey(), questionDetails.getOptions());
		Question quest = questionService.updateQuestion(question);
		return quesUtil.toDetails(quest);
	}

	@DeleteMapping("/delete/{id}")
	public QuestionDetails deleteQuestion(@PathVariable("id") Long questionId) {
		Question question = questionService.removeById(questionId);
		return quesUtil.toDetails(question);
	}

	@GetMapping("/find/{id}")
	public QuestionDetails findById(@PathVariable("id") Long id) {

		Question question = questionService.findById(id);
		return quesUtil.toDetails(question);
	}

}
