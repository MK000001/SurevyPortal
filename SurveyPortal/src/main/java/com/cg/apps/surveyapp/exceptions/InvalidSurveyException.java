package com.cg.apps.surveyapp.exceptions;

public class InvalidSurveyException extends RuntimeException{
    public InvalidSurveyException(){

    }

    public InvalidSurveyException(String msg){
        super(msg);
    }
}
