package com.cg.apps.surveyapp.dto;

import java.util.ArrayList;
import java.util.List;

public class ParticipantDetails {
	private Long id;

	private String username;

	private String firstName;

	private String lastName;

	private List<FeedbackDetails> feedbacks = new ArrayList<>();

	public ParticipantDetails() {
		super();
	}

	public ParticipantDetails(Long id, String username, String firstName, String lastName,
			List<FeedbackDetails> feedbacks) {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.feedbacks = feedbacks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<FeedbackDetails> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<FeedbackDetails> feedbacks) {
		this.feedbacks = feedbacks;
	}

	@Override
	public String toString() {
		return "ParticipantDetails [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName="
				+ lastName + ", feedbacks=" + feedbacks + "]";
	}

}
