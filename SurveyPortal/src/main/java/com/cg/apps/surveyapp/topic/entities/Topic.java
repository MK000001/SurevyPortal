package com.cg.apps.surveyapp.topic.entities;

import com.cg.apps.surveyapp.survey.entities.Survey;
import com.cg.apps.surveyapp.surveyor.entities.Surveyor;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "topic")
public class Topic {

	@Id
	@GeneratedValue
	@Column(name = "topic_id")
	private Long id;
	@NotBlank
	@Size(min = 2, max = 10, message = "topic must be 2 to 10 characters long")
	private String topicName;
	@Size(min = 5, max = 100, message = "description must be 5 to 100 characters long")
	private String topicDescription;

	@OneToMany(mappedBy = "topic", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Survey> surveys;

	// topic created by
	@ManyToOne()
	@JoinColumn(name = "surveyor_id")
	private Surveyor createdBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public List<Survey> getSurveys() {
		return surveys;
	}

	public void setSurveys(List<Survey> surveys) {
		this.surveys = surveys;
	}

	public Surveyor getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Surveyor createdBy) {
		this.createdBy = createdBy;
	}

	public String getTopicDescription() {
		return topicDescription;
	}

	public void setTopicDescription(String topicDescription) {
		this.topicDescription = topicDescription;
	}

	public Topic() {
		super();

	}

	public Topic(Long id,
			@NotBlank @Size(min = 2, max = 10, message = "topic must be 2 to 10 characters long") String topicName,
			@NotBlank @Size(min = 5, max = 100, message = "description must be 5 to 100 characters long") String topicDescription,
			List<Survey> surveys, Surveyor createdBy) {
		super();
		this.id = id;
		this.topicName = topicName;
		this.topicDescription = topicDescription;
		this.surveys = surveys;
		this.createdBy = createdBy;
	}

	public Topic(@NotBlank @Size(min = 2, max = 10, message = "topic must be 2 to 10 characters long") String topicName,
			@NotBlank @Size(min = 5, max = 100, message = "description must be 5 to 100 characters long") String topicDescription,
			List<Survey> surveys, Surveyor createdBy) {
		super();
		this.topicName = topicName;
		this.topicDescription = topicDescription;
		this.surveys = surveys;
		this.createdBy = createdBy;
	}

	public Topic(@NotBlank @Size(min = 2, max = 10, message = "topic must be 2 to 10 characters long") String topicName,
			@NotBlank @Size(min = 5, max = 100, message = "description must be 5 to 100 characters long") String topicDescription) {
		super();
		this.topicName = topicName;
		this.topicDescription = topicDescription;
	}

	public Topic(Surveyor surveyor, String topicName2) {
		this.setCreatedBy(surveyor);
		this.setTopicName(topicName2);
	}

	public Topic(String topicName2, String topicDescription2, Surveyor createdBy2) {
		this.topicName = topicName2;
		this.topicDescription = topicDescription2;
		this.createdBy = createdBy2;
	}

	@Override
	public String toString() {
		return "Topic [id=" + id + ", topicName=" + topicName + ", topicDescription=" + topicDescription + "]";
	}

}
