package com.cg.apps.surveyapp.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SurveyDetails {

	private Long id;

	private String description;

	@JsonFormat(pattern = "dd-MMM-yyyy", timezone = "Asia/Calcutta")
	private LocalDate publishedDateTime;
	@JsonFormat(pattern = "dd-MMM-yyyy", timezone = "Asia/Calcutta")
	private LocalDate endDateTime;
	private Boolean active;

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

	public SurveyDetails(Long id, String description, LocalDate publishedDateTime, LocalDate endDateTime,
			Boolean active) {
		super();
		this.id = id;
		this.description = description;

		this.publishedDateTime = publishedDateTime;
		this.endDateTime = endDateTime;
		this.active = active;
	}

	public SurveyDetails() {
		super();

	}

	public SurveyDetails(SurveyDetails details) {
		this.id = details.getId();
		this.active = details.getActive();
		this.description = details.getDescription();
		this.endDateTime = details.getEndDateTime();
		this.publishedDateTime = details.getPublishedDateTime();
	}

	@Override
	public String toString() {
		return "SurveyDetails [id=" + id + ", description=" + description + ", publishedDateTime=" + publishedDateTime
				+ ", endDateTime=" + endDateTime + ", active=" + active + "]";
	}

}
