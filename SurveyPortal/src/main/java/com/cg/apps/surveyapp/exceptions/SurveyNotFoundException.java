package com.cg.apps.surveyapp.exceptions;

public class SurveyNotFoundException extends RuntimeException{

    public SurveyNotFoundException(){
    }

    public SurveyNotFoundException(String msg){
        super(msg);
    }
}
