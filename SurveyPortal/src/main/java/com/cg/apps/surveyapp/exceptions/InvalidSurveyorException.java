package com.cg.apps.surveyapp.exceptions;

public class InvalidSurveyorException extends RuntimeException{

    public InvalidSurveyorException(){

    }

    public InvalidSurveyorException(String msg){
        super(msg);
    }


}
