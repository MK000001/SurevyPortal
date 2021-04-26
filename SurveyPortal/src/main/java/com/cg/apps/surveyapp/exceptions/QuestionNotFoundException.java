package com.cg.apps.surveyapp.exceptions;

public class QuestionNotFoundException extends RuntimeException{
    public QuestionNotFoundException(){

    }

    public QuestionNotFoundException(String msg){
        super(msg);
    }
}
