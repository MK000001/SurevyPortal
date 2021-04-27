package com.cg.apps.surveyapp.exceptions;

public class SurveyorNotFoundException extends RuntimeException {

    public SurveyorNotFoundException() {
    }

    public SurveyorNotFoundException(String msg) {
        super(msg);
    }
}
