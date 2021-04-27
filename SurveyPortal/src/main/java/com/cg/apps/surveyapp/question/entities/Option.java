package com.cg.apps.surveyapp.question.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 * not an entity class read about @Embeddable
 */
@Embeddable
public class Option {

	@NotNull
	@Column(name = "optionIndex")
	private Integer optionIndex;
	@NotNull
	@Column(name = "optionText")
	private String optionText;

	public Integer getOptionIndex() {
		return optionIndex;
	}

	public void setOptionIndex(Integer optionIndex) {
		this.optionIndex = optionIndex;
	}

	public String getOptionText() {
		return optionText;
	}

	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}

	public Option() {

	}

	public Option(Integer optionIndex, String optionText) {

		this.optionIndex = optionIndex;
		this.optionText = optionText;
	}

	@Override
	public String toString() {
		return "Option [index=" + optionIndex + ", optionText=" + optionText + "]";
	}

}
