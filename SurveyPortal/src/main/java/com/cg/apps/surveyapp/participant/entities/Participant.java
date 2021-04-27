package com.cg.apps.surveyapp.participant.entities;

import com.cg.apps.surveyapp.feedback.entities.Feedback;

import java.util.ArrayList;
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

/**
 * One who takes part in survey by posting feedback
 */
@Entity
@Table(name = "participant")
public class Participant {

	@Id
	@GeneratedValue
	@Column(name = "participant_id")
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

	@OneToMany(mappedBy = "participant", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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

	public Participant(Long id, String username, String firstName, String lastName, List<Feedback> feedbacks) {

		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.feedbacks = feedbacks;
	}

	public Participant() {

	}

	public Participant(String username, String firstName, String lastName, List<Feedback> feedbacks) {

		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.feedbacks = feedbacks;
	}

	public Participant(String username, String firstName, String lastName) {

		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Participant(Participant participant) {

	}

	public Participant(Long id2, String firstName2, String lastName2, String username2) {
		this.setId(id2);
		this.setFirstName(firstName2);
		this.setLastName(lastName2);
		this.setUsername(username2);
	}

	@Override
	public String toString() {
		return "Participant [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
	}

	public void addFeedback(Feedback feedback) {
		feedback.setParticipant(this);
		feedbacks.add(feedback);
	}

}
