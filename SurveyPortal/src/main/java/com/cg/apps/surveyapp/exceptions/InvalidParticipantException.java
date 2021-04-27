package com.cg.apps.surveyapp.exceptions;

public class InvalidParticipantException extends RuntimeException{

    public InvalidParticipantException(){

    }

    public InvalidParticipantException(String msg){
        super(msg);
    }
}
