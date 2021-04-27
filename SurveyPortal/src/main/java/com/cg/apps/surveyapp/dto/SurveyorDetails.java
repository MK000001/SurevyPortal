package com.cg.apps.surveyapp.dto;

import java.util.List;

public class SurveyorDetails {
	private Long id;

	private String username;

	private String firstName;

	private String lastName;

	private List<SurveyDetails> createdSurveys;

	public SurveyorDetails() {
		super();
	}

	public SurveyorDetails(Long id, String username, String firstName, String lastName,
			List<SurveyDetails> createdSurveys) {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.createdSurveys = createdSurveys;
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

	public List<SurveyDetails> getCreatedSurveys() {
		return createdSurveys;
	}

	public void setCreatedSurveys(List<SurveyDetails> createdSurveys) {
		this.createdSurveys = createdSurveys;
	}

	@Override
	public String toString() {
		return "SurveyorDetails [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
	}

}
