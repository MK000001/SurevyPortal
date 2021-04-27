package com.cg.apps.surveyapp.dto;

import java.util.List;

public class TopicDetails {
	private Long id;

	private String topicName;

	private String topicDescription;

	private List<SurveyDetails> surveys;

	private SurveyorDetails createdBy;

	public TopicDetails() {
		super();
	}

	public TopicDetails(Long id, String topicName, String topicDescription, List<SurveyDetails> surveys,
			SurveyorDetails createdBy) {
		super();
		this.id = id;
		this.topicName = topicName;
		this.topicDescription = topicDescription;
		this.surveys = surveys;
		this.createdBy = createdBy;
	}

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

	public List<SurveyDetails> getSurveys() {
		return surveys;
	}

	public void setSurveys(List<SurveyDetails> surveys) {
		this.surveys = surveys;
	}

	public SurveyorDetails getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(SurveyorDetails createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public String toString() {
		return "TopicDetails [id=" + id + ", topicName=" + topicName + ", topicDescription=" + topicDescription + "]";
	}

}
