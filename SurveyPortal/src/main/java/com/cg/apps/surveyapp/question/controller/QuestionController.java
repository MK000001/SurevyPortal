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

import com.cg.apps.surveyapp.question.entities.Question;
import com.cg.apps.surveyapp.question.service.IQuestionService;

@RestController
@RequestMapping("/question")
@Validated
public class QuestionController {

	@Autowired
	private IQuestionService questionService;
	
	@RequestMapping("/hello")
	public String greet() {

		return "Hello!! from Question controller";
	}

	@PostMapping("/add")
	public Question addQuestion(@RequestBody Question questionDetails) {
		return questionService.createQuestion(questionDetails.getSurvey(), questionDetails.getQuestionText(),
				questionDetails.getOptions());
	}

	@PostMapping("/update")
	public Question updateQuestion(@RequestBody Question questionDetails) {
		return questionService.updateQuestion(questionDetails);
	}

	@DeleteMapping("/delete/{id}")
	public Question deleteQuestion(@PathVariable("id") Long questionId) {
		return questionService.removeById(questionId);
	}

	@GetMapping("/find/id")
	public Question findById(Long id) {

		return questionService.findById(id);
	}

}
