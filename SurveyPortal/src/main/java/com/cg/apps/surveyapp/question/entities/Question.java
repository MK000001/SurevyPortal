package com.cg.apps.surveyapp.question.entities;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.cg.apps.surveyapp.survey.entities.Survey;

@Entity
@Table(name = "question")
public class Question {

	@Id
	@GeneratedValue
	@Column(name = "question_id")
	private Long id;

	@NotBlank
	private String questionText;

	@ManyToOne
	@JoinColumn(name = "survey_id")
	private Survey survey;

	// read about @ElementCollection

	@Embedded
	@CollectionTable(name = "question_options", joinColumns = @JoinColumn(name = "ques_id"))
	@Column(name = "options")
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

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public Question() {
	}

	public Question(Long id, @NotBlank String questionText, Survey survey, List<Option> options) {
		super();
		this.id = id;
		this.questionText = questionText;
		this.survey = survey;
		this.options = options;
	}

	public Question(@NotBlank String questionText) {
		super();
		this.questionText = questionText;
	}

	public Question(@NotBlank String questionText, Survey survey, List<Option> options) {
		super();
		this.questionText = questionText;
		this.survey = survey;
		this.options = options;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", questionText=" + questionText + ", options=" + options + "]";
	}

}
