package com.cg.apps.surveyapp.exceptions;

public class InvalidTopicNameException extends RuntimeException {
    public InvalidTopicNameException() {
    }

    public InvalidTopicNameException(String msg) {
        super(msg);
    }

}
