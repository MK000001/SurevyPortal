package com.cg.apps.surveyapp.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.cg.apps.surveyapp.feedback.entities.Feedback;

public class ParticipantRequest {
	private Long id;
	@NotBlank
	@Pattern(regexp = "^[A-Za-z]\\w{5,29}$", message = "username must be 6 to 30 characters long with first letter alphabet")
	private String username;
	@NotBlank
	@Size(min = 2, max = 10, message = "first name must be 2 to 10 characters long")
	private String firstName;
	@NotBlank
	@Size(min = 2, max = 10, message = "last name must be 6 to 10 characters long")
	private String lastName;

	private List<Feedback> feedbacks = new ArrayList<>();

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

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public ParticipantRequest() {
		super();
	}

	public ParticipantRequest(Long id,
			@NotBlank @Pattern(regexp = "^[A-Za-z]\\w{5,29}$", message = "username must be 6 to 30 characters long with first letter alphabet") String username,
			@NotBlank @Size(min = 2, max = 10, message = "first name must be 2 to 10 characters long") String firstName,
			@NotBlank @Size(min = 2, max = 10, message = "last name must be 6 to 10 characters long") String lastName,
			List<Feedback> feedbacks) {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.feedbacks = feedbacks;
	}

	@Override
	public String toString() {
		return "ParticipantRequest [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName="
				+ lastName + ", feedbacks=" + feedbacks + "]";
	}
}
