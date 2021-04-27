package com.cg.apps.surveyapp.pojos;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.cg.apps.surveyapp.participant.entities.Participant;
import com.cg.apps.surveyapp.question.entities.Option;
import com.cg.apps.surveyapp.survey.entities.Survey;
import com.fasterxml.jackson.annotation.JsonFormat;

public class FeedbackRequest {
	private Long id;

	private Survey survey;
	@JsonFormat(pattern = "dd-MMM-yyyy", timezone = "Asia/Calcutta")
	private LocalDate postedDateTime;

	private Participant participant;

	private Map<Long, Option> chosenAnswers = new HashMap<>();

	public FeedbackRequest() {
		super();
	}

	public FeedbackRequest(Long id, Survey survey, LocalDate postedDateTime, Participant participant,
			Map<Long, Option> chosenAnswers) {
		super();
		this.id = id;
		this.survey = survey;
		this.postedDateTime = postedDateTime;
		this.participant = participant;
		this.chosenAnswers = chosenAnswers;
	}

	public FeedbackRequest(Survey survey, LocalDate postedDateTime) {
		super();
		this.survey = survey;
		this.postedDateTime = postedDateTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public LocalDate getPostedDateTime() {
		return postedDateTime;
	}

	public void setPostedDateTime(LocalDate postedDateTime) {
		this.postedDateTime = postedDateTime;
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public Map<Long, Option> getChosenAnswers() {
		return chosenAnswers;
	}

	public void setChosenAnswers(Map<Long, Option> chosenAnswers) {
		this.chosenAnswers = chosenAnswers;
	}

	@Override
	public String toString() {
		return "FeedbackRequest [id=" + id + ", survey=" + survey + ", postedDateTime=" + postedDateTime
				+ ", chosenAnswers=" + chosenAnswers + "]";
	}

}
