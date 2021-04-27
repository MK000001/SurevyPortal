package com.cg.apps.surveyapp.pojos;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.cg.apps.surveyapp.survey.entities.Survey;

public class SurveyorRequest {
	private Long id;
	@NotBlank
	@Pattern(regexp = "^[A-Za-z]\\w{5,29}$", message = "username must be 6 to 30 characters long with first letter alphabet")
	private String username;
	@NotBlank
	@Size(min = 2, max = 10, message = "first name must be 2 to 10 characters long")
	private String firstName;
	@NotBlank
	@Size(min = 2, max = 10, message = "last name must be 2 to 10 characters long")
	private String lastName;

	private List<Survey> createdSurveys;

	public SurveyorRequest() {
		super();
	}

	public SurveyorRequest(Long id,
			@NotBlank @Pattern(regexp = "^[A-Za-z]\\w{5,29}$", message = "username must be 6 to 30 characters long with first letter alphabet") String username,
			@NotBlank @Size(min = 2, max = 10, message = "first name must be 2 to 10 characters long") String firstName,
			@NotBlank @Size(min = 2, max = 10, message = "last name must be 2 to 10 characters long") String lastName,
			List<Survey> createdSurveys) {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.createdSurveys = createdSurveys;
	}

	public SurveyorRequest(
			@NotBlank @Pattern(regexp = "^[A-Za-z]\\w{5,29}$", message = "username must be 6 to 30 characters long with first letter alphabet") String username,
			@NotBlank @Size(min = 2, max = 10, message = "first name must be 2 to 10 characters long") String firstName,
			@NotBlank @Size(min = 2, max = 10, message = "last name must be 2 to 10 characters long") String lastName,
			List<Survey> createdSurveys) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.createdSurveys = createdSurveys;
	}

	public SurveyorRequest(
			@NotBlank @Pattern(regexp = "^[A-Za-z]\\w{5,29}$", message = "username must be 6 to 30 characters long with first letter alphabet") String username,
			@NotBlank @Size(min = 2, max = 10, message = "first name must be 2 to 10 characters long") String firstName,
			@NotBlank @Size(min = 2, max = 10, message = "last name must be 2 to 10 characters long") String lastName) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "SurveyorRequest [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
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

	public List<Survey> getCreatedSurveys() {
		return createdSurveys;
	}

	public void setCreatedSurveys(List<Survey> createdSurveys) {
		this.createdSurveys = createdSurveys;
	}

}
