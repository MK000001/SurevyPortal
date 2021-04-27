package com.cg.apps.surveyapp.feedback.entities;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.Table;

import com.cg.apps.surveyapp.participant.entities.Participant;
import com.cg.apps.surveyapp.question.entities.Option;
import com.cg.apps.surveyapp.survey.entities.Survey;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * represents the survey response
 */
@Entity
@Table(name = "feedback")
public class Feedback {

	@Id
	@GeneratedValue
	@Column(name = "feedback_id")
	private Long id;
	@ManyToOne
	@JoinColumn(name = "survey_id")
	private Survey survey;
	@JsonFormat(pattern = "dd-MMM-yyyy", timezone = "Asia/Calcutta")
	private LocalDate postedDateTime;

	@ManyToOne
	@JoinColumn(name = "participant_id")
	private Participant participant;

	// map of question id Long key and option as value
	// read about @ElementCollection

	@ElementCollection
	@MapKeyJoinColumn(name = "question_id")
	@Column(name = "chosenAnswers")
	private Map<Long, Option> chosenAnswers = new HashMap<>();

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

	public Feedback() {

	}

	public Feedback(Long id, Survey survey, LocalDate postedDateTime, Participant participant,
			Map<Long, Option> chosenAnswers) {

		this.id = id;
		this.survey = survey;
		this.postedDateTime = postedDateTime;
		this.participant = participant;
		this.chosenAnswers = chosenAnswers;
	}

	public Feedback(Survey survey, LocalDate postedDateTime, Participant participant, Map<Long, Option> chosenAnswers) {

		this.survey = survey;
		this.postedDateTime = postedDateTime;
		this.participant = participant;
		this.chosenAnswers = chosenAnswers;
	}

	public Feedback(LocalDate postedDateTime, Map<Long, Option> chosenAnswers) {

		this.postedDateTime = postedDateTime;
		this.chosenAnswers = chosenAnswers;
	}

	public Feedback(Survey survey2, LocalDate postedDateTime2, Participant participant2) {
		this.setSurvey(survey2);
		this.setPostedDateTime(postedDateTime2);
		this.setParticipant(participant2);
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", postedDateTime=" + postedDateTime + ", chosenAnswers=" + chosenAnswers + "]";
	}

}
