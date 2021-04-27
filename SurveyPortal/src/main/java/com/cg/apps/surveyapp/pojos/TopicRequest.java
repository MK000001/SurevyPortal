package com.cg.apps.surveyapp.pojos;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.cg.apps.surveyapp.survey.entities.Survey;
import com.cg.apps.surveyapp.surveyor.entities.Surveyor;

public class TopicRequest {
	private Long id;
	@NotBlank
	@Size(min = 2, max = 10, message = "topic must be 2 to 10 characters long")
	private String topicName;
	@Size(min = 5, max = 100, message = "description must be 5 to 100 characters long")
	private String topicDescription;

	private List<Survey> surveys;

	// topic created by
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

	public String getTopicDescription() {
		return topicDescription;
	}

	public void setTopicDescription(String topicDescription) {
		this.topicDescription = topicDescription;
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

	public TopicRequest() {
		super();
	}

	public TopicRequest(Long id,
			@NotBlank @Size(min = 2, max = 10, message = "topic must be 2 to 10 characters long") String topicName,
			@Size(min = 5, max = 100, message = "description must be 5 to 100 characters long") String topicDescription,
			List<Survey> surveys, Surveyor createdBy) {
		super();
		this.id = id;
		this.topicName = topicName;
		this.topicDescription = topicDescription;
		this.surveys = surveys;
		this.createdBy = createdBy;
	}

	@Override
	public String toString() {
		return "TopicRequest [id=" + id + ", topicName=" + topicName + ", topicDescription=" + topicDescription
				+ ", surveys=" + surveys + ", createdBy=" + createdBy + "]";
	}

}
