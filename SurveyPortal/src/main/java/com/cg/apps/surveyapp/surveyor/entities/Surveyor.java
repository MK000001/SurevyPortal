package com.cg.apps.surveyapp.surveyor.entities;

import com.cg.apps.surveyapp.survey.entities.Survey;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "surveyor")
public class Surveyor {

	@Id
	@GeneratedValue
	@Column(name = "suryevor_id")
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

	@OneToMany(mappedBy = "postedBy", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Survey> createdSurveys;

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

	public Surveyor() {
	}

	public Surveyor(Long id,
			@NotBlank @Pattern(regexp = "^[A-Za-z]\\w{5,29}$", message = "username must be 6 to 30 characters long with first letter alphabet") String username,
			@NotBlank @Size(min = 2, max = 10, message = "first name must be 2 to 10 characters long") String firstName,
			@NotBlank @Size(min = 2, max = 10, message = "last name must be 2 to 10 characters long") String lastName,
			List<Survey> createdSurveys) {

		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.createdSurveys = createdSurveys;
	}

	public Surveyor(
			@NotBlank @Pattern(regexp = "^[A-Za-z]\\w{5,29}$", message = "username must be 6 to 30 characters long with first letter alphabet") String username,
			@NotBlank @Size(min = 2, max = 10, message = "first name must be 2 to 10 characters long") String firstName,
			@NotBlank @Size(min = 2, max = 10, message = "last name must be 2 to 10 characters long") String lastName,
			List<Survey> createdSurveys) {

		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.createdSurveys = createdSurveys;
	}

	public Surveyor(
			@NotBlank @Pattern(regexp = "^[A-Za-z]\\w{5,29}$", message = "username must be 6 to 30 characters long with first letter alphabet") String username,
			@NotBlank @Size(min = 2, max = 10, message = "first name must be 2 to 10 characters long") String firstName,
			@NotBlank @Size(min = 2, max = 10, message = "last name must be 2 to 10 characters long") String lastName) {

		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Surveyor(Long id2, String username2, String firstName2, String lastName2) {
		this.id = id2;
		this.username = username2;
		this.firstName = firstName2;
		this.lastName = lastName2;
	}

	@Override
	public String toString() {
		return "Surveyor [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ "]";
	}

}
