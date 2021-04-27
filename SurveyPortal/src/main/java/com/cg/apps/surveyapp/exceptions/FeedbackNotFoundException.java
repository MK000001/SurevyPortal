package com.cg.apps.surveyapp.exceptions;

public class FeedbackNotFoundException extends RuntimeException {

	public FeedbackNotFoundException() {

	}

	public FeedbackNotFoundException(String msg) {
		super(msg);
	}
}
