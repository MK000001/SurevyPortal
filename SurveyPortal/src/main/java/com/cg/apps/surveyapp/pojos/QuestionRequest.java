package com.cg.apps.surveyapp.pojos;

import java.util.List;

import javax.validation.constraints.NotBlank;

import com.cg.apps.surveyapp.question.entities.Option;
import com.cg.apps.surveyapp.survey.entities.Survey;

public class QuestionRequest {
	private Long id;

	@NotBlank
	private String questionText;

	private Survey survey;

	private List<Option> options;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	public QuestionRequest() {
		super();
	}

	public QuestionRequest(Long id, @NotBlank String questionText, Survey survey, List<Option> options) {
		super();
		this.id = id;
		this.questionText = questionText;
		this.survey = survey;
		this.options = options;
	}

	@Override
	public String toString() {
		return "QuestionRequest [id=" + id + ", questionText=" + questionText + ", survey=" + survey + ", options="
				+ options + "]";
	}

}
