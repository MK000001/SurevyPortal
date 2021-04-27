package com.cg.apps.surveyapp.exceptions;

public class InvalidQuestionTextException extends RuntimeException{

    public InvalidQuestionTextException(){

    }

    public InvalidQuestionTextException(String msg){
        super(msg);
    }
}
