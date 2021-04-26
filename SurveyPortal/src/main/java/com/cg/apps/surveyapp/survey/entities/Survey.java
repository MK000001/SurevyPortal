package com.cg.apps.surveyapp.survey.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.cg.apps.surveyapp.feedback.entities.Feedback;
import com.cg.apps.surveyapp.surveyor.entities.Surveyor;
import com.cg.apps.surveyapp.topic.entities.Topic;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "survey")
public class Survey {
	@Id
	@GeneratedValue
	@Column(name = "survey_id")
	private Long id;
	@Size(min = 10, max = 100, message = "description must be 10 to 100 characters long")
	private String description;
	@ManyToOne
	@JoinColumn(name = "topic_id")
	private Topic topic;
	@ManyToOne
	@JoinColumn(name = "surveyor_id")
	private Surveyor postedBy;
	@JsonFormat(pattern = "dd-MMM-yyyy", timezone = "Asia/Calcutta")
	private LocalDateTime publishedDateTime;
	@JsonFormat(pattern = "dd-MMM-yyyy", timezone = "Asia/Calcutta")
	private LocalDateTime endDateTime;
	private Boolean active;
	@OneToMany(mappedBy = "survey")
	private List<Feedback> feedbacks = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public Survey(Long id,
			@Size(min = 10, max = 100, message = "description must be 10 to 100 characters long") String description,
			Topic topic, Surveyor postedBy, LocalDateTime publishedDateTime, LocalDateTime endDateTime, Boolean active,
			List<Feedback> feedbacks) {
		super();
		this.id = id;
		this.description = description;
		this.topic = topic;
		this.postedBy = postedBy;
		this.publishedDateTime = publishedDateTime;
		this.endDateTime = endDateTime;
		this.active = active;
		this.feedbacks = feedbacks;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Surveyor getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(Surveyor postedBy) {
		this.postedBy = postedBy;
	}

	public LocalDateTime getPublishedDateTime() {
		return publishedDateTime;
	}

	public void setPublishedDateTime(LocalDateTime publishedDateTime) {
		this.publishedDateTime = publishedDateTime;
	}

	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Survey() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Survey(Long id,
			@Size(min = 10, max = 100, message = "description must be 10 to 100 characters long") String description,
			@Size(min = 3, max = 15, message = "topic must be 3 to 15 characters long") Topic topic, Surveyor postedBy,
			LocalDateTime publishedDateTime, LocalDateTime endDateTime, Boolean active) {
		super();
		this.id = id;
		this.description = description;
		this.topic = topic;
		this.postedBy = postedBy;
		this.publishedDateTime = publishedDateTime;
		this.endDateTime = endDateTime;
		this.active = active;
	}

	public Survey(
			@Size(min = 10, max = 100, message = "description must be 10 to 100 characters long") String description,
			@Size(min = 3, max = 15, message = "topic must be 3 to 15 characters long") Topic topic, Surveyor postedBy,
			LocalDateTime publishedDateTime, LocalDateTime endDateTime, Boolean active) {
		super();
		this.description = description;
		this.topic = topic;
		this.postedBy = postedBy;
		this.publishedDateTime = publishedDateTime;
		this.endDateTime = endDateTime;
		this.active = active;
	}

	public Survey(
			@Size(min = 10, max = 100, message = "description must be 10 to 100 characters long") String description,
			@Size(min = 3, max = 15, message = "topic must be 3 to 15 characters long") Topic topic,
			LocalDateTime publishedDateTime, LocalDateTime endDateTime, Boolean active) {
		super();
		this.description = description;
		this.topic = topic;
		this.publishedDateTime = publishedDateTime;
		this.endDateTime = endDateTime;
		this.active = active;
	}

	@Override
	public String toString() {
		return "Survey [id=" + id + ", description=" + description + ", topic=" + topic + ", postedBy="
				+ postedBy.getUsername() + ", publishedDateTime=" + publishedDateTime + ", endDateTime=" + endDateTime
				+ ", active=" + active + "]";
	}

	public void addFeedback(Feedback feedback) {
		feedback.setSurvey(this);
		feedbacks.add(feedback);
	}
}
