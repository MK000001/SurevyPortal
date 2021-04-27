package com.cg.apps.surveyapp.dto;

import java.util.List;

import com.cg.apps.surveyapp.question.entities.Option;

public class QuestionDetails {
	private Long id;

	private String questionText;

	private SurveyDetails survey;

	private List<Option> options;

	public QuestionDetails() {
		super();
	}

	public QuestionDetails(Long id, String questionText, SurveyDetails survey, List<Option> options) {
		super();
		this.id = id;
		this.questionText = questionText;
		this.survey = survey;
		this.options = options;
	}

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

	public SurveyDetails getSurvey() {
		return survey;
	}

	public void setSurvey(SurveyDetails survey) {
		this.survey = survey;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	@Override
	public String toString() {
		return "QuestionDetails [id=" + id + ", questionText=" + questionText + ", survey=" + survey + ", options="
				+ options + "]";
	}

}
