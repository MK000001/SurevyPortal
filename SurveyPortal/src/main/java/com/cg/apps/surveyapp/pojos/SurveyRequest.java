package com.cg.apps.surveyapp.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

import com.cg.apps.surveyapp.feedback.entities.Feedback;
import com.cg.apps.surveyapp.surveyor.entities.Surveyor;
import com.cg.apps.surveyapp.topic.entities.Topic;
import com.fasterxml.jackson.annotation.JsonFormat;

public class SurveyRequest {
	private Long id;
	@Size(min = 10, max = 100, message = "description must be 10 to 100 characters long")
	private String description;

	private Topic topic;

	private Surveyor postedBy;
	@JsonFormat(pattern = "dd-MMM-yyyy", timezone = "Asia/Calcutta")
	private LocalDate publishedDateTime;
	@JsonFormat(pattern = "dd-MMM-yyyy", timezone = "Asia/Calcutta")
	private LocalDate endDateTime;
	private Boolean active;

	private List<Feedback> feedbacks = new ArrayList<>();

	public Long getId() {
		return id;
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

	public LocalDate getPublishedDateTime() {
		return publishedDateTime;
	}

	public void setPublishedDateTime(LocalDate publishedDateTime) {
		this.publishedDateTime = publishedDateTime;
	}

	public LocalDate getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(LocalDate endDateTime) {
		this.endDateTime = endDateTime;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public SurveyRequest() {
		super();
	}

	public SurveyRequest(
			@Size(min = 10, max = 100, message = "description must be 10 to 100 characters long") String description,
			Topic topic, Surveyor postedBy, LocalDate publishedDateTime, LocalDate endDateTime, Boolean active,
			List<Feedback> feedbacks) {
		super();
		this.description = description;
		this.topic = topic;
		this.postedBy = postedBy;
		this.publishedDateTime = publishedDateTime;
		this.endDateTime = endDateTime;
		this.active = active;
		this.feedbacks = feedbacks;
	}

	public SurveyRequest(Long id,
			@Size(min = 10, max = 100, message = "description must be 10 to 100 characters long") String description,
			Topic topic, Surveyor postedBy, LocalDate publishedDateTime, LocalDate endDateTime, Boolean active) {
		super();
		this.id = id;
		this.description = description;
		this.topic = topic;
		this.postedBy = postedBy;
		this.publishedDateTime = publishedDateTime;
		this.endDateTime = endDateTime;
		this.active = active;
	}

	@Override
	public String toString() {
		return "SurveyRequest [id=" + id + ", description=" + description + ", topic=" + topic + ", postedBy="
				+ postedBy + ", publishedDateTime=" + publishedDateTime + ", endDateTime=" + endDateTime + ", active="
				+ active + ", feedbacks=" + feedbacks + "]";
	}

}
